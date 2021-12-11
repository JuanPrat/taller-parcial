package com.poli.taller1.taller1.Controller;

import com.poli.taller1.taller1.Models.Backlog;
import com.poli.taller1.taller1.Services.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    BacklogService backlogService;

    @Autowired
    private Validator validator;

    @GetMapping(value = "/obtenerBacklogs")
    public List<Backlog> mostrarBacklogs(){
        return backlogService.obtenerBacklogs();
    }

    @PostMapping(value = "/crearBacklog")
    @Validated
    public ResponseEntity<Backlog> crearBacklog(@Valid @RequestBody Backlog backlog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(400).build();
        }
        Backlog backlogCreated = backlogService.crearBacklog(backlog);
        return ResponseEntity.created(URI.create("/crearBacklog")).body(backlogCreated);
    }
}
