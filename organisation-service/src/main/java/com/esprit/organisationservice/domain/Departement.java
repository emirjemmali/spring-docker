package com.esprit.organisationservice.domain;




import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String adresse;
    private String nom;
   
    @ManyToOne
    private Organisation organisation;
	public int getId() {
		return id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Organisation getOrganisation() {
		return organisation;
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public Departement(int id, String adresse, String nom, Organisation organisation) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.nom = nom;
		this.organisation = organisation;
	}
	public Departement() {
		super();
	}
	public Departement addDepartement(Organisation organisation){
        this.organisation=organisation;
        return this;
    }

  
}
