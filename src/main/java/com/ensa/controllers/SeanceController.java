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

import com.ensa.models.Sceance;
import com.ensa.services.interfaces.ISceanceService;

@RestController
@RequestMapping("/api/seances")
@CrossOrigin
public class SeanceController {
	
	@Autowired
	private ISceanceService iSceanceService;


	@GetMapping
	public List<Sceance> getSceances() {
		return iSceanceService.getSceances();
	}
	
	@PostMapping
	public void addSceance(@RequestBody Sceance seance) {
		iSceanceService.addSceance(seance);
	}
	
	@PutMapping
	public void updateSceance(@RequestBody Sceance emp) {
		iSceanceService.updateSceance(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSceance(@PathVariable String id) {
		iSceanceService.deleteSceance(id);
	}
}
