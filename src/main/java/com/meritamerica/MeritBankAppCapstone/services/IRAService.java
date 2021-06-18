package com.meritamerica.MeritBankAppCapstone.services;

import com.meritamerica.MeritBankAppCapstone.models.IRAAccount;
import com.meritamerica.MeritBankAppCapstone.repository.IRARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRAService {

    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private IRARepository iraRepository;

    public IRAAccount addIraAccount(IRAAccount iraAccount){
        return this.iraRepository.save(iraAccount);
    }


}
