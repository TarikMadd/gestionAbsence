package com.ensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.models.Module;
import com.ensa.services.interfaces.IMatiereService;
import com.ensa.services.interfaces.IModuleService;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin
public class ModuleController {

	@Autowired
	IModuleService moduleService;
	
	@GetMapping
	public List<Module> getMatieres() {
		return moduleService.getModules();
	}
	
	@PostMapping
	public ResponseEntity addModule(@RequestBody Module m) {
		moduleService.addModule(m);
		return new ResponseEntity(m,HttpStatus.OK);
	}
	
	@PutMapping
	public void updateMatiere(@RequestBody Module emp) {
		moduleService.updateModule(emp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteModule(@PathVariable String id) {
		moduleService.deleteModule(id);
	}
	
	
}
