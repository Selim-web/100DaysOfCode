package com.frontend.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.frontend.EcoDistComparator;
import com.frontend.ProdSiteComparator;
import com.frontend.Model.Production;
import com.frontend.Model.ProductionSite;
import com.frontend.Services.EntityService;
import com.frontend.Services.ProductionService;
import com.frontend.Services.ProductionSiteService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Controller
public class EntityController {
	
	@Autowired
	private EntityService ent_services;
	
	@Autowired
	private ProductionService prod_services;
	
	
	@GetMapping("/mapGrid")
	public String bilan_Energie_SmartGrid(Model model)
	{
		//the date and time of the last refresh
		LocalDateTime last_refresh = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = last_refresh.format(myFormatObj);
		IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> listEco_dist=ent_services.EnergyStateByDistrict();


		//for the echo district
		TreeMap<Integer, IdentityHashMap<Integer, Integer>> mapTree_ecoD = new TreeMap<Integer, IdentityHashMap<Integer, Integer>>(Collections.reverseOrder());
		mapTree_ecoD.putAll(listEco_dist); 

		//for the whole city
		int ville_bilan=ent_services.EnergyStateByCity();

		//for the production site
		ArrayList<Map<String, Object>> list_prod= prod_services.productionPerSite();
		Integer produced_quantity=prod_services.totalProduction();
		if(produced_quantity==null) produced_quantity=0;
		
		//sending the informations to the map
		model.addAttribute("last_refreshed",formattedDate);
		model.addAttribute("ville_bilan",ville_bilan);
		model.addAttribute("eco_dist", mapTree_ecoD);
		model.addAttribute("prod_site",list_prod);
		model.addAttribute("producted_quantity",produced_quantity);
		return "smartgrid";
	}
	
	@GetMapping("/map")
	public String map(Model model)
	{	
		//the date and time of the last refresh
		LocalDateTime last_refresh = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = last_refresh.format(myFormatObj);
		IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> listEco_dist=ent_services.EnergyStateByDistrict();

		//for the echo district
		TreeMap<Integer, IdentityHashMap<Integer, Integer>> mapTree_ecoD = new TreeMap<Integer, IdentityHashMap<Integer, Integer>>(Collections.reverseOrder());
		mapTree_ecoD.putAll(listEco_dist);

		//for the whole city
		int ville_bilan=ent_services.EnergyStateByCity();

		//for the production site
		ArrayList<Map<String, Object>> list_prod= prod_services.productionPerSite();
		Integer produced_quantity=prod_services.totalProduction();		
		if(produced_quantity==null) produced_quantity=0;
		
		//sending the informations to the map
		model.addAttribute("last_refreshed",formattedDate);
		model.addAttribute("ville_bilan",ville_bilan);
		model.addAttribute("eco_dist",mapTree_ecoD);
		model.addAttribute("prod_site",list_prod);
		model.addAttribute("producted_quantity",produced_quantity);
		return "map";
	}
	
	@GetMapping("/prodDist")
	public String testprod(Model model)
	{
		return "homePage";
	}
}
