package com.backend.service.backendservice.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.service.AttendMeetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attend")
public class AttendController {
    @Autowired
    private AttendMeetingService service;

    /**
     * Select - select event of one user
     *
     * @param idUser
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/selectEvent")
    public List<Map<String, String>> selectEventForOneUser(@RequestParam("idUser") Integer idUser) {
        List<Map<String, String>> listEvent = service.selectEventForOneUser(idUser);
        List<Map<String, String>> listFinal = modifyListForFullcalendar(listEvent);
        return listFinal;
    }

    public List<Map<String, String>> modifyListForFullcalendar(List<Map<String, String>> listEvent) {

        List<Map<String, String>> finalList = new ArrayList<>();
        for (int i = 0; i < listEvent.size(); i++) {
            Map<String, String> sauv = new HashMap<>();
            String nameEvent = "";
            String dateEv = "";
            String startEv = "";
            String endEv = "";

            if (listEvent.get(i).get("title_event") == null)
                nameEvent = "/";
            else
                nameEvent = listEvent.get(i).get("title_event");

            sauv.put("title", nameEvent + " - " + listEvent.get(i).get("name"));

            for (Map.Entry m : listEvent.get(i).entrySet()) {
                if (m.getKey().equals("day")) {
                    if (!(startEv.equals(""))) {
                        startEv = m.getValue() + "" + startEv;
                    }
                    if (!(endEv.equals(""))) {
                        endEv = m.getValue() + "" + endEv;
                    }
                    dateEv = m.getValue() + "";
                } else if (m.getKey().equals("start_time")) {
                    startEv = dateEv + " " + m.getValue();
                } else if (m.getKey().equals("end_time")) {
                    endEv = dateEv + " " + m.getValue();
                }
            }
            sauv.put("start", startEv);
            sauv.put("end", endEv);

            finalList.add(sauv);
        }
        return finalList;
    }
}
