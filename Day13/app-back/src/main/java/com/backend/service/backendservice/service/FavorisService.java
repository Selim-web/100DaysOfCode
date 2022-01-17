package com.backend.service.backendservice.service;

import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Favoris;
import com.backend.service.backendservice.repository.FavorisRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavorisService {
    @Autowired
    private FavorisRepo repo;

    public Favoris insertFavoris(Favoris fav) {
        return repo.save(fav);
    }

    public void dropFavoris(Favoris fav) {
        repo.delete(fav);
    }

    public List<Map<String, String>> selectFavorisOFOneUser(Integer idPerson) {
        return repo.selectFavorisOFOneUser(idPerson);
    }

    public Integer verifyTwoPeopleFavoris(Integer idSender, Integer idReceiver) {
        return repo.verifyTwoPeopleFavoris(idSender, idReceiver);
    }

}
