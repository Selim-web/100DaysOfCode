package com.backend.service.backendservice.service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import com.backend.service.backendservice.model.Booking;
import com.backend.service.backendservice.model.RoomDigital;
import com.backend.service.backendservice.repository.RoomDigitalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class RoomDigitalService {
    @Autowired
    private RoomDigitalRepo roomRepo;

    public ArrayList<Map<String, String>> getRooms(String type) {
        System.out.println(type);
        if (type.equals("meetingRoom"))
            return roomRepo.getMeetingRooms();
        else
            return roomRepo.getRooms();
    }

    public ArrayList<Map<String, String>> getRoomsWithSearch(Time endTime, Time startTime, LocalDate day,
            String type) {
        if (type.equals("meetingRoom")) {
            System.out.println(type);
            return roomRepo.getRoomsWithSearchMeetingRoom(endTime, startTime, day);
        } else if (type.equals("openSpace")) {
            System.out.println(type);
            return roomRepo.getRoomsWithSearchOpenSpace(endTime, startTime, day);
        } else if (type.equals("salleTravail")) {
            return roomRepo.getRoomsWithSearchSalleTravail(endTime, startTime, day);
        } else {
            return roomRepo.getRoomsWithSearchBureauSolo(endTime, startTime, day);
        }
    }

    public Optional<RoomDigital> getRoomById(Integer id) { return roomRepo.findById(id); }

    public Iterable<RoomDigital> getRoomDwp() {
        return roomRepo.findAll();
    }

}
