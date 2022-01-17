package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.ProductionSite;
import com.backend.service.backendservice.service.ProductionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.IdentityHashMap;

@RestController
@RequestMapping("/productionSite")
public class ProductionSiteController {

    @Autowired
    private ProductionSiteService service;

    @PostMapping("/addSite")
    public ProductionSite addSite(@RequestBody ProductionSite s) {
        return service.createSite(s);
    }

    @PostMapping("/listSites")
    public Iterable<ProductionSite> getAllSites () {
        return service.listSites();
    }

    @PostMapping("/byName")
    public ProductionSite siteByName (@RequestParam(name = "name") final String name) {
        ProductionSite site = service.findSiteByName(name);
        return site;
    }

    @PostMapping("/byType")
    public ArrayList<ProductionSite> sitesByType(@RequestParam(name = "type") final String type){
        ArrayList<ProductionSite> sites = service.findSiteByType(type);
        return sites;
    }

    @PostMapping("/deleteSite")
    public void deleteByName (@RequestParam(name = "name") final String name) {
        service.deleteSiteByName(name);
    }
}
