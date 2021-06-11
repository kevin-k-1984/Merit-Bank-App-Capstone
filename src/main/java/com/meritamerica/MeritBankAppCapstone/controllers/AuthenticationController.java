package com.meritamerica.MeritBankAppCapstone.controllers;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.*;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    //---------- authentication -------------

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password", e);
        }

        final MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getRole()));
    }

    @PostMapping("/authenticate/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User CreateUser(@RequestBody User user) {
        return this.userDetailsService.StoreUser(user);
    }
}
