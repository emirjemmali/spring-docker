package com.esprit.missionservice.service;

import java.util.List;
import java.util.Optional;

import com.esprit.missionservice.domain.Projet;

public interface ProjetService {

    Projet saveProjet (Projet projet, int idMission);
    Projet updateProjet(int id, Projet newProjet) ;
    String deleteProjet(int id);
    List<Projet> getAllProjets();

    Projet getProjetById(String id);

  
}

