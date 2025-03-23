package com.example.freelancermanagement.repository;

import com.example.freelancermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
