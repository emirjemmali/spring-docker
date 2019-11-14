package com.esprit.organisationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.organisationservice.domain.Departement;
import com.esprit.organisationservice.service.DepartementService;


@RestController
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @PostMapping("/{idOrganisation}")
    public ResponseEntity<Departement> addMission(@RequestBody Departement dep, @PathVariable int idOrganisation) throws ResourceNotFoundException {
        Departement depa= departementService.saveDepartement(dep, idOrganisation);
        return ResponseEntity.ok(depa);
    }

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Departement> updateDepartement(@PathVariable(value = "id") int id,
    										@RequestBody Departement dep){
		return new ResponseEntity<>(departementService.updateDepartement(id, dep), HttpStatus.OK);
	}
	
	
	
	@GetMapping()
    ResponseEntity<List<Departement>> findAllProjets() {

            List<Departement> departements = departementService.getAllDepartements();
            if (!departements.isEmpty()) {
                return ResponseEntity.ok(departements);
            }

        return ResponseEntity.notFound().build();

    }

  
  
}
