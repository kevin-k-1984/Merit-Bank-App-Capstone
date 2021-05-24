package com.meritamerica.assignment7.controllers;

import com.meritamerica.assignment7.Security.JwtUtil;
import com.meritamerica.assignment7.models.AuthenticationRequest;
import com.meritamerica.assignment7.models.AuthenticationResponse;
import com.meritamerica.assignment7.models.User;
import com.meritamerica.assignment7.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LandingController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

//    @GetMapping("/admin")
//    public String home() {
//        return ("<h1>Welcome admin</h1>");
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return ("<h1>Welcome User</h1>");
//    }



    //---------- authentication -------------

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/authenticate/CreateUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User CreateUser(@RequestBody User user) {
        return userDetailsService.StoreUser(user);
    }

}
