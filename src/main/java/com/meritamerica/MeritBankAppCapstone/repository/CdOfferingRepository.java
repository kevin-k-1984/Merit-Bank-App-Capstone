package com.meritamerica.MeritBankAppCapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.CDOffering;

//@RepositoryRestResource(path = "CDOfferings")
public interface CdOfferingRepository extends JpaRepository<CDOffering, Long>{
}
