package com.backend.service.backendservice.controller;


import com.backend.service.backendservice.model.HeatingDwp;
import com.backend.service.backendservice.service.HeatingDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/chauffage")
public class HeatingDwpController {

    @Autowired
    private HeatingDwpService heatingDwpService;

    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/chauffage")
    public HeatingDwp getHeatingDwp(@RequestParam("room_id") final Integer id){
        Optional<HeatingDwp> h = heatingDwpService.getHeatingDwp(id);
        return h.get();
    }
    @GetMapping("/")
    public Integer getScenario() {
        return heatingDwpService.getScenario();
    }

    @PostMapping("/updateChauffage")
    public void updateHeatingDwp(@RequestBody HeatingDwp heatingDwp) {
        heatingDwpService.saveHeatingDwp(heatingDwp);
    }
}
