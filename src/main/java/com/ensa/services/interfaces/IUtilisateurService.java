package com.ensa.services.interfaces;

import java.util.List;

import com.ensa.models.Role;
import com.ensa.models.Utilisateur;


public interface IUtilisateurService {

	public List<Utilisateur> getUtilisateurs();
	public Utilisateur ajouterUtilisateur(List<Role> role);
	public void modifierUtilisateur(Utilisateur user);
	public void supprimerUtilisateur(String id);
	public void changerStatus(String id,boolean status);
	public String generateLogin();
	public String generatePassword();
}
