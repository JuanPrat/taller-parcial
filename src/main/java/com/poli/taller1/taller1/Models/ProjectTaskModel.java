package com.poli.taller1.taller1.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "projecttask")
public class ProjectTaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String summary;

    @Column
    private String acceptanceCriteria;

    @Column
    private String status;

    @Column
    private Integer priority;

    @Column
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
    private BacklogModel backlog;
}
