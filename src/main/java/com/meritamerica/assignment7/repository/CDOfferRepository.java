package com.meritamerica.assignment7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment7.models.CDOffering;

//@RepositoryRestResource(path = "CDOfferings")
public interface CDOfferRepository extends JpaRepository<CDOffering, Long>{
}
