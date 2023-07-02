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
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService validationService;

    public ProjectController(ProjectService projectService, MapValidationErrorService validationService) {
        this.projectService = projectService;
        this.validationService = validationService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = validationService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
}
