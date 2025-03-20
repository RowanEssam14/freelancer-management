package com.example.freelancermanagement.service;

import com.example.freelancermanagement.model.Project;
import com.example.freelancermanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> searchProjects(String query) {
        return projectRepository.searchByTitleOrTechnologies(query);
    }
}
