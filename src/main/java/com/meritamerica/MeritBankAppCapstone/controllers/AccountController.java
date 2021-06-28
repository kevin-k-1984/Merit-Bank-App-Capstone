package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.exceptions.UserNotFoundException;
import com.meritamerica.MeritBankAppCapstone.models.ContactDetails;
import com.meritamerica.MeritBankAppCapstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.services.AccountHolderService;

@RestController
public class AccountController {

    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private JwtUtil jwtUtil;

    // ------ POSTs -------
    @PostMapping("/user/AccountHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(
            @RequestHeader("authorization") String auth,
            @RequestBody AccountHolderDTO accountHolderDTO) {

        User user = this.jwtUtil.getUserFromToken(auth);

        ContactDetails contact = new ContactDetails(
                accountHolderDTO.getEmail(),
                accountHolderDTO.getPhone()
        );

        AccountHolder acc = new AccountHolder(
                accountHolderDTO.getFirstName(),
                accountHolderDTO.getMiddleName(),
                accountHolderDTO.getLastName(),
                accountHolderDTO.getSsn()
        );

        acc.setUser(user);
        acc.setContact(contact);

        return this.accountHolderService.addAccountHolder(acc);
    }

    // ----- GETs -----
    @GetMapping("/admin/AccountHolders")
    public List<AccountHolder> getListOfAccountHolders() {
        return this.accountHolderService.getAccountHolders();
    }

    @GetMapping("/user/AccountHolder")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccountHolder getAccountHolder(@RequestHeader("authorization") String auth) throws UserNotFoundException {
        User user = this.jwtUtil.getUserFromToken(auth);
        if (user.getAccountHolder() == null) throw new UserNotFoundException("User does not have account information");

        return user.getAccountHolder();
    }

    public void DoSomething() {}

    // ----- DTO -----
    public static class AccountHolderDTO {

        private String firstName;
        private String middleName;
        private String lastName;
        private String ssn;
        private String email;
        private String phone;

        public AccountHolderDTO() {
        }

        public AccountHolderDTO(String firstName, String middleName, String lastName, String ssn, String email, String phone) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.email = email;
            this.phone = phone;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
