package com.esprit.missionservice.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    @ManyToOne
    private Mission mission;
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public Projet(String nom, String description, Mission mission) {
		super();
		this.nom = nom;
		this.description = description;
		this.mission = mission;
	}
	public Projet() {
		super();
	}
	public Projet addMission(Mission mission){
        this.mission=mission;
        return this;
    }

  
}
