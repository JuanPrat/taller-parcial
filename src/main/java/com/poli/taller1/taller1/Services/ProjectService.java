package com.poli.taller1.taller1.Services;


import com.poli.taller1.taller1.Models.Project;
import com.poli.taller1.taller1.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project crearProject(Project projectTask){
        return projectRepository.save(projectTask);
    }

    public List<Project> mostrarProject(){
        return (List<Project>) projectRepository.findAll();
    }

    public Project editarProject(Project projectTask){
        return projectRepository.save(projectTask);
    }

    public boolean eliminarProject(Long id){
        try {
            projectRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }
}
