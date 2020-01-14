package com.ensa.services.interfaces;

import java.util.List;

import com.ensa.models.Filiere;

public interface IFiliereService {


	public List<Filiere> getFilieres();
	public void addFiliere(Filiere m);
	public void updateFiliere(Filiere m);
	public void deleteFiliere(String id);
}
