package ru.aurorahost.ppmtool.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.aurorahost.ppmtool.domain.Project;
import ru.aurorahost.ppmtool.service.MapValidationErrorService;
import ru.aurorahost.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("http://localhost:3000")
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService validationService;

    public ProjectController(ProjectService projectService, MapValidationErrorService validationService) {
        this.projectService = projectService;
        this.validationService = validationService;
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        return projectService.findAllProjects();
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findProjectByProjectId(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = validationService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable String projectId) {
        projectService.deleteProjectByProjectId(projectId);
        return new ResponseEntity<>("Project with id '" + projectId + "' has been deleted.", HttpStatus.OK);
    }
}
