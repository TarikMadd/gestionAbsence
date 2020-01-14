package com.ensa.services.interfaces;

import java.util.List;

import com.ensa.models.Module;

public interface IModuleService {
	
	public List<Module> getModules();
	public void addModule(Module m);
	public void updateModule(Module m);
	public void deleteModule(String id);

}
