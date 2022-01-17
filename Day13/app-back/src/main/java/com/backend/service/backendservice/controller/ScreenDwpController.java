package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.ScreenDwp;
import com.backend.service.backendservice.service.ScreenDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/screen")
public class ScreenDwpController {

    @Autowired
    private ScreenDwpService screenDwpService;

    @GetMapping("/screenById")
    public ScreenDwp getScreenDwpById(@RequestParam("room_id")final Integer id){
        Optional<ScreenDwp> s = screenDwpService.getScreenById(id);
        return s.get();
    }

    @PostMapping("/updateScreenDwp")
    public void updateScreenDwp(@RequestBody ScreenDwp screenDwp) { screenDwpService.saveScreenDwp(screenDwp);}
}
