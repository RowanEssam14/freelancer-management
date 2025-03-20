package com.example.freelancermanagement.service;

import com.example.freelancermanagement.model.Freelancer;
import com.example.freelancermanagement.repository.FreelancerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FreelancerService {

    private final FreelancerRepository freelancerRepository;

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public List<Freelancer> getAllFreelancers() {
        return freelancerRepository.findAll();
    }
@Transactional
    public Freelancer registerFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }
}