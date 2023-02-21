package org.example.models;

public class User {
    private String firstName;
    private String secondName;
    private String username;
    private String password;

    public User(String firstname, String secondname, String username, String password) {
        this.firstName = firstname;
        this.secondName = secondname;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}
