package be.pxl.ja.streamingservice.repository;

import be.pxl.ja.streamingservice.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository<T extends Account>{
    List<Account> accounts = new ArrayList<>();

    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }

    public Account findAccount(String email) {
        //TODO: afwerken
        return new Account(email, "paswoord");
    }
}
