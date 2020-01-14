package com.ensa.services.interfaces;

import java.util.List;

import com.ensa.models.Sceance;

public interface ISceanceService {

	public List<Sceance> getSceances();
	public void addSceance(Sceance m);
	public void updateSceance(Sceance m);
	public void deleteSceance(String id);
}
