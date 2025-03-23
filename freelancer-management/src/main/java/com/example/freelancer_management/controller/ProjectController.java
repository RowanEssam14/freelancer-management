package com.example.freelancermanagement.controller;

import com.example.freelancermanagement.model.Project;
import com.example.freelancermanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
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