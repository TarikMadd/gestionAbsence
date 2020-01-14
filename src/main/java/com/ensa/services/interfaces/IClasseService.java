package com.ensa.services.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ensa.models.Classe;
import com.ensa.models.Personne;

public interface IClasseService {

	public List<Classe> getClasses();
	public void addClasse(Classe m);
	public void updateClasse(Classe m);
	public void deleteClasse(String id);
	public List<Personne> generateStudents(MultipartFile file) throws IllegalStateException, IOException;
	
}
