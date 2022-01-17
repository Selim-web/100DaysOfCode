package com.frontend.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import com.frontend.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MessageController {
    @Autowired
    private MessageServices services;

    /**
     * Display - display the page of messages of one user
     */
    @GetMapping("/message")
    public String messagerie(Model model, HttpSession session) {
        Integer idSender = Integer.parseInt(session.getAttribute("id") + "");
        Integer idCompany = Integer.parseInt(session.getAttribute("idCompany") + "");
        List<Map<String, String>> users = services.getContacts(idSender, idCompany);
        model.addAttribute("idCompany", idCompany);
        model.addAttribute("sender", idSender);

        if (users.size() > 0) {
            model.addAttribute("listUsers", users);
        }
        return "message";
    }
}
