package com.frontend.Controller;

import com.frontend.Model.Habitation;
import com.frontend.Model.heating;
import com.frontend.Services.HabitationServices;
import com.frontend.Services.heatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class heatingController {

    @Autowired
    private heatingServices heating_services;
    @Autowired
    private HabitationServices home_services;
    @GetMapping("/listHeating")
  public String listHeating(@RequestParam(name="id") int id, Model model)
        {
            Habitation h1=home_services.getHome(id);
            //methode 1 envoyer uniquement l'addresse à la template
            String address=h1.getAdress();
            model.addAttribute("home_address",address);
            //methode 2 avec tout l'objet
            model.addAttribute("homes", h1);
            System.out.println("adress = "+ h1.getAdress());
            for(HashMap<String, Iterable<heating>> l1: home_services.HomeInfo().values())
            {
                for(Map.Entry<String, Iterable<heating>> l2:l1.entrySet()) {
                    System.out.println(l2.getKey());
                    for(heating l3:l2.getValue()) {
                        System.out.print(l3.getId_heating()+" | ");
                    }
                    System.out.println();
                }
            }
            model.addAttribute("listHome",home_services.HomeInfo().entrySet());
            model.addAttribute("selectedHome",2);
            return "dataHome";
        }

    @GetMapping("/getHeating")
    public String getHeating(@RequestParam(name="id")int id, Model model){
        heating heating = heating_services.getHating(id);
        model.addAttribute("heating",heating);
        return "heatingById";
    }

    @GetMapping("ConfigHeating/{id}")
    public String ConfigHeating(Model model, @PathVariable("id") int id_h){
        Iterable<heating> heatingl = heating_services.getHeatings(id_h);
        model.addAttribute("heatingl",heatingl);
        return "HeatingBepos";
    }

   /* @GetMapping("/listHeatings")
    public String listHeating(Model model){
        ArrayList<heating> listHeating = (ArrayList<heating>) services.getHeatings();
        //Collections.sort(listHeating);
        model.addAttribute("heatings",listHeating);
        return "ListHeating";
    }*/
}
