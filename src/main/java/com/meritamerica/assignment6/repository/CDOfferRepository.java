package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment6.models.CDOffering;

//@RepositoryRestResource(path = "CDOfferings")
public interface CDOfferRepository extends JpaRepository<CDOffering, Long>{
}
