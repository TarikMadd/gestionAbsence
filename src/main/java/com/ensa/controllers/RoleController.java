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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.models.Role;
import com.ensa.services.interfaces.IRoleService;


@RestController
@RequestMapping("/admin/roles")
@CrossOrigin
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	@GetMapping
	public List<Role> getRoles() {
		return roleService.getRoles();
	}
	
	@PostMapping
	public void addRole(@RequestBody Role role) {
		roleService.addRole(role);
	}
	
	@PutMapping
	public void updateRole(@RequestBody Role role) {
		roleService.updateRole(role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable String id) {
		roleService.deleteRole(id);
	}
	
	
	@RequestMapping(value = "/generateUser", method = RequestMethod.POST)
	public Role getRole(@RequestBody String r) {
		return roleService.getRole(r);
	}
}
