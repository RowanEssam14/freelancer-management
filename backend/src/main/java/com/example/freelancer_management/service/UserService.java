package com.example.freelancermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.freelancermanagement.model.Freelancer;
import com.example.freelancermanagement.repository.FreelancerRepository;

@Service
public class UserService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    // Register a freelancer
    public Freelancer registerFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }
}
