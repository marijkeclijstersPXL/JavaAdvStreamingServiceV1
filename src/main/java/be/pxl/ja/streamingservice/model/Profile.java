package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Profile implements Comparable<Profile>{
    private String name;
    private LocalDate dateOfBirth;
    private String avatar;
    private Deque<Content> myList = new LinkedList<>();
    private Deque<Content> currentlyWatching = new LinkedList<>();
    private Deque<Content> recentyWatched = new LinkedList<>();

    public Profile(String name) {
        this.name = name;
        this.avatar = "profile1";
    }

    public Profile(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws InvalidDateException {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth, "date of birth", "Date can't be in the future!");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (dateOfBirth == null) {
            return 0;
        }
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public void startWatching(Content content) {
        //TODO: 1x in verzameling voorkomen !!
        currentlyWatching.offerFirst(content);
    }

    public void finishWatching(Content content) {
        recentyWatched.offerFirst(content);
        currentlyWatching.remove(content);
    }

    public Queue<Content> getRecentlyWatched() {
        return recentyWatched;
    }

    public Deque<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }
    public Deque<Content> getMyList() {
        return  myList;
    }

    public void addToMyList(Content content){
        //TODO wachtlijst: 1x !!
        myList.add(content);
    }

    public boolean isInMyList(Content content) {
        // TODO
        return false;
    }

    public boolean allowedToWatch(Content content) {
        return content.getMaturityRating().getMinimumAge() <= getAge();
    }

    public void removeFromMyList(Content content) {
        myList.remove(content);
    }

    @Override
    public int compareTo(Profile other) {
        return name.compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Profile profile = (Profile) o;

        return getName() != null ? getName().equals(profile.getName()) : profile.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + "'," +
                "age=" + getAge() +
                '}';
    }
}
