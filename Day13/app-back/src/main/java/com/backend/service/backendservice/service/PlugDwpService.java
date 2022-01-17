package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.PlugDwp;
import com.backend.service.backendservice.model.ScreenDwp;
import com.backend.service.backendservice.repository.PlugDwpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlugDwpService {

    @Autowired
    private PlugDwpRepo plugDwpRepo;

    public Optional<PlugDwp> getPlugById(Integer id) { return plugDwpRepo.findById(id);}

    public void savePlugDwp(PlugDwp plugDwp) {
        plugDwp.setRoomDigital(plugDwpRepo.findById(plugDwp.getId()).orElse(null).getRoomDigital());
        plugDwpRepo.save(plugDwp);
    }

}
