package com.example.freelancermanagement.controller;

import com.example.freelancermanagement.model.Project;
import com.example.freelancermanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }
}