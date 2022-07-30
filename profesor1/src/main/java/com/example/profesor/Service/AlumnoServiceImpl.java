package com.example.profesor.Service;

import com.example.profesor.Repository.AlumnoRepo;
import com.example.profesor.modelo.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepo alumnoRepo;

    @Override
    public List<Alumno> listarTodos() {
        return alumnoRepo.findAll();
    }

    @Override
    public void guardar(Alumno alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    public void eliminar(Long id) {
        alumnoRepo.deleteById(id);
    }


}
