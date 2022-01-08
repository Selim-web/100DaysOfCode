package com.frontend.Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontend.Model.Eco_district;
import com.frontend.Model.Entity_map;
import com.frontend.Repository.EntityProxy;

@Service
public class EntityService {


	@Autowired
	private EntityProxy proxy;
	
	public Integer getDistCons(Integer id )
	{
		return proxy.getDistCons(id);
	}
	public Integer getDistProd(Integer id )
	{
		return proxy.getDistProd(id);
	}
	public Integer EnergyStateByCity()
	{
		return proxy.EnergyStateByCity();
	}
	public IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> EnergyStateByDistrict()
	{
		return proxy.energyStateByDistrict();
	}
}
