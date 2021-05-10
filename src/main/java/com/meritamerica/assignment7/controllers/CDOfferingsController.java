package com.meritamerica.assignment7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment7.models.CDOffering;
import com.meritamerica.assignment7.services.CDOfferingsService;

@RestController
@RequestMapping("/CDOfferings")
public class CDOfferingsController {

	@Autowired
	private CDOfferingsService cdOfferingsService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<CDOffering> addCDOffering(@RequestBody List<CDOffering> cdOffering) {
		for (CDOffering offer : cdOffering) {
			this.cdOfferingsService.addCDOffering(offer);
		}
		return this.cdOfferingsService.getCDOfferings();
	}
	
	@GetMapping
	public List<CDOffering> getCDOfferings(){
		return cdOfferingsService.getCDOfferings();
	}
	
	@GetMapping("/{id}")
	public CDOffering getCDOfferingById(@PathVariable long id) {
		return this.cdOfferingsService.getCDOfferingById(id);
	}
}
