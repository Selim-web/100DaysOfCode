package com.backend.service.backendservice.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.AttendMeeting;
import com.backend.service.backendservice.model.Booking;
import com.backend.service.backendservice.service.AttendMeetingService;
import com.backend.service.backendservice.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;
    @Autowired
    private AttendMeetingService serviceAttend;

    /**
     * Insert - insert a booking
     *
     * @param body a map with info
     */
    @PostMapping("/insertBooking")
    public void insertBooking(@RequestBody Map<String, String> body) {

        Time start = convertTime(body.get("start"));
        Time end = convertTime(body.get("end"));

        LocalDate aptDate = convertDate(body.get("date"));
        Integer idPerson = Integer.parseInt(body.get("idPerson"));
        Integer idRoom = Integer.parseInt(body.get("idRoom"));
        Integer maxId = service.selectMaxId() + 1;
        Booking booking = new Booking(maxId, aptDate, start, end, idPerson, idRoom);
        service.saveBooking(booking);
    }

    /**
     * Insert - insert a meeting booking
     *
     * @param body a map with info
     */
    @PostMapping("/insertMeetingBooking")
    public void insertMeetingBooking(@RequestBody Map<String, String> body) {
        System.out.println(("deux fois booking ?"));
        String listId = body.get("listId");
        String titleBooking = body.get("title");

        int[] listIdInt = convertStringtoArray(listId);

        Time start = convertTime(body.get("start"));
        Time end = convertTime(body.get("end"));

        LocalDate aptDate = convertDate(body.get("date"));
        Integer idPerson = Integer.parseInt(body.get("idPerson"));
        Integer idRoom = Integer.parseInt(body.get("idRoom"));

        Integer maxIdBooking = service.selectMaxId() + 1;

        System.out.println(start + " " + end + " ");

        Booking booking = new Booking(maxIdBooking, aptDate, start, end, idPerson,
                idRoom, titleBooking);

        service.saveBooking(booking);
        // insert in attendMeeting
        for (int i = 0; i < listIdInt.length; i++) {
            Integer maxIdAttend = serviceAttend.selectMaxId() + 1;
            AttendMeeting attender = new AttendMeeting(maxIdAttend, listIdInt[i],
                    maxIdBooking);
            serviceAttend.insertAttend(attender);
        }
    }

    /**
     * Select - select bookings with ajax for bootstrap table
     *
     * @param id of one user
     * @return list of booking of one user
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/selectBooking")
    public List<HashMap<String, String>> selectBooking(@RequestParam("idUser") String id) {
        LocalDate toDay = LocalDate.now();
        List<Map<String, String>> list = service.selectRoomBooked(id, toDay);
        List<HashMap<String, String>> finalList = copyList(list);
        return finalList;
    }

    public int[] convertStringtoArray(String listId) {
        String[] separatedStrings = listId.replaceAll("\\[", "").replaceAll("]", "").split(",");

        int[] listIdInt = new int[separatedStrings.length];
        for (int i = 0; i < separatedStrings.length; i++) {
            try {
                listIdInt[i] = Integer.parseInt(separatedStrings[i]);
            } catch (Exception e) {
                System.out.println("Unable to parse string to int: " + e.getMessage());
            }
        }
        System.out.println(Arrays.toString(listIdInt));
        return listIdInt;
    }

    public Time convertTime(String time) {
        String dateTime = "0000-00-00 " + time;
        Time timeConverted = null;
        try {
            Date dateS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
            timeConverted = new Time(dateS.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeConverted;
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

    // permet de manipuler les map
    public List<HashMap<String, String>> copyList(List<Map<String, String>> list) {
        List<HashMap<String, String>> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, String> sauv = new HashMap<>();
            sauv.put("monitoring", "");
            for (Map.Entry m : list.get(i).entrySet()) {
                sauv.put(m.getKey() + "", m.getValue() + "");
            }
            finalList.add(sauv);
        }
        return finalList;
    }

}
