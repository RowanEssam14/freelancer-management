package com.example.freelancer_management.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.freelancer_management.model.Freelancer;
import com.example.freelancer_management.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to register a freelancer
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Freelancer registerFreelancer(@RequestBody Freelancer freelancer) {
        return userService.registerFreelancer(freelancer);
    }
}
