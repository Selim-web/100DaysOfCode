package com.frontend.Controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.frontend.Model.HeatingDwp;
import com.frontend.Model.RoomDigital;
import com.frontend.Services.EquipmentService;
import com.frontend.Services.HeatingDwpService;
import com.frontend.Services.MessageServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HeatingDwpController {

    @Autowired
    private HeatingDwpService service;

    @Autowired
    private MessageServices messageServices;

    @Autowired
    private EquipmentService Equipmentservice;

    @GetMapping("/chauffage")
    public String getHeating(@RequestParam(name = "room_id") Integer room_id, Model model, HttpSession session) {
        MessageController msg = new MessageController();

        List<Map<String, String>> users = messageServices.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }
        HeatingDwp heatingDwp = service.getHeating(room_id);
        //RoomDigital roomDigital = Equipmentservice.room(room_id);
        Integer temp = service.getScenario();
        model.addAttribute("heatingDwp", heatingDwp);
        model.addAttribute("temp", temp);
       // System.out.println("Le mode du chauffage de l'id "+heatingDwp.id+" est "+heatingDwp.mode);
        return "EquipmentDwp/chauffage";
    }

    @PostMapping("/updateHeating")
    public ModelAndView updateHeating(@RequestParam(name="room_id") Integer room_id, @RequestParam(name = "modeName") String mode, @ModelAttribute HeatingDwp heatingDwp){
        System.out.println(heatingDwp+" avant traitement");
       if (mode.equals("manuel"))
       {
           heatingDwp.setMode(mode);
           System.out.println(heatingDwp.getTemperature());
           service.updateHeating(heatingDwp);
       }
       else if (mode.equals("confort"))
       {
           heatingDwp.setMode(mode);
           heatingDwp.setTemperature(20);
           service.updateHeating(heatingDwp);
       }
       else if (mode.equals("economique"))
       {
           heatingDwp.setMode(mode);
           heatingDwp.setTemperature(15);
           service.updateHeating(heatingDwp);
       }
       else if (mode.equals("automatique")){
           heatingDwp.setMode(mode);
           heatingDwp.setTemperature(18);
           service.updateHeating(heatingDwp);

       }
       return new ModelAndView("redirect:/chauffage?room_id="+heatingDwp.getId());
    }

}
