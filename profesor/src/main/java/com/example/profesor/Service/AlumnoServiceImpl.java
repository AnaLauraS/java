package com.example.profesor.Service;

import com.example.profesor.Repository.AlumnoRepo;
import com.example.profesor.modelo.Alumno;
import com.example.profesor.modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepo alumnoRepo;

    private ProfesorServiceImpl profesorService;

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

    @Override
    public Alumno buscarPorID(Long id) {
        Optional<Alumno> alumno = alumnoRepo.findById(id);
        if(alumno.isPresent()){
            return alumno.get();
        }else {
            return null;
        }
    }

    public void asignarAlumnoAProfe(Long idAlum, Long idProfe){
        Alumno alumno = buscarPorID(idAlum);
        Profesor profesor = profesorService.buscarPorID(idProfe);
        alumno.setProfesor(profesor);
        alumnoRepo.save(alumno);
    }

}

