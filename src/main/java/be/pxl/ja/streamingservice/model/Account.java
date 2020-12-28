package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public static final int MINIMUM_PASSWORD_STRENGTH = 5;
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();

    public Account(String email, String password) {
        this.email = email;
        setPassword(password);
        profiles.add(new Profile("Profile1"));
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = PasswordUtil.encodePassword(password);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public int getNumberOfProfiles() {
        return profiles.size();
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
