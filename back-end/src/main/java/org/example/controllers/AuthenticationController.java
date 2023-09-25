package org.example.controllers;

import org.example.jwtconfig.AuthenticationRequest;
import org.example.jwtconfig.AuthenticationResponse;
import org.example.jwtconfig.AuthenticationService;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {

    @Autowired
    AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody User user) {
        return ResponseEntity.ok(service.register(user));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(service.authenticate(user));
    }


}
