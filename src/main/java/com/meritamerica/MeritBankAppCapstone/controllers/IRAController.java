package com.meritamerica.MeritBankAppCapstone.controllers;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.IRAAccount;
import com.meritamerica.MeritBankAppCapstone.services.IRAService;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class IRAController {

    @Autowired
    private IRAService iraService;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    // ------- POSTs ---------

    @PostMapping("/user/addIRAAccount/{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public IRAAccount addIRAAccount(@RequestHeader("authoriaztion") String auth, @PathVariable String type) {
        return new IRAAccount();
    }

    @PostMapping("/user/deleteIRAAccount")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteIRAAccount(@RequestHeader("authorization") String auth, @RequestBody IRAAccount account) {
        return false;
    }
}
