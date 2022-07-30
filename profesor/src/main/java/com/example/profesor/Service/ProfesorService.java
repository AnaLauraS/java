package com.example.profesor.Service;

import com.example.profesor.modelo.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> listarTodos();

    void guardar(Profesor profesor);

    void eliminar(Long id);

    Profesor buscarPorID(Long id);

}
