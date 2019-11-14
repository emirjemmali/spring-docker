package com.esprit.missionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.missionservice.domain.Projet;



@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {

}
