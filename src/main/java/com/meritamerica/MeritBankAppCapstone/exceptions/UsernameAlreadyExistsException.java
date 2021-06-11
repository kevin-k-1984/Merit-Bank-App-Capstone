package com.meritamerica.MeritBankAppCapstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Username Already Exists")
public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() { super("Username already used"); }
}
