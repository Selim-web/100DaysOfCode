package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Production;
import com.backend.service.backendservice.model.ProductionSite;
import com.backend.service.backendservice.repository.ProductionSiteRepo;
import com.backend.service.backendservice.repository.RankingRepo;
import com.backend.service.backendservice.repository.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

@Service
public class ProductionSiteService {

	@Autowired
	private ProductionSiteRepo productionSiteRepo;

	@Autowired
	private ProductionRepo productionRepo;

	@Autowired
	private RankingRepo rankRepo;

	//create a production site
	public ProductionSite createSite (ProductionSite site) {
		ProductionSite newSite = productionSiteRepo.save(site);
		return newSite;
	}

	//get all sites
	public Iterable<ProductionSite> listSites(){
		return productionSiteRepo.findAll();
	}

	//find site by name
	public ProductionSite findSiteByName (String name) {
		Iterable<ProductionSite> listSites = listSites();
		ProductionSite site =null;
		for(ProductionSite s : listSites){
			if(s.getName().equals(name)){
				site=s;
				break;
			}
		}
		return site;
	}

	//delete site by name
	public void deleteSiteByName (String name) {
		ProductionSite site = findSiteByName(name);
		if(site == null) {
			throw new IllegalStateException("Ce site de production n'existe pas");
		} else {
			int id = site.getId_site();
			productionSiteRepo.deleteById(id);
		}
	}

	//find all sites which correspond to a specific type
	public ArrayList<ProductionSite> findSiteByType (String type) {
		Iterable<ProductionSite> listSites = listSites();
		ArrayList<ProductionSite> sites = null;
		for(ProductionSite s : listSites) {
			if(s.getType().equals(type)) {
				sites.add(s);
			}
		}
		return sites;
	}





	public Integer isProducing(int id_site)
	{
		for(Production ps : productionRepo.findAll())
		{
			if(ps.getFk_site()==id_site) {
				return ps.getProducted_quantity();
			}
		}
		return null;

	}
	public void ProdSiteStateUpdateAll()
	{
		productionSiteRepo.ProdSiteStateUpdateAll();
	}
	public void provideEnergy(int needed_energy) {
		ProductionSite prod_site=null;
		int remain_energy=needed_energy*(-1);
		int i=0;
		while(remain_energy>0 && i<rankRepo.energyByRank().size())
		{
			System.out.println("***********************");
			System.out.println((i+1)+"- "+rankRepo.energyByRank().get(i)+" : Les site de production intervenant sont :     ");
			System.out.println("***********************");
			System.out.println("");
			prod_site=productionSiteRepo.ProdSiteByType(rankRepo.energyByRank().get(i));
			while(prod_site!=null)
			{
				if(prod_site.getCapacity()>=remain_energy)
				{
					productionRepo.productionCreation(prod_site.getId_site(),remain_energy);
					remain_energy=0;
				}
				else
				{
					remain_energy=remain_energy-prod_site.getCapacity();
					productionRepo.productionCreation(prod_site.getId_site(),prod_site.getCapacity());
				}
				System.out.println("*******************************************************************");
				System.out.println("");
				System.out.println(prod_site.getName()+" a produit "+prod_site.getCapacity()+" KW et il reste "+remain_energy+" KW à produire");
				System.out.println("");
				productionSiteRepo.ProdSiteStateUpdate(prod_site.getId_site());
				if(remain_energy==0)
				{
					break;
				}
				prod_site=productionSiteRepo.ProdSiteByType(rankRepo.energyByRank().get(i));
			}
			i++;
		}
		System.out.println("********************************************************************");
		if(remain_energy==0)
		{
			System.out.println("energie provided!!");
		}
		else
		{
			System.out.println("On aura besoin de l'energy fossile!!");
		}
	}
}




