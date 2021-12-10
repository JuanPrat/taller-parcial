package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.ProjectModel;
import com.poli.taller1.taller1.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping()
    public List<ProjectModel> mostrarProject(){
        return projectService.mostrarProject();
    }

    @PostMapping()
    public ProjectModel crearProject(@RequestBody ProjectModel project){
        project.setStartDate(LocalDateTime.now()); //Genera la fecha en el momento que se creo
        return projectService.crearProject(project);
    }

    @PutMapping()
    public ProjectModel editarProject(@RequestBody ProjectModel project){
        return projectService.crearProject(project);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProject(@PathVariable("id") Long id){
        boolean seElimino = projectService.eliminarProject(id);
        if(seElimino){
            return "Se elimino";
        }
        return "No se pudo eliminar el usuario con el id " + id;
    }

}
