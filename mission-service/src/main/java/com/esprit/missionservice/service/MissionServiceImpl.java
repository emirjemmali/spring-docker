package com.esprit.missionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.missionservice.domain.Mission;
import com.esprit.missionservice.repository.MissionRepository;

import java.util.List;


@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionRepository missionRepository;
    
	public Mission addMission(Mission mission) {
		return missionRepository.save(mission);
	}
	 @Override
	    public List<Mission> getAllMissions() {
	        return missionRepository.findAll();
	    }
}
