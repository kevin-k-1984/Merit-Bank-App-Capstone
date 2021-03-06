package com.meritamerica.MeritBankAppCapstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceedsAvailableBalanceException extends Exception {
    public ExceedsAvailableBalanceException(String message) { super(message); }
}