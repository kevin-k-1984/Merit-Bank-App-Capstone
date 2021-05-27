package com.meritamerica.MeritBankAppCapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> { }
