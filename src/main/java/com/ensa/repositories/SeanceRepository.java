package com.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.models.Sceance;

public interface SeanceRepository extends JpaRepository<Sceance, String> {

}
