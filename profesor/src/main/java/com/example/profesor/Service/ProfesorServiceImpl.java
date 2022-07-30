package com.example.profesor.Service;

import com.example.profesor.Repository.ProfeRepo;
import com.example.profesor.modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfeRepo profesorRepo;

    @Override
    public List<Profesor> listarTodos() {
        return profesorRepo.findAll();
    }

    @Override
    public void guardar(Profesor profesor) {
        profesorRepo.save(profesor);
    }

    @Override
    public void eliminar(Long id) {
        profesorRepo.deleteById(id);
    }

    @Override
    public Profesor buscarPorID(Long id) {
        Optional<Profesor> profesor = profesorRepo.findById(id);
        if(profesor.isPresent()){
            return profesor.get();
        }else {
            return null;
        }
    }


}
