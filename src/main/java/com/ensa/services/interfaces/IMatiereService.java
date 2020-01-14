package com.ensa.services.interfaces;

import java.util.List;

import com.ensa.models.Matiere;
import com.ensa.models.Role;

public interface IMatiereService {

	public List<Matiere> getMatieres();
	public void addMatiere(Matiere m);
	public void updateMatiere(Matiere m);
	public void deleteMatiere(String id);
	//public Role getMatiere(String role);
}
