package com.frontend.Controller;


import com.frontend.Model.*;
import com.frontend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipmentController {

    @Autowired
    private HeatingDwpService heatingDwpService;

    @Autowired
    private LightDwpService lightDwpService;

    @Autowired
    private BlindDwpService blindDwpService;

    @Autowired
    private ScreenDwpService screenDwpService;

    @Autowired
    private PlugDwpService plugDwpService;

    @Autowired
    private EquipmentService service;

    @GetMapping("/utiliserEquipement")
    public String listEquipment(@RequestParam(name="room_id") Integer room_id, Model model) {
        HeatingDwp heatingDwp = heatingDwpService.getHeating(room_id);
        Integer temp = heatingDwpService.getScenario();
        LightDwp lightDwp = lightDwpService.getLight(room_id);
        BlindDwp blindDwp = blindDwpService.getBlind(room_id);
        ScreenDwp screenDwp = screenDwpService.getScreen(room_id);
        PlugDwp plugDwp = plugDwpService.getPlug(room_id);
        model.addAttribute("lightDwp", lightDwp);
        model.addAttribute("heatingDwp", heatingDwp);
        model.addAttribute("blindDwp", blindDwp);
        model.addAttribute("screenDwp", screenDwp);
        model.addAttribute("plugDwp", plugDwp);
        model.addAttribute("temp", temp);
        return "/EquipmentDwp/utiliserEquipement";
    }

    @PostMapping("/updateScreen")
    public ModelAndView updateScreen (@ModelAttribute ScreenDwp screenDwp){
        screenDwpService.updateScreen(screenDwp);
        return new ModelAndView("redirect:/utiliserEquipement?room_id="+screenDwp.getId());
    }

    @PostMapping("/updatePlug")
    public ModelAndView updatePlug(@ModelAttribute PlugDwp plugDwp){
        plugDwpService.updatePlug(plugDwp);
        return new ModelAndView("redirect:/utiliserEquipement?room_id="+plugDwp.getId());
    }

    @GetMapping("/Surveillance")
    public String Surveillance(Model model) {
        model.addAttribute("test", true);
        return "/EquipmentDwp/Surveillance";
    }

}
