package com.meritamerica.MeritBankAppCapstone.controllers;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.AuthenticationRequest;
import com.meritamerica.MeritBankAppCapstone.models.AuthenticationResponse;
import com.meritamerica.MeritBankAppCapstone.models.User;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Contact;

@RestController
public class AuthenticationController {

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
    @ApiOperation(value = "Attempts to authenticate user",
            notes = "returns a JWT token that will be required in the header of all other API calls",
            response = Contact.class)
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
