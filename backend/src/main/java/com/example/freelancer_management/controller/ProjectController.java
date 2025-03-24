package com.example.freelancer_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.freelancer_management.model.Project;
import com.example.freelancer_management.service.ProjectService;

@RestController
@RequestMapping("/api/portfolio")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/search")
    public List<Project> searchProjects(@RequestParam String query) {
        return projectService.searchProjects(query);
    }
    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

}