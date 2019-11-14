package com.esprit.organisationservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.organisationservice.domain.Organisation;
import com.esprit.organisationservice.repository.OrganisationRepository;




@Service
public class OrganisationServiceImpl implements OrganisatonService {

    @Autowired
    private OrganisationRepository organisationRepository;
    @Override
	public Organisation addOrganisation(Organisation organisation) {
		return organisationRepository.save(organisation);
	}
	 @Override
	    public List<Organisation> getAllOrganisations() {
	        return organisationRepository.findAll();
	    }
}
