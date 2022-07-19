package com.example.UserService.Model;

import java.io.Serializable;
import java.util.Collection;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final String username;
    private final Collection<?> roles;
    public String getUsername() {
        return username;
    }

    public Collection<?> getRoles() {
        return roles;
    }

    public AuthenticationResponse(String jwt, String username, Collection<?> roles){
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
    }

    public String getJwt(){
        return jwt;
    }
}
