package com.ensa.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.exceptions.UploadFileException;
import com.ensa.models.Personne;
import com.ensa.models.Role;
import com.ensa.services.interfaces.IPersonneService;

@RestController
@RequestMapping("/admin/personnes")
@CrossOrigin
public class PersonneController {
	
		@Autowired
		IPersonneService personneService;
		
		@GetMapping
		public List<Personne> getPersonnes() {
			return personneService.getPersonnes();
		}
		@GetMapping("/professeurs")
		public List<Personne> getProfesseurs() {
			return personneService.getProfesseurs();
		}
		
		@PostMapping
		public void addPersonne(@RequestBody Personne perso) {
			personneService.addPersonne(perso);
		}
		
		@RequestMapping(value = "/upload",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
			personneService.uploadAvatar(file);
		}
		
		@PutMapping
		public void updatePersonne(@RequestBody Personne emp) {
			personneService.updatePersonne(emp);
		}
		
		@DeleteMapping("/{id}")
		public void deletePersonne(@PathVariable String id) {
			personneService.deletePersonne(id);
		}
		@GetMapping("/{id}")
		public boolean getStatus(@PathVariable String id) {
			return personneService.getStatus(id);
		}
		
	}
