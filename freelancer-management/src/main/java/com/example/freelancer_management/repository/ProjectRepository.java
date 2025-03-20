package com.example.freelancermanagement.repository;

import com.example.freelancermanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
   @Query("SELECT p FROM Project p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(p.technologiesUsed) LIKE LOWER(CONCAT('%', :query, '%'))")
List<Project> searchByTitleOrTechnologies(@Param("query") String query);

}
