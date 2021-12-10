package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.ProjectTask;
import com.poli.taller1.taller1.Services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projecttask")
public class ProjectTaskController {

    @Autowired
    ProjectTaskService projectTaskService;

    @GetMapping(value = "/mostrarTareas")
    public List<ProjectTask> mostrarProyectoTask(){
        return projectTaskService.mostrarProjectTask();
    }

    @PostMapping(value = "/crearTarea")
    public ProjectTask crearProjectTask(@RequestBody ProjectTask projectTask){
        return projectTaskService.crearProjectTask(projectTask);
    }

    @PutMapping(value = "/actualizarTarea")
    public ProjectTask editarProjectTask(@RequestBody ProjectTask projectTask){
        return projectTaskService.crearProjectTask(projectTask);
    }

    @DeleteMapping(path = "/eliminarTarea/{id}")
    public String eliminarProjectTask(@PathVariable("id") Long id){
        boolean seElimino = projectTaskService.eliminarProjectTask(id);
        if(seElimino){
            return "Se elimino";
        }
        return "No se pudo eliminar el usuario con el id " + id;
    }

}
