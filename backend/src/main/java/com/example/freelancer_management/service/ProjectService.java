package com.example.freelancer_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.freelancer_management.model.Project;
import com.example.freelancer_management.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> searchProjects(String query) {
        return projectRepository.searchByTitleOrTechnologies(query);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
}