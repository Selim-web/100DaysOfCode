package com.frontend.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.frontend.Model.Power;
import com.frontend.Services.ProductionBeposService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductionBeposController {

  @Autowired
  private ProductionBeposService service;


  @GetMapping("/typeHabitation")
  public String getList(Model model, HttpSession session) {
   Integer idhabitation = Integer.parseInt(session.getAttribute("id") + "");
   List<String> value = service.getTypeHabitation(idhabitation);
   model.addAttribute("idhabitation", value);
   return "monitorerProduction";
  }

  @GetMapping("/listDesRooms")
  public String getRooms(Model model){
    List<String> rooms = service.listRoomService();
    model.addAttribute("rooms",rooms);
    return "monitorerConso";

  }

  @GetMapping("/adresse")
  public String AdresseList(Model model){
    List<String> addressList = service.listAdresseService();
    model.addAttribute("addressList", addressList);
    return "monitorerConso";
  }

  @GetMapping("/power")
  public String listPowerCont(Model model){
    ArrayList<Power> power = (ArrayList<Power>) service.listPower();
    int value = service.sumPowerService();
    model.addAttribute("sum", value);
    model.addAttribute("powerlist", power);
    return "monitorerConso";
  }


 
}
