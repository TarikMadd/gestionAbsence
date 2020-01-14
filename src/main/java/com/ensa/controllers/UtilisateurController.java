package com.ensa.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;
import com.ensa.services.interfaces.IRoleService;
import com.ensa.services.interfaces.IUtilisateurService;


@RestController
@RequestMapping("/admin/utilisateurs")
@CrossOrigin
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;

	@Autowired
	IRoleService roleService;
	
	@GetMapping
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.getUtilisateurs();
	}
	
	//@RequestMapping(value = "/generateUser", method = RequestMethod.POST)
	@PostMapping
	public Utilisateur addUtilisateur(@RequestBody Role r) {
		List<Role> roles=new ArrayList<Role>();
		System.out.println(r.getName());
		Role role=roleService.getRole(r.getName());
		if(role !=null) {
			Role role_user = roleService.getRole("ROLE_USER");
			if(role_user !=null) {
				roles.add(role_user);
				roles.add(role);
				return utilisateurService.ajouterUtilisateur(roles);	
			}
		}
		System.out.println("here 10");
		
		return null;
		
	}
	
	@PutMapping
	public void updateUtilisateur(@RequestBody Utilisateur user) {
		System.out.println("i m heres");
		utilisateurService.modifierUtilisateur(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtilisateur(@PathVariable String id) {
		System.out.println(id);
		utilisateurService.supprimerUtilisateur(id);
	}
	
	@RequestMapping(value = "/generatePwd", method = RequestMethod.GET)
	public String genererPwd() {
		return utilisateurService.generatePassword();
	}
	@RequestMapping(value = "/generateLogin", method = RequestMethod.GET)
	public String genererLogin() {
		return utilisateurService.generateLogin();
	}
	
}
