package com.meritamerica.assignment7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment7.models.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> { }
