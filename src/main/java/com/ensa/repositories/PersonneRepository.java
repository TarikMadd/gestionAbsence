package com.ensa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ensa.models.Personne;
import com.ensa.models.Utilisateur;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String>{

	List<Personne> findByUtilisateur(List<Utilisateur> utilisateur);
	Personne findByEmail(String emailEmployee);
	Optional<Personne> findById(String id);
	
	@Query("Select a from Personne a left join Utilisateur b on a.utilisateur.id=b.id WHERE b.enable=true")
	public List<Personne> findActiveUsers();
//	
}
