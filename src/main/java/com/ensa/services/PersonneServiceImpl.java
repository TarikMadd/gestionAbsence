package com.ensa.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.models.Personne;
import com.ensa.models.Role;
import com.ensa.models.Utilisateur;
import com.ensa.repositories.PersonneRepository;
import com.ensa.repositories.RoleRepository;
import com.ensa.repositories.UtilisateurRepository;
import com.ensa.services.interfaces.IPersonneService;

@Service
public class PersonneServiceImpl implements IPersonneService{
	private static final String FILE_DIRECTORY = "D:/files/";
	 private final Path location = Paths.get("upload");
	@Autowired
	private PersonneRepository personneRepo;
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	@Override
	public List<Personne> getPersonnes() {
		// TODO Auto-generated method stub
		return personneRepo.findAll();
	}

	@Override
	public void addPersonne(Personne emp) {
		// TODO Auto-generated method stub
		personneRepo.save(emp);
	}

	@Override
	public void updatePersonne(Personne emp) {
		// TODO Auto-generated method stub
		personneRepo.save(emp);
	}

	@Override
	public void deletePersonne(String id) {
		// TODO Auto-generated method stub
		personneRepo.deleteById(id);
		
	}

	@Override
	public Personne selectPersonneByEmail(String email) {
		// TODO Auto-generated method stub
		return personneRepo.findByEmail(email);
	}

	@Override
	public boolean getStatus(String id) {
		// TODO Auto-generated method stub
		Personne personne=personneRepo.findById(id).get();
		if(personne.getUtilisateur()!=null) {
			return personne.getUtilisateur().isEnable();
		}
		return false;
	}

	@Override
	public List<Personne> getProfesseurs() {
		// TODO Auto-generated method stub
		Role role=roleRepo.findByName("ROLE_ADMIN");
		List<Personne> personnes=new ArrayList<Personne>();
		List<Personne> activeUsers=personneRepo.findActiveUsers();
		for(Personne personne:activeUsers) {
			if(personne.getUtilisateur().getRoles().contains(role)) {
				personnes.add(personne);
			}
		}
		return personnes;
	}

	@Override
	public void uploadAvatar(MultipartFile file) throws IOException{
		// TODO Auto-generated method stub
		Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
		 
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


	}

	
}
