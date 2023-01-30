package org.example.models;

public class AccountHolder {
    private String firstName;
    private String secondName;

    private String email;

    public AccountHolder(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
