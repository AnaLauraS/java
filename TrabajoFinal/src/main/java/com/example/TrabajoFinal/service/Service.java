package com.example.TrabajoFinal.service;

import com.example.TrabajoFinal.exceptions.NotFound;

import java.util.List;

public interface Service <T>{
    public List<T> listar();
    public T agregar(T o);
    public T modificar(T o) throws NotFound;
    public void eliminar(Long id) throws NotFound;
    public T buscarPorId(Long id) throws NotFound;
}
