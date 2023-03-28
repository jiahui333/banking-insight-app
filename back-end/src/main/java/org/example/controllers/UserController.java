package org.example.controllers;

import org.example.models.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> findUserById (@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }


//    @PutMapping
//    public void putUser(String oldUsername, String password, String newUsername) throws NoSuchObjectException {
//        userService.changeUsername(oldUsername, password, newUsername);
//    }

}
