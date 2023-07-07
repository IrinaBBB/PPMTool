package ru.aurorahost.ppmtool.service;

import org.springframework.stereotype.Service;
import ru.aurorahost.ppmtool.domain.Backlog;
import ru.aurorahost.ppmtool.domain.Project;
import ru.aurorahost.ppmtool.exception.ProjectIdException;
import ru.aurorahost.ppmtool.repository.BacklogRepository;
import ru.aurorahost.ppmtool.repository.ProjectRepository;

@Service
public class ProjectService {

    private final
    ProjectRepository projectRepository;
    private final BacklogRepository backlogRepository;

    public ProjectService(ProjectRepository projectRepository, BacklogRepository backlogRepository) {
        this.projectRepository = projectRepository;
        this.backlogRepository = backlogRepository;
    }

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if (project.getId() != null) {
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already " +
                    "exists");
        }
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public Project findProjectByProjectId(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project with id " + projectId + " does not " +
                    "exist");
        }
        return project;
    }

    public void deleteProjectByProjectId(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Cannot delete with id '" + projectId.toUpperCase() + "'. This project does not exist");
        }
        projectRepository.delete(project);
    }
}
