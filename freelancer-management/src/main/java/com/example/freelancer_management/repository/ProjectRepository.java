package com.example.freelancermanagement.repository;

import com.example.freelancermanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
   @Query(value = "SELECT * FROM project p WHERE " +
        "to_tsvector('english', p.title || ' ' || array_to_string(p.technologies_used, ' ')) @@ plainto_tsquery(:query)",
       nativeQuery = true)
   List<Project> searchByTitleOrTechnologies(@Param("query") String query);
}
