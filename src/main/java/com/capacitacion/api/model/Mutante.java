package com.capacitacion.api.model;

import javax.validation.constraints.NotNull;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Mutantes")


public class Mutante {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPersona;

    @Column(name = "name", length = 50)
    private String name;

    @NotNull(message = "El grupo no puede ser Nulo")
    @Column(name = "grupo", length = 50)
    private String grupo;

    @NotNull(message = "La ubicacion no puede ser Nulo")
    @Column(name = "location", length = 50)
    private String location;

    @NotNull(message = "La condicion no puede ser Nulo")
    @Column(name = "condicion", length = 50)
    private String condicion;

    @NotNull(message = "El poder no puede ser Nulo")
    @Column(name = "poder", length = 50)
    private String poder;

    public Mutante(String nombre) {
        this.name = name;
    }

    public Mutante(String name, String grupo, String location, String condicion, String poder) {
        this.name = name;
        this.grupo = grupo;
        this.location = location;
        this.condicion = condicion;
        this.poder = poder;
    }
}


