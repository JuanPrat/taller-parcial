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

    public Backlog crearBacklog(Backlog backlog){
        return backlogRepository.save(backlog);
    }

    public List<Backlog> obtenerBacklogs(){
        return (List<Backlog>) backlogRepository.findAll();
    }

}