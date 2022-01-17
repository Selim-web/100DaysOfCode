package com.frontend.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.frontend.Services.MessageServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {
    @Autowired
    private MessageServices services;

    /**
     * Display - display the first page of booking with date for the calendar
     */
    @GetMapping("/calendar")
    public String viewCalendarOfUser(Model model, HttpSession session, @RequestParam("idUser") Integer idUser) {

        List<Map<String, String>> users = services.getContacts(Integer.parseInt(session.getAttribute("id") + ""),
                Integer.parseInt(session.getAttribute("idCompany") + ""));

        model.addAttribute("idCompany", Integer.parseInt(session.getAttribute("idCompany") + ""));
        model.addAttribute("sender", Integer.parseInt(session.getAttribute("id") + ""));
        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }
        return "calendar";
    }
}