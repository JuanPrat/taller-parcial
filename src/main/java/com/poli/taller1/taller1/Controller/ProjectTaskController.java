package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.ProjectTaskModel;
import com.poli.taller1.taller1.Services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projecttask")
public class ProjectTaskController {

    @Autowired
    ProjectTaskService projectTaskService;

    @GetMapping()
    public List<ProjectTaskModel> mostrarProjectTask(){
        return projectTaskService.mostrarProjectTask();
    }

    @PostMapping()
    public ProjectTaskModel crearProjectTask(@RequestBody ProjectTaskModel projectTask){
        return projectTaskService.crearProjectTask(projectTask);
    }

    @PutMapping()
    public ProjectTaskModel editarProjectTask(@RequestBody ProjectTaskModel projectTask){
        return projectTaskService.crearProjectTask(projectTask);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProjectTask(@PathVariable("id") Long id){
        boolean seElimino = projectTaskService.eliminarProjectTask(id);
        if(seElimino){
            return "Se elimino";
        }
        return "No se pudo eliminar el usuario con el id " + id;
    }

}
