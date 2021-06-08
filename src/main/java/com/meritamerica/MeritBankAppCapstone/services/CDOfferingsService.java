package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.CDOffering;
import com.meritamerica.MeritBankAppCapstone.repository.CdOfferingRepository;

@Service
public class CDOfferingsService {
	
	@Autowired
	private CdOfferingRepository cdOfferingRepository;

	public CDOffering addCDOffering(CDOffering cdOffering) {
		return this.cdOfferingRepository.save(cdOffering);
	}

	public List<CDOffering> getCDOfferings() {
		return this.cdOfferingRepository.findAll();
	}
	
	public CDOffering getCDOfferingById(long id) {
		return this.cdOfferingRepository.findById(id).orElse(null);
	}

}
