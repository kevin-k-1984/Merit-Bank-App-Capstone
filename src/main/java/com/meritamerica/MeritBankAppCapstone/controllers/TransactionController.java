package com.meritamerica.MeritBankAppCapstone.controllers;

import com.meritamerica.MeritBankAppCapstone.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    // ------- POSTs ------------
    @PostMapping("/user/addTransaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestHeader("authorization") String auth, @RequestBody Transaction transaction) {
        return new Transaction();
    }
}
