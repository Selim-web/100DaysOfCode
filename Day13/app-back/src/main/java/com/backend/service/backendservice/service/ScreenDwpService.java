package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.ScreenDwp;
import com.backend.service.backendservice.repository.ScreenDwpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScreenDwpService {

    @Autowired
    private ScreenDwpRepo screenDwpRepo;

    public Optional<ScreenDwp> getScreenById(Integer id) { return screenDwpRepo.findById(id);}

    public void saveScreenDwp(ScreenDwp screenDwp) {
        screenDwp.setRoomDigital(screenDwpRepo.findById(screenDwp.getId()).orElse(null).getRoomDigital());
        screenDwpRepo.save(screenDwp);
    }
}
