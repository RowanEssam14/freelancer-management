package com.example.freelancer_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.freelancer_management.model.Freelancer;
import com.example.freelancer_management.repository.FreelancerRepository;

@Service
public class UserService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    // Register a freelancer
    public Freelancer registerFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }
}
