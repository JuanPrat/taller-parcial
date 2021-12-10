package com.poli.taller1.taller1.Services;

import com.poli.taller1.taller1.Models.ProjectTask;
import com.poli.taller1.taller1.Repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    ProjectTaskRepository projectTaskRepository;

    public ProjectTask crearProjectTask(ProjectTask projectTask){
        return projectTaskRepository.save(projectTask);
    }

    public List<ProjectTask> mostrarProjectTask(){
        return (List<ProjectTask>) projectTaskRepository.findAll();
    }

    public ProjectTask editarProjectTask(ProjectTask project){
        return projectTaskRepository.save(project);
    }

}
