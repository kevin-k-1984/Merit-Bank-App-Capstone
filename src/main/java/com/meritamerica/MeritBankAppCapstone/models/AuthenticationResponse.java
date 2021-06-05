package com.meritamerica.MeritBankAppCapstone.models;

public class AuthenticationResponse {

    private final String jwt;
    private final String role;

    public AuthenticationResponse(String jwt, String role) {
        this.jwt = jwt;
        this.role = role;
    }

    public String getJwt() {
        return this.jwt;
    }

    public String getRole() {
        return this.role;
    }
}
