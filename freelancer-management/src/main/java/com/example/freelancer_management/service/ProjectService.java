package com.example.freelancermanagement.service;

import com.example.freelancermanagement.model.Project;
import com.example.freelancermanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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