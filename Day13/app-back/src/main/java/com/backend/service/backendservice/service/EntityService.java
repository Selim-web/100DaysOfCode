package com.backend.service.backendservice.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.backendservice.model.Eco_district;
import com.backend.service.backendservice.model.Entity_map;
import com.backend.service.backendservice.repository.EntityRepo;

@Service
public class EntityService {
	@Autowired
	private EntityRepo entityRepo;
	public Integer districtCons(Integer id){
		return entityRepo.districtConso(id);
	}

	public Integer districtProd(Integer id){
		return entityRepo.districtProd(id);
	}

	public IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> energyStateByDistrict(){

		IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> list =new IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>>();
		List<Integer> l_e_d=entityRepo.listIdEcoDistrict();
		Collections.sort(l_e_d);
		for(int l1:l_e_d)
		{
			IdentityHashMap<Integer, Integer> list_2=new IdentityHashMap<Integer, Integer>();
			int sum_cons=0;
			int sum_prod=0;
			for(Entity_map l2:entityRepo.findAll())
			{
				if(l2.getId_ecdt()==l1)
				{

					sum_cons+=l2.getQuant_cons();
					sum_prod+=l2.getQuant_prod();
				}
			}
			list_2.put(sum_prod,sum_cons);
			list.put(l1, list_2);
		}

		return list;
	}

	public Integer provideEnergieForEntity(Integer provided_energy){
		
		int id_ecdt=0;
		if(entityRepo.adequatDistrict(provided_energy)!=null && entityRepo.getEntity(entityRepo.adequatDistrict(provided_energy))!=null)
		{
		    id_ecdt=entityRepo.adequatDistrict(provided_energy);
			System.out.println("energy is suffisent for eco district number "+id_ecdt);

			int remain_energy=provided_energy;
			System.out.println("provided_energy="+remain_energy);

			Entity_map entity=entityRepo.getEntity(id_ecdt);
			int needed_energy=entity.getQuant_cons()-entity.getQuant_prod();
			while(remain_energy>needed_energy && entity!=null)
			{

				System.out.print("energy is cool for entity "+entity.getId_entity()+" that need :"+needed_energy);
				remain_energy-=needed_energy;
				System.out.println("    |     remain_energy="+remain_energy);
				entityRepo. provideEntergyEntity(entity.getId_entity(), needed_energy);
				entity=entityRepo.getEntity(id_ecdt);
				while(entity==null)
				{
					if(entityRepo.adequatDistrict(remain_energy)!=null)
					{
						id_ecdt=entityRepo.adequatDistrict(remain_energy);
						entity=entityRepo.getEntity(id_ecdt);
					}
				}  
				needed_energy=entity.getQuant_cons()-entity.getQuant_prod();
			}
			System.out.println("remain_energy="+remain_energy);
		}
		else
		{
			System.out.println("nope!");
		}

		return id_ecdt;
	}

}
