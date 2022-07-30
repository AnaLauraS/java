package com.example.profesor.Service;

import com.example.profesor.modelo.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> listarTodos();

    void guardar(Alumno alumno);

    void eliminar(Long id);

    Alumno buscarPorID(Long id);
}
