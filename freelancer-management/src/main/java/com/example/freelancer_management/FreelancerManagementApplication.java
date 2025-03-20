package com.example.freelancermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.freelancermanagement")
public class FreelancerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelancerManagementApplication.class, args);
    }
}
