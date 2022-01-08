package com.frontend.Controller;


import com.frontend.Model.HeatingDwp;
import com.frontend.Model.LightDwp;
import com.frontend.Model.RoomDigital;
import com.frontend.Services.EquipmentService;
import com.frontend.Services.HeatingDwpService;
import com.frontend.Services.LightDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipmentController {

    @Autowired
    private HeatingDwpService heatingDwpService;

    @Autowired
    private LightDwpService lightDwpService;

    @Autowired
    private EquipmentService service;

    @GetMapping("/utiliserEquipement")
    public String listEquipment(@RequestParam(name="room_id") Integer room_id, Model model) {
        HeatingDwp heatingDwp = heatingDwpService.getHeating(room_id);
        Integer temp = heatingDwpService.getScenario();
        LightDwp lightDwp = lightDwpService.getLight(room_id);
        model.addAttribute("lightDwp", lightDwp);
        model.addAttribute("heatingDwp", heatingDwp);
        model.addAttribute("temp", temp);
        return "/EquipmentDwp/utiliserEquipement";
    }

    @GetMapping("/Store")
    public String Store(Model model) {
        return "/EquipmentDwp/Store";
    }

    @GetMapping("/Surveillance")
    public String Surveillance(Model model) {
        model.addAttribute("test", true);
        return "/EquipmentDwp/Surveillance";
    }

}
