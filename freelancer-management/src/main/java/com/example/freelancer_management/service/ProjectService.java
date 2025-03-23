package com.example.freelancermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.freelancermanagement.model.Project;
import com.example.freelancermanagement.repository.ProjectRepository;

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