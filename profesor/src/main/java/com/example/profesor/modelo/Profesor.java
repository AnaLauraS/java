package com.example.profesor.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String titulo;
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    public Profesor() {
    }

    public Profesor(String nombre, String titulo,List<Alumno> alumnos) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.alumnos = alumnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
