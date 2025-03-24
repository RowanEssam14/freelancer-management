package com.example.freelancer_management.repository;

import com.example.freelancer_management.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
   @Query("SELECT DISTINCT p FROM Project p LEFT JOIN p.technologiesUsed t " +
       "WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%')) " +
       "OR LOWER(t) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Project> searchByTitleOrTechnologies(@Param("query") String query);


}
