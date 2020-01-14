package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.models.Filiere;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, String>{

}
