package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.PlugDwp;
import com.backend.service.backendservice.service.PlugDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/plug")
public class PlugDwpController {

    @Autowired
    private PlugDwpService plugDwpService;

    @GetMapping("/plugById")
    public PlugDwp getPlugById(@RequestParam("room_id") final Integer id) {
        Optional<PlugDwp> p = plugDwpService.getPlugById(id);
        return p.get();
    }

    @PostMapping("/updatePlugDwp")
    public void updatePlugDwp(@RequestBody PlugDwp plugDwp) { plugDwpService.savePlugDwp(plugDwp);}
}
