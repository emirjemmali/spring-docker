package com.esprit.missionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.missionservice.domain.Mission;




@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer> {

}
