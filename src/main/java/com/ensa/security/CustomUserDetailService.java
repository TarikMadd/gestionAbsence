package com.ensa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;
import com.ensa.repositories.UtilisateurRepository;



@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UtilisateurRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur user = userRepository.findByUsername(str);
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		boolean accountNonExpired=true; 
		boolean credentialsNonExpired = true;
		
		boolean accountNonLocked = true;
		UserDetails userDetails=null;
		if(user.isEnable()) {
			userDetails= new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(), 
					user.isEnable(), 
					accountNonExpired, 
					credentialsNonExpired, 
					accountNonLocked, 
					getAuthorities(user.getRoles()));
		}
		return userDetails;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : roles) {
		//	System.out.println(role.getName());
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());//Role_*
			authorities.add(authority);
		}
		return authorities;
	}

}
