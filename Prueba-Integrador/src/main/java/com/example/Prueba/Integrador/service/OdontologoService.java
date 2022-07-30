package com.example.Prueba.Integrador.service;

import com.example.Prueba.Integrador.model.Odontologo;
import com.example.Prueba.Integrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository o){
        this.odontologoRepository=o;
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }
}
