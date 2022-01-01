package test.selim.spring.tuto.testback.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.selim.spring.tuto.testback.domain.AppUser;
import test.selim.spring.tuto.testback.services.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<AppUser> fetchAllUsers() {
        return userService.getUserList();
    }
}
