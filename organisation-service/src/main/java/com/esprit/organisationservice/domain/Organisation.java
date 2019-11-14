package com.esprit.organisationservice.domain;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Organisation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
   
    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Departement> departements;
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
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Organisation(int id, String nom, String description, List<Departement> departements) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.departements = departements;
	}
	public Organisation() {
		super();
	}

	
  
}
