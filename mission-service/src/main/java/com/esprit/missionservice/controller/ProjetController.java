package com.esprit.missionservice.controller;

import com.esprit.missionservice.domain.Mission;
import com.esprit.missionservice.domain.Projet;

import com.esprit.missionservice.service.ProjetService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @PostMapping("/{idMission}")
    public ResponseEntity<Projet> addMission(@RequestBody Projet projet, @PathVariable int idMission) throws ResourceNotFoundException {
        Projet prj= projetService.saveProjet(projet, idMission);
        return ResponseEntity.ok(prj);
    }

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projet> updateProjet(@PathVariable(value = "id") int id,
    										@RequestBody Projet projet){
		return new ResponseEntity<>(projetService.updateProjet(id, projet), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProjet(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(projetService.deleteProjet(id), HttpStatus.OK);
	}
	@GetMapping()
    ResponseEntity<List<Projet>> findAllProjets() {

            List<Projet> projets = projetService.getAllProjets();
            if (!projets.isEmpty()) {
                return ResponseEntity.ok(projets);
            }

        return ResponseEntity.notFound().build();

    }

  
  
}
