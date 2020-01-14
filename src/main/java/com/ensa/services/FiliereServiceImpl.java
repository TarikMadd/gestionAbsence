package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Filiere;
import com.ensa.repositories.FiliereRepository;
import com.ensa.services.interfaces.IFiliereService;

@Service
public class FiliereServiceImpl implements IFiliereService{

	@Autowired
	private FiliereRepository filiereRepo;
	@Override
	public List<Filiere> getFilieres() {
		// TODO Auto-generated method stub
		return filiereRepo.findAll();
	}

	@Override
	public void addFiliere(Filiere m) {
		// TODO Auto-generated method stub
		filiereRepo.save(m);
	}

	@Override
	public void updateFiliere(Filiere m) {
		// TODO Auto-generated method stub
		filiereRepo.save(m);
	}

	@Override
	public void deleteFiliere(String id) {
		// TODO Auto-generated method stub
		filiereRepo.deleteById(id);
	}
	

}
