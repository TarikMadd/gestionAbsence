package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Sceance;
import com.ensa.repositories.SeanceRepository;
import com.ensa.services.interfaces.ISceanceService;

@Service
public class SceanceServiceImpl implements ISceanceService{

	@Autowired
	private SeanceRepository seanceRepo;
	@Override
	public List<Sceance> getSceances() {
		// TODO Auto-generated method stub
		return seanceRepo.findAll();
	}

	@Override
	public void addSceance(Sceance m) {
		// TODO Auto-generated method stub
		seanceRepo.save(m);
	}

	@Override
	public void updateSceance(Sceance m) {
		// TODO Auto-generated method stub
		seanceRepo.save(m);
	}

	@Override
	public void deleteSceance(String id) {
		// TODO Auto-generated method stub
		seanceRepo.deleteById(id);
	}
	

}
