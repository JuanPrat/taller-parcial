package com.poli.taller1.taller1.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "projecttask")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    @NotNull(message = "No puede estar en blanco")
    private String nombre;

    @Column
    @NotNull(message = "No puede estar en blanco")

    private String summary;

    @Column
    private String acceptanceCriteria;

    @Column

    private String status;

    @Column
    @Min(value = 1, message = "la prioridad debe de ser mayor a 1")
    @Max(value = 5, message = "la prioridad debe de ser menor a 5")
    private Integer priority;

    @Column
    @Min(value = 1, message = "la prioridad debe de ser mayor a 1")
    @Max(value = 8, message = "la prioridad debe de ser menor a 8")
    private Double hours;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String projectIdentifier;

    //Relación con backlog
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;
}
