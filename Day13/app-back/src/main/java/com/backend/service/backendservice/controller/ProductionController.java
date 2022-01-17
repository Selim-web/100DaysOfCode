package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.Production;
import com.backend.service.backendservice.model.ProductionSite;
import com.backend.service.backendservice.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/production")

public class ProductionController {

    @Autowired
    private ProductionService service;

    @GetMapping("/energyByType")
    public HashMap<String, String> energyByType() {
        HashMap<String, String> energies =  new HashMap<>();
        energies.put("eolien", String.valueOf(service.energyEolien()));
        energies.put("solaire", String.valueOf(service.energySolaire()));
        energies.put("hydraulique", String.valueOf(service.energyHydraulique()));
        System.out.println(energies);
        return energies;
    }

    @GetMapping("/totalEnergy")
    public Integer totalEnergy() {
        return service.totalEnergy();
    }

    @GetMapping("/energyBySite")
    public List<Map<String, String>> energyBySite() {

        System.out.println(service.energyBySite());
        return service.energyBySite();
    }
    
    @GetMapping("/productionPerSite")
    public List<Map<String,Object>> productionPerSite() {

        return service.productionPerSite();
    }
    @GetMapping("/totalProduction")
    public Integer totalProduction() {
        return service.totalProduction();
    }
}
