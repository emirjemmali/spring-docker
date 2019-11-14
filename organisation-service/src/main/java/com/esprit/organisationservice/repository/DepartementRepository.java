package com.esprit.organisationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.organisationservice.domain.Departement;


@Repository
public interface DepartementRepository extends JpaRepository<Departement,Integer> {

}
