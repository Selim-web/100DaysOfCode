package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.BlindDwp;
import com.backend.service.backendservice.service.BlindDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blind")
public class BlindDwpController {

    @Autowired
    private BlindDwpService blindDwpService;

    @GetMapping("/blindById")
    public BlindDwp getBlindDwpById(@RequestParam("room_id") final Integer id) {
        Optional<BlindDwp> b = blindDwpService.getBlindDwpById(id);
        return b.get();
    }

    @PostMapping("/updateBlindDwp")
    public void updateBlindDwp(@RequestBody BlindDwp blindDwp){
        blindDwpService.saveBlindDwp(blindDwp);
    }
}
