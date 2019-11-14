package com.esprit.organisationservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Service;

import com.esprit.organisationservice.domain.Departement;
import com.esprit.organisationservice.domain.Organisation;
import com.esprit.organisationservice.repository.DepartementRepository;
import com.esprit.organisationservice.repository.OrganisationRepository;

import java.util.List;


@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public Departement saveDepartement(Departement departement, int idOrganisation) {
        Organisation organisation=new Organisation();
        organisation=organisationRepository.findById(idOrganisation).get();
        departement.addDepartement(organisation);
        return departementRepository.save(departement);
    }
    
    @Override
    public Departement updateDepartement(int id,Departement newDepartement) {
		if (departementRepository.findById(id).isPresent()) {
			Departement existingDep = departementRepository.findById(id).get();
			existingDep.setNom(newDepartement.getNom());
			existingDep.setAdresse(newDepartement.getAdresse());
			

			return departementRepository.save(existingDep);
		} else
			return null;
	}
    
	@Override
	public List<Departement> getAllDepartements() {
	     return departementRepository.findAll();
	}


 


}
