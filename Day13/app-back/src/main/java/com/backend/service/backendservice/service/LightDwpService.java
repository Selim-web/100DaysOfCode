package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.BlindDwp;
import com.backend.service.backendservice.model.LightDwp;
import com.backend.service.backendservice.repository.LightDwpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LightDwpService {

    @Autowired
    private LightDwpRepo lightDwpRepo;

    public List<LightDwp> getLightDwp() {
        return lightDwpRepo.findAll();
    }

    public Optional<LightDwp> getLightDwpId(Integer id) {
        return lightDwpRepo.findById(id);
    }

    public void saveLightDwp(LightDwp lightDwp) {
        lightDwp.setRoomDigital(lightDwpRepo.findById(lightDwp.getId()).orElse(null).getRoomDigital());
        lightDwpRepo.save(lightDwp);
    }

}
