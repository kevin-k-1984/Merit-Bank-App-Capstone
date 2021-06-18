package com.meritamerica.MeritBankAppCapstone.controllers;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.IRAAccount;
import com.meritamerica.MeritBankAppCapstone.models.User;
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

    @PostMapping("/user/addIRAAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addIRAAccount(@RequestHeader("authorization") String auth, @RequestBody IRAAccountDTO iraAccountDTO) throws RuntimeException {
        User user = this.jwtUtil.getUserFromToken(auth);
        IRAAccount iraAccount = new IRAAccount(iraAccountDTO.getBalance(), iraAccountDTO.getType());

        boolean hasType = false;
        for (IRAAccount acc : user.getAccountHolder().getIraAccounts()) {
            if (acc.getType().equals(iraAccountDTO.getType())){
                throw new RuntimeException();
            }
        }

        iraAccount.setAccountHolder(user.getAccountHolder());
        user.getAccountHolder().getIraAccounts().add(iraAccount);

        this.iraService.addIraAccount(iraAccount);

        return user.getAccountHolder();
    }

    @PostMapping("/user/deleteIRAAccount")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteIRAAccount(@RequestHeader("authorization") String auth, @RequestBody IRAAccount iraAccount) {

        return false;
    }

    public static class IRAAccountDTO {

        private double balance;
        private String type;

        public IRAAccountDTO() {}

        public IRAAccountDTO(double balance, String type) {
            this.balance = balance;
            this.type = type;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
