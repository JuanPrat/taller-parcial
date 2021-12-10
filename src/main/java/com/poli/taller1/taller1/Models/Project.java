
package com.poli.taller1.taller1.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    @NotNull(message = "No puede estar en blanco")
    private String projectName;

    @Column
    @NotNull(message = "No puede estar en blanco")
    private String projectIdentifier;

    @Column
    @NotNull(message = "No puede estar en blanco")
    private String description;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @OneToOne(mappedBy="project")
    private Backlog backlog;
}