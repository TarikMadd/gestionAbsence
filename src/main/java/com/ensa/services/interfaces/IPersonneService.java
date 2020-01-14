package com.ensa.services.interfaces;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ensa.models.Personne;

public interface IPersonneService {

	public List<Personne> getPersonnes();
	public List<Personne> getProfesseurs();
	public void addPersonne(Personne emp);
	public void updatePersonne(Personne emp);
	public void deletePersonne(String id);
	public void uploadAvatar(MultipartFile file) throws IOException;
	public boolean getStatus(String id);
	public Personne selectPersonneByEmail(String email);

}
