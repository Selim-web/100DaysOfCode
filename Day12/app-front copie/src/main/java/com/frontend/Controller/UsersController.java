package com.frontend.Controller;

import javax.servlet.http.HttpSession;

import com.frontend.Model.Employee;
import com.frontend.Model.Users;
import com.frontend.Services.UsersServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    @Autowired
    private UsersServices services;

    @GetMapping("/")
    public String loginPage() {
        return "index";
    }

    /**
     * Verify - verify if user exist and if he is a employee, inhabitant
     */
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam(name = "email") String email, Model model, HttpSession session) {
        Boolean verfiUser = services.checkUser(email);

        if (verfiUser) {
            Users u1 = services.getUser(email);

            // verify if user is an employee
            Employee e1 = services.verifyEmployee(u1.getId());
            if (e1 != null) {
                session.setAttribute("role", e1.getIdRole());
                session.setAttribute("idCompany", e1.getIdCompany());
                model.addAttribute("idCompany", e1.getIdCompany());
            } else {
                // verify if user is a guest
            }

            session.setAttribute("id", u1.getId());
            model.addAttribute("id", session.getAttribute("id"));
            return "homePage";
        } else
            return "index";
    }

}