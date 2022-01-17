package com.frontend.Controller;

import com.frontend.Model.LightDwp;
import com.frontend.Services.LightDwpService;
import com.frontend.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@Controller
public class LightDwpController {

    @Autowired
    private LightDwpService lightDwpService;

    @Autowired
    private MessageServices messageServices;

    @GetMapping("/Lumiere")
    public String getLight(@RequestParam(name = "room_id")Integer room_id, Model model, HttpSession session) {
       // MessageController msg = new MessageController();

       // List<Map<String, String>> users = messageServices.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
       //         Integer.parseInt(session.getAttribute("idCompany") + ""));

       // model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
       // model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
       // if (users.size() > 0) {
       //     model.addAttribute("listUsers", users);
       // }
        LightDwp lightDwp = lightDwpService.getLight(room_id);
        model.addAttribute("lightDwp", lightDwp);
        System.out.println(lightDwp);
        return "EquipmentDwp/Lumiere";
    }

    @PostMapping("/updateLight")
    public ModelAndView updateLight(@RequestParam(name="room_id") Integer room_id, @ModelAttribute LightDwp lightDwp) {
        lightDwpService.updateLight(lightDwp);
        return new ModelAndView("redirect:/Lumiere?room_id="+lightDwp.getId());
    }
}
