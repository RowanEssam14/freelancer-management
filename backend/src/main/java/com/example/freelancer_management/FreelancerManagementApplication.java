package com.example.freelancer_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.freelancer_management")
public class FreelancerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelancerManagementApplication.class, args);
    }
}
