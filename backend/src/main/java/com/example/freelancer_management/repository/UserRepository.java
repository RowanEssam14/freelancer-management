package com.example.freelancer_management.repository;

import com.example.freelancer_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
