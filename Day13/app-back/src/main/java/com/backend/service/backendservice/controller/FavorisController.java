package com.backend.service.backendservice.controller;

import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Favoris;
import com.backend.service.backendservice.service.FavorisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favoris")
public class FavorisController {
    @Autowired
    private FavorisService service;

    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @PostMapping("/favorisInsert")
    public Favoris selectEventForOneUser(@RequestBody Favoris fav) {
        return service.insertFavoris(fav);
    }

    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @PostMapping("/dropFavoris")
    public void dropFavoris(@RequestBody Favoris fav) {
        service.dropFavoris(fav);
    }

    /**
     * Select - favoris from a company of one user
     *
     * @param id of the user
     * @return favoris of the same company
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping(value = "/selectFavoris")
    public List<Map<String, String>> selectFavorisOFOneUser(@RequestParam("id_sender") Integer idPerson) {
        return service.selectFavorisOFOneUser(idPerson);
    }

    /**
     * Verify - Verify id two people were favoris
     *
     * @param idSender   of the user
     * @param idreceiver of his contact
     * @return favoris of the same company
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping(value = "/verifyTwoPeopleFavoris")
    public Boolean verifyTwoPeopleFavoris(@RequestParam("id_sender") Integer idSender,
            @RequestParam("id_receiver") Integer idReceiver) {
        Integer check = service.verifyTwoPeopleFavoris(idSender, idReceiver);
        if (check == null)
            return false;
        else
            return true;
    }
}
