package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.HeatingDwp;
import com.backend.service.backendservice.repository.HeatingDwpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HeatingDwpService {

    @Autowired
    private HeatingDwpRepo heatingDwpRepo;

    public Optional<HeatingDwp> getHeatingDwp(Integer id) {
        return heatingDwpRepo.findById(id);
    }

    public List<HeatingDwp> getHeatingDwpAll() {
        return heatingDwpRepo.findAll();
    }

    public Integer getScenario() { return heatingDwpRepo.getScenario(); }

    public void saveHeatingDwp(HeatingDwp heatingDwp) {
        heatingDwp.setRoomDigital(heatingDwpRepo.findById(heatingDwp.getId()).orElse(null).getRoomDigital());
        heatingDwpRepo.save(heatingDwp);

    }
}
