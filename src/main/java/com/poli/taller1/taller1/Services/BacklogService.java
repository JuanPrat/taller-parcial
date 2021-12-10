package com.poli.taller1.taller1.Services;

import com.poli.taller1.taller1.Models.Backlog;
import com.poli.taller1.taller1.Repositories.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogService {

    @Autowired
    BacklogRepository backlogRepository;

    //Crear
    public Backlog crearBacklog(Backlog backlog){
        return backlogRepository.save(backlog);
    }

    //Mostrar
    public List<Backlog> mostrarBacklogs(){
        return (List<Backlog>) backlogRepository.findAll();
    }

    //Editar
    public Backlog editarBacklog(Backlog backlog){
        return backlogRepository.save(backlog);
    }

    //Eliminar
    public boolean eliminarBacklog(Long id){
        try {
            backlogRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }

}