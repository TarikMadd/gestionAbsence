package com.ensa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{

	Utilisateur findByUsername(String username);
	Optional<Utilisateur> findById(String idString);
	List<Utilisateur> findByRoles(Role role);
	
	
	
}
