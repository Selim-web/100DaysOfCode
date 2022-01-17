package com.frontend.Controller;

import com.frontend.Model.BlindDwp;
import com.frontend.Services.BlindDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlindDwpController {

    @Autowired
    private BlindDwpService service;

    @GetMapping("/blind")
    public String getBlind(@RequestParam(name = "room_id")Integer room_id, Model model) {
        BlindDwp blindDwp = service.getBlind(room_id);
        model.addAttribute("blindDwp", blindDwp);
        return "EquipmentDwp/Store";
    }

    @PostMapping("/updateBlind")
    public ModelAndView updateBlind(@RequestParam(name="room_id") Integer room_id, @ModelAttribute BlindDwp blindDwp){
        service.updateBlind(blindDwp);
        return new ModelAndView("redirect:/blind?room_id="+blindDwp.getId());
    }
}
