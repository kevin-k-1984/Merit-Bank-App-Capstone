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
public class CDOfferingsController {

	@Autowired
	private CDOfferingsService cdOfferingsService;

	// ----- Posts -----
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) {
		return this.cdOfferingsService.addCDOffering(cdOffering);
	}

	// ----- Gets -----
	@GetMapping("/CDOfferings")
	public List<CDOffering> getCDOfferings(){
		return cdOfferingsService.getCDOfferings();
	}
}
