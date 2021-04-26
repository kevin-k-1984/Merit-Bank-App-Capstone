package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.meritamerica.assignment6.models.CDAccount;

@RepositoryRestResource(path = "CDAccounts")
public interface CDAccountRepository extends JpaRepository<CDAccount, Long>{

}
