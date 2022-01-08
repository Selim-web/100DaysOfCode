package com.frontend.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.frontend.Model.Booking;
import com.frontend.Services.BookingService;
import com.frontend.Services.MessageServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private MessageServices services;

    @Autowired
    private BookingService bookingServices;

    /**
     * Display - display the first page of booking with date for the calendar
     */
    @GetMapping("/booking")
    public String bookingIhm(Model model, HttpSession session) {
        model.addAttribute("type", "other");
        LocalDate dateMin = LocalDate.now();
        LocalDate dateMax = LocalDate.now();
        dateMax = dateMax.plusDays(2);



        List<Map<String, String>> users = services.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }

        model.addAttribute("minDate", dateMin);
        model.addAttribute("maxdate", dateMax);
        return "booking";
    }

    /**
     * Send to back the booking - return on the page of the summary
     */
    @GetMapping("/summary")
    public String bookedRoom(Model model, HttpSession session) {

        List<Map<String, String>> users = services.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }
        return "summaryBooking";
    }

    /**
     * Return the summary page - return on the page of the summary
     */
    @PostMapping("/bookedRoom")
    public String bookedRoom(Model model, HttpSession session, @RequestParam("roomId") String roomId,
            @RequestParam("dateRoomChoose") String dateRoom, @RequestParam("startTimeChoose") String startTime,
            @RequestParam("endTimeChoose") String endTime, @RequestParam("choiceSelected") String choice,
            @RequestParam("listEmployee") String listEmployee,
            @RequestParam("titleMeetingForm") String titleMeetingForm) {

        System.out.println(titleMeetingForm + " title");

        startTime = startTime + ":00";
        endTime = endTime + ":00";

        if (!(listEmployee.equals(""))) {
            System.out.println(listEmployee);
            Booking booking = new Booking(dateRoom, startTime, endTime, session.getAttribute("id") + "", roomId,
                    titleMeetingForm);
            bookingServices.saveMeetingBooking(booking, listEmployee);
        } else {
            Booking booking = new Booking(dateRoom, startTime, endTime, session.getAttribute("id") + "", roomId);
            bookingServices.saveBooking(booking);
        }

        List<Map<String, String>> users = services.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }
        return "summaryBooking";
    }

    /**
     * Send to back the booking - return on the page of the summary
     */
    @GetMapping("/bookingMeeting")
    public String bookMeeting(Model model, HttpSession session) {
        model.addAttribute("type", "meeting");
        LocalDate dateMin = LocalDate.now();
        LocalDate dateMax = LocalDate.now();
        dateMax = dateMax.plusDays(2);

        List<Map<String, String>> users = services.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }

        model.addAttribute("minDate", dateMin);
        model.addAttribute("maxdate", dateMax);
        return "booking";
    }
}