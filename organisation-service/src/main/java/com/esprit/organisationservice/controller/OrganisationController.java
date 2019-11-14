package com.esprit.organisationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.organisationservice.domain.Organisation;
import com.esprit.organisationservice.service.OrganisatonService;

@RestController
@RequestMapping(value = "/organisations")
public class OrganisationController {

	
	 @Autowired
	    private OrganisatonService organisationService;

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) {
		return new ResponseEntity<>(organisationService.addOrganisation(organisation), HttpStatus.OK);
	}
	  @GetMapping()
	    ResponseEntity<List<Organisation>> findAllMissions() {

	            List<Organisation> organisations = organisationService.getAllOrganisations();
	            if (!organisations.isEmpty()) {
	                return ResponseEntity.ok(organisations);
	            }

	        return ResponseEntity.notFound().build();

	    }
	
	
	}
	

