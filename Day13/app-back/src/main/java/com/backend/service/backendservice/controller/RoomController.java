package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Room")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/listRoom")
    public Iterable<Rooms> getEachRoom(){return service.listRooms();}

    @GetMapping("/getRoom")
    public Rooms RoomById(@RequestParam("id") final Integer id){
        Optional<Rooms> r = service.getRoom(id);
        if(r.isPresent()) {
            return r.get();
        }else {
            return null;
        }
    }

    @GetMapping("/ListRooms")
    public Iterable<Rooms> listRooms(@RequestParam(name="id") int id_home){return service.listRooms(id_home);}

}
