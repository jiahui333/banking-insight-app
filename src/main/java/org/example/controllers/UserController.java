package org.example.controllers;

import org.example.models.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser(String username, String password) {
        System.out.println("controller" + username);
        System.out.println(password);
        return userService.readUser(username, password);
    }

    @PostMapping
    public void postUser(String firstname, String secondname, String username, String password) {
        userService.createUser(firstname, secondname, username, password);

        System.out.println(username + password + firstname + secondname);
    }

    @PutMapping
    public void putUser(String oldUsername, String password, String newUsername) {
        userService.changeUsername(oldUsername, password, newUsername);
    }




}
