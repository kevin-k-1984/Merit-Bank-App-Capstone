package com.meritamerica.MeritBankAppCapstone.services;

import com.meritamerica.MeritBankAppCapstone.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private TransactionRepository transactionRepository;
}
