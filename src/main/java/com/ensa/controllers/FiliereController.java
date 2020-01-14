package com.ensa.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.ensa.models.Filiere;
import com.ensa.services.interfaces.IFiliereService;

@RestController
@RequestMapping("/api/filieres")
@CrossOrigin
public class FiliereController {

	@Autowired
	IFiliereService filiereService;
	
	@GetMapping
	public List<Filiere> getFilieres() {
		return filiereService.getFilieres();
	}
	
	@PostMapping
	public void addClasse(@RequestBody Filiere m) {
		filiereService.addFiliere(m);
	}
	
	@PutMapping
	public void updateFiliere(@RequestBody Filiere emp) {
		filiereService.updateFiliere(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClasse(@PathVariable String id) {
		filiereService.deleteFiliere(id);
	}
	
	
}
