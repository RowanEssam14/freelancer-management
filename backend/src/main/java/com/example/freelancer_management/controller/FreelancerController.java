package com.example.freelancer_management.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.freelancer_management.model.Freelancer;
import com.example.freelancer_management.service.FreelancerService;


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