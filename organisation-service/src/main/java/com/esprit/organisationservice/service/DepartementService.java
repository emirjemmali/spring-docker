package com.esprit.organisationservice.service;

import java.util.List;
import java.util.Optional;

import com.esprit.organisationservice.domain.Departement;


public interface DepartementService {

    Departement saveDepartement(Departement departement, int idOrganisation);
    Departement updateDepartement(int id, Departement newDepartement) ;

    List<Departement> getAllDepartements();

  
}

