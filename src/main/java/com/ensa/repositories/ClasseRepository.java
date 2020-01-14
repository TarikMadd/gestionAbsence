package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensa.models.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, String>{

}
