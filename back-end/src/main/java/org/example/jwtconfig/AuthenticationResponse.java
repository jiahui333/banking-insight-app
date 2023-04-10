package org.example.jwtconfig;

public class AuthenticationResponse {
    private final String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
