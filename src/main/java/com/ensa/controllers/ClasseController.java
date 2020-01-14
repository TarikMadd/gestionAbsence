package com.ensa.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.models.Classe;
import com.ensa.models.Personne;
import com.ensa.services.interfaces.IClasseService;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin
public class ClasseController {
	
	@Autowired
	IClasseService classeService;
	
	@GetMapping
	public List<Classe> getClasses() {
		return classeService.getClasses();
	}
	
	@PostMapping
	public void addClasse(@RequestBody Classe m) {
		classeService.addClasse(m);
	}
	
	@PostMapping("/upload")
	public List<Personne> uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException
	{
		return classeService.generateStudents(file);
	}
	@PutMapping
	public void updateClasse(@RequestBody Classe emp) {
		classeService.updateClasse(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClasse(@PathVariable String id) {
		classeService.deleteClasse(id);
	}
	
	
}
