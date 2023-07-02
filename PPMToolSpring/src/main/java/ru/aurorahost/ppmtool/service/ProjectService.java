package ru.aurorahost.ppmtool.service;

import org.springframework.stereotype.Service;
import ru.aurorahost.ppmtool.domain.Project;
import ru.aurorahost.ppmtool.repository.ProjectRepository;

@Service
public class ProjectService {

    final
    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);
    }
}
