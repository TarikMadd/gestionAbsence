package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Role;
import com.ensa.repositories.RoleRepository;
import com.ensa.services.interfaces.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void deleteRole(String id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

	@Override
	public Role getRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(role);
	}

}
