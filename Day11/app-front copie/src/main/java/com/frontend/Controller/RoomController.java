package com.frontend.Controller;

import com.frontend.Model.Rooms;
import com.frontend.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class RoomController {

    @Autowired
    private RoomService service;

  /*  @GetMapping("/listRoom")
    public String listRoom(Model model){
        ArrayList<Rooms> listRoom = (ArrayList<Rooms>) service.getRooms();
       // Collections.sort(listRoom);
        model.addAttribute("Rooms",listRoom);
        return "List Room";
    }*/
}
