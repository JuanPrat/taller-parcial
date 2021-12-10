package com.poli.taller1.taller1.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "backlog")
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "No puede estar en blanco")
    private Long projectIdentifier;

    @OneToOne
    @JoinColumn(name="project_id")
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy="backlog" , fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTask;

}
