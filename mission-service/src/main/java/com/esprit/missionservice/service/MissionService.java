package com.esprit.missionservice.service;

import java.util.List;

import com.esprit.missionservice.domain.Mission;

public interface MissionService {
	Mission addMission(Mission mission);
	List<Mission> getAllMissions();
}
