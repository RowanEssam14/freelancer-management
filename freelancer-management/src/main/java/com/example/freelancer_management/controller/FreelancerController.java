package com.example.freelancermanagement.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.freelancermanagement.model.Freelancer;
import com.example.freelancermanagement.service.FreelancerService;


@RestController
@RequestMapping("/api/freelancers")
public class FreelancerController {

    private final FreelancerService freelancerService;

    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping
    public List<Freelancer> getAllFreelancers() {
        return freelancerService.getAllFreelancers();
    }

    @PostMapping("/register")
    public Freelancer registerFreelancer(@RequestBody Freelancer freelancer) {
        return freelancerService.registerFreelancer(freelancer);
    }
}