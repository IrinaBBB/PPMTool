package ru.aurorahost.ppmtool.service;

import org.springframework.stereotype.Service;
import ru.aurorahost.ppmtool.domain.Backlog;
import ru.aurorahost.ppmtool.domain.ProjectTask;
import ru.aurorahost.ppmtool.repository.BacklogRepository;
import ru.aurorahost.ppmtool.repository.ProjectTaskRepository;

import java.util.Objects;

@Service
public class ProjectTaskService {

    private final BacklogRepository backlogRepository;
    private final ProjectTaskRepository projectTaskRepository;

    public ProjectTaskService(BacklogRepository backlogRepository, ProjectTaskRepository projectTaskRepository) {
        this.backlogRepository = backlogRepository;
        this.projectTaskRepository = projectTaskRepository;
    }

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        // TODO: Exceptions: Project not found

        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        projectTask.setBacklog(backlog);
        Integer backlogSequence = backlog.getPTSequence();
        backlogSequence++;
        backlog.setPTSequence(backlogSequence);

        projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        if (Objects.equals(projectTask.getStatus(), "") || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }

        if (projectTask.getPriority() == null) { //In the future we need projectTask.getPriority()== 0 to handle the form
            projectTask.setPriority(3);
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findBacklogById(String id) {
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }
}
