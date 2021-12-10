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

    //Crear
    public ProjectTask crearProjectTask(ProjectTask projectTask){
        return projectTaskRepository.save(projectTask);
    }

    //Mostrar
    public List<ProjectTask> mostrarProjectTask(){
        return (List<ProjectTask>) projectTaskRepository.findAll();
    }

    //Editar
    public ProjectTask editarProjectTask(ProjectTask project){
        return projectTaskRepository.save(project);
    }

    //Eliminar
    public boolean eliminarProjectTask(Long id){
        try {
            projectTaskRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }


}
