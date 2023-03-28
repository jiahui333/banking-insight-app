package org.example.jwtconfig;

public class AuthenticationRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}