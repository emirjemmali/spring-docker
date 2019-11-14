package com.esprit.organisationservice.service;

import java.util.List;

import com.esprit.organisationservice.domain.Organisation;


public interface OrganisatonService {
	Organisation addOrganisation(Organisation organisation);
	List<Organisation> getAllOrganisations();
}
