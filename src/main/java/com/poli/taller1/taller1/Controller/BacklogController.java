package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.Backlog;
import com.poli.taller1.taller1.Services.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    BacklogService backlogService;

    @Autowired
    private Validator validator;

    @GetMapping(value = "/obtenerBacklogs")
    public List<Backlog> mostrarBacklogs(){
        return backlogService.mostrarBacklogs();
    }

    @PostMapping(value = "/crearBacklog")
    @Validated
    public ResponseEntity<Backlog> crearBacklog(@Valid @RequestBody Backlog backlog, BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(400).build();
            }
            Backlog backlogCreated = backlogService.crearBacklog(backlog);
            return ResponseEntity.created(URI.create("/crearBacklog")).body(backlogCreated);
    }

    @PutMapping(value = "/editarBacklog")
    public Backlog editarBacklog(@RequestBody Backlog backlog){
        return backlogService.crearBacklog(backlog);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarBacklog(@PathVariable("id") Long id){
        boolean fueEliminado = backlogService.eliminarBacklog(id);
        if(fueEliminado){
            return "el backlog fue eliminado";
        }
        return "Error al eliminar el backlog con id" + id;
    }
}
