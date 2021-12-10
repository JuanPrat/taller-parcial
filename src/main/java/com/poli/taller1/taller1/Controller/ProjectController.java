package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.Project;
import com.poli.taller1.taller1.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/obtenerProyectos")
    public List<Project> mostrarProyectos() {
        return projectService.mostrarProject();
    }

    @PostMapping("/crearProyecto")
    public ResponseEntity<Project> crearProyecto(@Valid @RequestBody Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(400).build();
        }

        List<Project> projects = projectService.mostrarProject();
        List<ResponseEntity> filter;
        filter = projects.stream()
                .filter(project1 -> project1.getProjectName().equals(project.getProjectName()))
                .filter(project1 -> project1.getProjectIdentifier().equals(project.getProjectIdentifier()))
                .map(project1 -> {return ResponseEntity.status(400).build();})
                .collect(Collectors.toList());

        if(filter.size() > 0){
            return filter.get(0);
        }
        project.setStartDate(new Date());
        Project projectCreated = projectService.crearProject(project);
        return ResponseEntity.created(URI.create("/crearProyecto")).body(projectCreated);
    }

    @PutMapping("/actualizarProyecto")
    public Project editarProject(@RequestBody Project project) {
        return projectService.crearProject(project);
    }

    @DeleteMapping(path = "eliminar/{id}")
    public String eliminarProject(@PathVariable("id") Long id) {
        boolean seElimino = projectService.eliminarProject(id);
        if (seElimino) {
            return "Se elimino";
        }
        return "No se pudo eliminar el usuario con el id " + id;
    }

}
