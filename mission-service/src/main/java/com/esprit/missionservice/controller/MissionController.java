package com.esprit.missionservice.controller;

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
import com.esprit.missionservice.domain.Mission;
import com.esprit.missionservice.repository.MissionRepository;
import com.esprit.missionservice.service.MissionService;

@RestController
@RequestMapping(value = "/missions")
public class MissionController {

	
	 @Autowired
	    private MissionService missionService;

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mission> createMission(@RequestBody Mission mission) {
		return new ResponseEntity<>(missionService.addMission(mission), HttpStatus.OK);
	}
	  @GetMapping()
	    ResponseEntity<List<Mission>> findAllMissions() {

	            List<Mission> missions = missionService.getAllMissions();
	            if (!missions.isEmpty()) {
	                return ResponseEntity.ok(missions);
	            }

	        return ResponseEntity.notFound().build();

	    }
	
	
	}
	

