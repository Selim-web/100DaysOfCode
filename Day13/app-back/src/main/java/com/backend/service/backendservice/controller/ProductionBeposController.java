package com.backend.service.backendservice.controller;

import java.util.List;
import java.util.Optional;

import com.backend.service.backendservice.model.Power;
import com.backend.service.backendservice.service.ProductionBeposService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productionBepos")
public class ProductionBeposController {
 
    @Autowired
    private ProductionBeposService service;

    @GetMapping("/typeHabitation")
    public String listUsers(@RequestParam("id") final Integer id){
        return service.listUserService(id);
    }

    @GetMapping("/listRooms")
    public List<String> getListRooms(@RequestParam("id") final Integer id){
        return service.listRoomsService(id);
    }

    @GetMapping("/listRoom1")
    public List<String> getListRoom(){
        return service.listRoomsServic();
    }

    @GetMapping("/listAdresse")
    public List<String> getListAddress(){
        return service.listAdressService();
    }

    @GetMapping("/consPower")
    public List<String> getPower(){
        return service.listPowerService();
    }

    @GetMapping("/findPower")
    public Iterable<Power> getlistPower(){
        return service.findlistPower();
    }

    @GetMapping("/sum")
    public Integer getsum(){
        return service.sumService();
    }
}

