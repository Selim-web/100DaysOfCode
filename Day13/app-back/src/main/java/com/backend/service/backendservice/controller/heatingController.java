package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.model.heating;
import com.backend.service.backendservice.service.heatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/heating")
public class heatingController {

    @Autowired
    private heatingService service;

    @GetMapping("/listHeating")
    public Iterable<heating> getEachHeating(){return service.listHeating();}

    @GetMapping("/getHeating")
    public heating heatingById(@RequestParam("id")final Integer id ){
        Optional<heating>h = service.getHeating(id);
        if(h.isPresent()){
            return h.get();
        }else{
            return null;
        }
    }

    @GetMapping("/ListHeatings")
    public Iterable<heating> listheatings(@RequestParam(name="id") int id_room){return service.listheatings(id_room);}

}
