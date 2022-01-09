package com.frontend.Services;

import com.frontend.Model.Production;
import com.frontend.Model.ProductionSite;
import com.frontend.Repository.ProductionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionService {

    @Autowired
    private ProductionProxy proxy;

    public HashMap<String, String> getEnergiesByType() {
        return proxy.getEnergiesByType();
    }

    public List<Map<String, String>> getEnergiesBySite() {
        return proxy.getEnergiesBySite();
    }

	public ArrayList<Map<String, Object>> productionPerSite() {
		return proxy.productionPerSite();
	}
	 public Integer totalProduction() 
	 {
		 return proxy.totalProductionPerSite();
		 
	 }
}
