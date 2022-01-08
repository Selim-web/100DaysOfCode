package com.frontend.Controller;

import com.frontend.Model.ProductionSite;
import com.frontend.Services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductionController {
    @Autowired
    private ProductionService service;

    @GetMapping("/energyByType")
    public String getEnergiesByType(Model model) {
        System.out.println(service.getEnergiesByType().get("hydraulique"));

        model.addAttribute("energies", service.getEnergiesByType());
        model.addAttribute("hydraulique", service.getEnergiesByType().get("hydraulique"));
        model.addAttribute("eolien", service.getEnergiesByType().get("eolien"));
        model.addAttribute("solaire", service.getEnergiesByType().get("solaire"));

        List<Map<String,String>> list = service.getEnergiesBySite();
        System.out.println(list);
        ArrayList<String> listNames = new ArrayList<>();
        //add sites names to listNames
        for(Map<String, String> map : list) {
            String s = map.get(map.keySet().toArray()[0]);
            listNames.add(s);
        }

        //add sites production values to listValues
        ArrayList<String> listValues = new ArrayList<>();
        for (Map<String,String> map :list) {
            String s = map.get(map.keySet().toArray()[1]);
            listValues.add(s);
        }

        System.out.println(listNames);
        System.out.println(listValues);

        for (int i = 0; i < listNames.size(); i++) {
            model.addAttribute(listNames.get(i), listValues.get(i));
        }
        model.addAttribute("names", listNames);
        model.addAttribute("values", listValues);
        return "visualiserMix";
    }

}
