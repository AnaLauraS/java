package com.example.TrabajoFinal.service;

import com.example.TrabajoFinal.exceptions.NotFound;
import com.example.TrabajoFinal.model.Odontologo;
import com.example.TrabajoFinal.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements com.example.TrabajoFinal.service.Service<Odontologo> {

    @Autowired
    private final OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Odontologo agregar(Odontologo o){
        return odontologoRepository.save(o);
    }

    public Odontologo modificar (Odontologo o) throws NotFound {
        if(buscarPorId(o.getId())==null)
            throw new NotFound("No existe el ID");
        return odontologoRepository.save(o);
    }

    public void eliminar (Long id) throws NotFound {
        if(buscarPorId(id)==null)
            throw new NotFound("No existe el ID");
        odontologoRepository.deleteById(id);
    }

    public Odontologo buscarPorId (Long id) throws NotFound{
        Optional<Odontologo> odon = odontologoRepository.findById(id);
        if (!(odon.isPresent())) {
            throw new NotFound("No existe el ID");
        }
            return odon.get();
    }
}