package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;
import com.ensa.repositories.RoleRepository;
import com.ensa.repositories.UtilisateurRepository;
import com.ensa.services.interfaces.IUtilisateurService;
import com.mifmif.common.regex.Generex;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService{

	private String regExp;
	private Generex generex;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Utilisateur> getUtilisateurs() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur ajouterUtilisateur(List<Role> roles) {
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		user.setPassword(generatePassword());
		user.setUsername(generateLogin());
		user.setEnable(true);
		user.setRoles(roles);
		return utilisateurRepository.save(user);
	}

	@Override
	public void modifierUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur;
		//if(utilisateurRepository.findByUserId(id) !=null) {
			//user=utilisateurRepository.findById(user.getId()).get();
			//if(user !=null) {
				System.out.println("yooo---> "+user);
				utilisateurRepository.save(user);
			//}
	}

	@Override
	public void supprimerUtilisateur(String id) {
		// TODO Auto-generated method stub
		Utilisateur user;
		//if(utilisateurRepository.findByUserId(id) !=null) {
			user=utilisateurRepository.findById(id).get();
			utilisateurRepository.delete(user);
		//}
		//else {
			//handle exception
			//System.out.println("error deleting...");
		//}
	}

	@Override
	public void changerStatus(String id,boolean status) {
		// TODO Auto-generated method stub
		Utilisateur user;
		if(utilisateurRepository.findById(id) !=null) {
			user=utilisateurRepository.findById(id).get();
			user.setEnable(status);
			utilisateurRepository.save(user);
		}
		else {
			//handle exception
		}
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		regExp ="[a-zA-Z0-9]{6}";
		generex = new Generex(regExp);
		String result = generex.random();
		return result;
	}
	
	@Override
	public String generateLogin() {
		// TODO Auto-generated method stub
		String result=null;
		String tmp=null;
		while(result==null) {
			regExp ="(ensa)[a-zA-Z0-9]{4}";
			generex = new Generex(regExp);
			tmp = generex.random();
			if(utilisateurRepository.findByUsername(tmp)==null) {
				result = tmp;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//IUtilisateurService iUtilisateurService = new UtilisateurServiceImpl();
	// 	System.out.println(iUtilisateurService.generatePassword("xsddc"));
	}

	

}
