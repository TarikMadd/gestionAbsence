package com.ensa.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.models.Classe;
import com.ensa.models.Personne;
import com.ensa.repositories.ClasseRepository;
import com.ensa.repositories.PersonneRepository;
import com.ensa.services.interfaces.IClasseService;

@Service
public class ClasseServiceImpl implements IClasseService {

	@Autowired
	private ClasseRepository classeRepo;
	
	@Autowired
	private PersonneRepository persoRepo;
	@Override
	public List<Classe> getClasses() {
		// TODO Auto-generated method stub
		return classeRepo.findAll();
	}

	@Override
	public void addClasse(Classe m) {
		// TODO Auto-generated method stub
		classeRepo.save(m);
	}

	@Override
	public void updateClasse(Classe m) {
		// TODO Auto-generated method stub
		classeRepo.save(m);
	}

	@Override
	public void deleteClasse(String id) {
		// TODO Auto-generated method stub
		classeRepo.deleteById(id);
	}

	@Override
	public List<Personne> generateStudents(MultipartFile file) throws IllegalStateException, IOException{
		// TODO Auto-generated method stub
		List<Personne> students=new ArrayList<Personne>();
		Personne student=new Personne();
		String line = "";
		file.transferTo(new File("D:\\files\\" + file.getOriginalFilename()));
		try {
			BufferedReader br;
			br = new BufferedReader( new FileReader("D:\\files\\" + file.getOriginalFilename()));
			while((line = br.readLine())!=null)
			{
				String [] data  =line.split(",");
				Personne etudiant = new Personne();
			   // etudient.setId((long) Integer.parseInt(data[0]));
				etudiant.setNom(data[0]);
				etudiant.setPrenom(data[1]);
				etudiant.setCin(data[2]);
				etudiant.setCin(data[2]);
				etudiant.setCin(data[2]);
				etudiant.setCin(data[2]);
				etudiant.setCin(data[2]);
				//etudiant.setNom(data[3]);
				student=persoRepo.save(etudiant);
				if(student !=null) {
					students.add(student);
				}
				
			}
			br.close();
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	

}
