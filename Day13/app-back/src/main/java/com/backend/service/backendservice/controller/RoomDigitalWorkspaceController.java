package com.backend.service.backendservice.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.backend.service.backendservice.model.RoomDigital;
import com.backend.service.backendservice.service.RoomDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomDigital")
public class RoomDigitalWorkspaceController {
    @Autowired
    private RoomDigitalService service;

    /**
     * Select - select all rooms
     *
     * @return list of rooms
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping(value = "selectRoomDigital")
    public List<HashMap<String, String>> getRoom(@RequestParam("type") String type) {
        ArrayList<Map<String, String>> listRoom = service.getRooms(type);
        List<HashMap<String, String>> finalList = copyList(listRoom);
        return finalList;
    }

    /**
     * Select - select rooms with params
     *
     * @return list of rooms which correspond of params
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping(value = "getRoomsWithSearch")
    public List<HashMap<String, String>> getRoomsWithSearch(@RequestParam("endTime") String endTime,
            @RequestParam("startTime") String startTime, @RequestParam("type") String type,
            @RequestParam("day") String day) {
        Time start = convertTime(startTime);
        Time end = convertTime(endTime);
        LocalDate aptDate = convertDate(day);
        System.out.println(start);
        System.out.println(end);
        ArrayList<Map<String, String>> listRoom = service.getRoomsWithSearch(end, start, aptDate, type);
        List<HashMap<String, String>> finalList = copyList(listRoom);
        return finalList;
    }

    public Time convertTime(String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long ms = 00;
        try {
            ms = sdf.parse(startTime).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Time convertedTime = new Time(ms);
        return convertedTime;
    }
    public LocalDate convertDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate aptDate = null;
        try {
            aptDate = LocalDate.parse(date, dateFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aptDate;
    }

    public List<HashMap<String, String>> copyList(ArrayList<Map<String, String>> list) {
        List<HashMap<String, String>> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, String> sauv = new HashMap<>();
            sauv.put("choice", "");
            sauv.put("map", "");
            sauv.put("listEquipment", "");
            for (Map.Entry m : list.get(i).entrySet()) {
                sauv.put(m.getKey() + "", m.getValue() + "");
            }
            finalList.add(sauv);
        }
        return finalList;
    }

    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/roomAll")
    public Iterable<RoomDigital> getAllRoomDwp() {
        Iterable<RoomDigital> listRoom = service.getRoomDwp();
        return listRoom;
    }

    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/roomById")
    public RoomDigital getRoomById(@RequestParam("room_id") Integer id) {
        Optional<RoomDigital> r = service.getRoomById(id);
        return r.get();
    }
}
