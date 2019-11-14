package com.esprit.clientservice.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Client  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

   
    private String firstName;

    private String lastName;

    private String birthDay;

    private String sexe;

    private String nationalite;

	public String getId() {
		return id;
	}



	public Client() {
		super();
	}



	public Client(String id, String firstName, String lastName, String birthDay, String sexe, String nationalite) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.sexe = sexe;
		this.nationalite = nationalite;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

    
}
