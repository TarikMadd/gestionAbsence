package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Matiere;
import com.ensa.repositories.MatiereRepository;
import com.ensa.services.interfaces.IMatiereService;

@Service
public class MatiereServiceImpl implements IMatiereService{

	@Autowired
	private MatiereRepository matiereRepo;
	@Override
	public List<Matiere> getMatieres() {
		// TODO Auto-generated method stub
		return matiereRepo.findAll();
	}

	@Override
	public void addMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		matiereRepo.save(matiere);
	}

	@Override
	public void updateMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		matiereRepo.save(matiere);
	}

	@Override
	public void deleteMatiere(String id) {
		// TODO Auto-generated method stub
		matiereRepo.deleteById(id);
		
	}
}
