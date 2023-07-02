package ru.aurorahost.ppmtool.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aurorahost.ppmtool.domain.Project;
import ru.aurorahost.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
}
