package com.ensa.services.interfaces;


import java.util.List;

import com.ensa.models.Role;


public interface IRoleService {
	public List<Role> getRoles();
	public void addRole(Role role);
	public void updateRole(Role role);
	public void deleteRole(String id);
	public Role getRole(String role);
}
