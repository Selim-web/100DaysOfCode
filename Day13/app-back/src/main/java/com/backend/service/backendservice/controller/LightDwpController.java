package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.BlindDwp;
import com.backend.service.backendservice.model.LightDwp;
import com.backend.service.backendservice.model.RoomDigital;
import com.backend.service.backendservice.service.LightDwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Lumiere")
public class LightDwpController {

    @Autowired
    private LightDwpService lightDwpService;


    @GetMapping("/Lumiere")
    public LightDwp getLightDwp(@RequestParam("room_id") Integer id){
        Optional<LightDwp> l = lightDwpService.getLightDwpId(id);
        return l.get();
    }

    @GetMapping("/LumiereAll")
    public Iterable<LightDwp> getAllLightDwp() {
        Iterable<LightDwp> listLight = lightDwpService.getLightDwp();
        return listLight;
    }

    @PostMapping("/updateLightDwp")
    public void updateBlindDwp(@RequestBody LightDwp lightDwp){
       lightDwpService.saveLightDwp(lightDwp);
    }

}
