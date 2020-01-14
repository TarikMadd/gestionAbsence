package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.models.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, String>{

}
