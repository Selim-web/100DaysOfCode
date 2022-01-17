package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.BlindDwp;
import com.backend.service.backendservice.repository.BlindDwpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlindDwpService {

    @Autowired
    private BlindDwpRepo blindDwpRepo;

    public Optional<BlindDwp> getBlindDwpById(Integer id) { return blindDwpRepo.findById(id);}

    public void saveBlindDwp(BlindDwp blindDwp) {
        blindDwp.setRoomDigital(blindDwpRepo.findById(blindDwp.getId()).orElse(null).getRoomDigital());
        blindDwpRepo.save(blindDwp);
    }
}
