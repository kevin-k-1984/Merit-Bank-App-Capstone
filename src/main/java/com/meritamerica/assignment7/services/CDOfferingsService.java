package com.meritamerica.assignment7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.models.CDOffering;
import com.meritamerica.assignment7.repository.CDOfferRepository;

@Service
public class CDOfferingsService {
	
	@Autowired
	private CDOfferRepository cdOfferRepository;

	public CDOffering addCDOffering(CDOffering cdOffering) {
		return this.cdOfferRepository.save(cdOffering);
	}

	public List<CDOffering> getCDOfferings() {
		return this.cdOfferRepository.findAll();
	}
	
	public CDOffering getCDOfferingById(long id) {
		return this.cdOfferRepository.findById(id).orElse(null);
	}

}
