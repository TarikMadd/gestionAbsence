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

import com.ensa.models.Matiere;
import com.ensa.services.interfaces.IMatiereService;

@RestController
@RequestMapping("/api/matieres")
@CrossOrigin
public class MatiereController {

	@Autowired
	IMatiereService matiereService;
	
	@GetMapping
	public List<Matiere> getMatieres() {
		return matiereService.getMatieres();
	}
	
	@PostMapping
	public void addMatiere(@RequestBody Matiere m) {
		matiereService.addMatiere(m);
	}
	
	@PutMapping
	public void updateMatiere(@RequestBody Matiere emp) {
		matiereService.updateMatiere(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deletePersonne(@PathVariable String id) {
		matiereService.deleteMatiere(id);
	}
	
	
}
