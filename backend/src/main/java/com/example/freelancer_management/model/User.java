package com.example.freelancer_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User extends BaseUser {
}