package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Production;
import com.backend.service.backendservice.model.ProductionSite;
import com.backend.service.backendservice.repository.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionService {

	@Autowired
	private ProductionRepo repo;

	public Integer totalEnergy() {
		return repo.totalEnergy();
	}

	public Integer energyEolien() {
		return repo.energyEolien();
	}
	public Integer energyHydraulique() {
		return repo.energyHydraulique();
	}
	public Integer energySolaire() {return repo.energySolaire();}

	public List<Map<String,String>> energyBySite() {return repo.energyBySite();}

	//find all sites along with their current production
	public List<Map<String,Object>> productionPerSite() {
		return repo.ProductionPerSite();}

	public void deleteProduction() {
		repo.deleteProduction();
	} 

	public Integer totalProduction() {return repo.totalProduction();}
}
