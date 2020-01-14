package com.ensa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.models.Module;
import com.ensa.repositories.ModuleRepository;
import com.ensa.services.interfaces.IModuleService;

@Service
public class ModuleServiceImpl implements IModuleService{

	@Autowired
	private ModuleRepository moduleRepo;
	@Override
	public List<Module> getModules() {
		// TODO Auto-generated method stub
		return moduleRepo.findAll();
	}

	@Override
	public void addModule(Module m) {
		// TODO Auto-generated method stub
		moduleRepo.save(m);
	}

	@Override
	public void updateModule(Module m) {
		// TODO Auto-generated method stub
		moduleRepo.save(m);
	}

	@Override
	public void deleteModule(String id) {
		// TODO Auto-generated method stub
		moduleRepo.deleteById(id);
	}
	

}
