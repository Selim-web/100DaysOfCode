package com.backend.service.backendservice.controller;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.service.backendservice.model.Eco_district;
import com.backend.service.backendservice.service.EntityService;
import com.backend.service.backendservice.service.ProductionService;
import com.backend.service.backendservice.service.ProductionSiteService;

@RestController
@RequestMapping("/entity")
public class EntityController {

	@Autowired
	private EntityService service;
	@Autowired
	private ProductionSiteService prod_site_service;
	@Autowired
	private ProductionService production_service;

	/**
	 * Create - Add a new company
	 *
	 * @param company An object company
	 * @return The company object saved
	 */
	@GetMapping("/distCons/{id}")
	public Integer distCons(@PathVariable("id") final Integer id) {
		return service.districtCons(id);
	}
	@GetMapping("/distProd/{id}")
	public Integer distProd(@PathVariable("id") final Integer id) {
		return service.districtProd(id);
	}
	@GetMapping("/EnergieDistricts")
	public IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> energyStateByDistrict() {
		return service.energyStateByDistrict();
	}
	
	
	@GetMapping("/adequateDistrict")
	public Integer adequateDistrict()
	{
		return service.provideEnergieForEntity(150);
	}
	
	@GetMapping("/EnergieCity")
	public Integer energyStateByCity()
	{
		int ville_conso=0,ville_prod=0,ville_bilan=0;
		for(Entry<Integer, IdentityHashMap<Integer, Integer>> ed:service.energyStateByDistrict().entrySet())
		{
			for(Entry<Integer, Integer> ed_bilan:ed.getValue().entrySet())
			{
				ville_prod+=ed_bilan.getKey();
				ville_conso+=ed_bilan.getValue();
			}
		}

		production_service.deleteProduction();
		prod_site_service.ProdSiteStateUpdateAll();
		ville_bilan=ville_prod-ville_conso;
		if(ville_bilan<=0)
		{
			prod_site_service.provideEnergy((ville_bilan));
		Integer total_prod=production_service.totalProduction();
		if(total_prod!=null)
		service.provideEnergieForEntity(total_prod);
		}
		return ville_bilan;

	}
	
}
