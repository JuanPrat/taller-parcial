package com.poli.taller1.taller1.Repositories;

import com.poli.taller1.taller1.Models.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog,Long> {
}
