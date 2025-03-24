package com.example.freelancer_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "freelancer")
@Getter
@Setter
public class Freelancer extends User {
    private String specialization;
    private String skill;
    private Double hourlyRate;
}