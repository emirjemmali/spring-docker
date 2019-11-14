package com.esprit.missionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.missionservice.domain.Mission;
import com.esprit.missionservice.domain.Projet;
import com.esprit.missionservice.repository.MissionRepository;
import com.esprit.missionservice.repository.ProjetRepository;

import java.util.List;


@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Projet saveProjet(Projet projet, int idMission) {
        Mission mission=new Mission();
        mission=missionRepository.findById(idMission).get();
        projet.addMission(mission);
        return projetRepository.save(projet);
    }
    
    @Override
    public Projet updateProjet(int id, Projet newProjet) {
		if (projetRepository.findById(id).isPresent()) {
			Projet existingProjet = projetRepository.findById(id).get();
			existingProjet.setNom(newProjet.getNom());
			existingProjet.setDescription(newProjet.getDescription());
			

			return projetRepository.save(existingProjet);
		} else
			return null;
	}
    @Override
	public String deleteProjet(int id) {
		if (projetRepository.findById(id).isPresent()) {
			projetRepository.deleteById(id);
			return "projet supprimé";
		} else
			return "projet non supprimé";
	}
	@Override
	public List<Projet> getAllProjets() {
	     return projetRepository.findAll();
	}

	@Override
	public Projet getProjetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

 


}
