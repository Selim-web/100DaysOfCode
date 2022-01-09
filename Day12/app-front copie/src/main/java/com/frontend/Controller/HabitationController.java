package com.frontend.Controller;

import com.frontend.Model.Habitation;
import com.frontend.Model.Rooms;
import com.frontend.Model.Users;
import com.frontend.Model.heating;
import com.frontend.Services.HabitationServices;
import com.frontend.Services.RoomService;
import com.frontend.Services.heatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class HabitationController {

    @Autowired
    private HabitationServices services;
    @Autowired
    private RoomService roomservices;
    @Autowired
    private heatingServices heatingservices;

    @GetMapping("/getHome")
    public String getHome(@RequestParam(name="id") int id, Model model){
        Habitation h1=services.getHome(id);
        ArrayList<Rooms> list_Rooms= (ArrayList<Rooms>) roomservices.listRooms(id);
        Rooms r1= (Rooms) list_Rooms.get(0);
        model.addAttribute("home",h1);
        model.addAttribute("room",r1);
        model.addAttribute("listRoom",list_Rooms);
        model.addAttribute("listHeating",heatingservices.getHeatings(r1.getId_room()));
        return "HomeInterface";
    }
    @GetMapping("/getHomeBody")
    public String getHomeBody(@RequestParam(name="home_id") int id_home, @RequestParam(name="room_id") int id_room,Model model){
        Habitation h1=services.getHome(id_home);
        Rooms r1=roomservices.getRoom(id_room);
        model.addAttribute("home",h1);
        model.addAttribute("room",r1);
        model.addAttribute("listRoom",roomservices.listRooms(id_home));
        model.addAttribute("listHeating",heatingservices.getHeatings(id_room));
        System.out.println("id room="+id_room);
        return "DataHome";
    }
    @GetMapping("/listHome")
    public String listHome(Model model){
        ArrayList<Habitation> listHabitation = (ArrayList<Habitation>) services.getHomes();
        model.addAttribute("homes", listHabitation);
        return "ListHome";
    }

    @GetMapping("/HomeInfo")
    public String HomeInfo(Model model){

        return "HomeInterface";
    }

    /*@GetMapping("/UserAdress")
    public String UserAdress(Model model, HttpSession session){
        Habitation place = services.getHome(Integer.parseInt(session.getAttribute("id")+""));

        model.addAttribute("userOfThePlace", services);
        return "HomeInterface";
    }*/

    @GetMapping("/UserAdress")
    public String UserAdress(Model model, HttpSession session) {
        Integer placeInt = Integer.parseInt(session.getAttribute("id") + "");
        Iterable<Habitation> listplace = services.getHomes();
        String placeString = "";
        for (Habitation habitation : listplace) {
            if (habitation.getId_home() == placeInt) {

            }
        }
            return "HomeInterface";
        }


}
