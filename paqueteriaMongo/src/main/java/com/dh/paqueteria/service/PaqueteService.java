package com.dh.paqueteria.service;

import com.dh.paqueteria.model.Estado;
import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    private PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public List<Paquete> listarPaquetes(){
        return paqueteRepository.findAll();
    }

    public Paquete guardar(Paquete paquete){
        return paqueteRepository.save(paquete);
    }

    public List<Paquete> listarPaquetesEnCamino(){
        return paqueteRepository.findAllBy(Estado.EN_CAMINO);
    }

}
