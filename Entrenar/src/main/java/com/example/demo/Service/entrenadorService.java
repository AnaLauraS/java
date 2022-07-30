package com.example.demo.Service;

import com.example.demo.Dao.EntrenadorDaoH2;
import com.example.demo.Model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class entrenadorService implements IEntrenadorService{


    EntrenadorDaoH2 entrenadorDao;

    @Override
    public List<Entrenador> listarEntrenadores(){
        entrenadorDao = new EntrenadorDaoH2();
        return entrenadorDao.listarEntrenadores();
    }

}
