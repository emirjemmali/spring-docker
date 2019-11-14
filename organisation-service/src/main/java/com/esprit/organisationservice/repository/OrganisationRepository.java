package com.esprit.organisationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.organisationservice.domain.Organisation;


@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Integer> {

}
