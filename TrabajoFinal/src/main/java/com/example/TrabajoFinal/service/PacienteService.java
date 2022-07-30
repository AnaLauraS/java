package com.example.TrabajoFinal.service;

import com.example.TrabajoFinal.exceptions.NotFound;
import com.example.TrabajoFinal.model.Paciente;
import com.example.TrabajoFinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements com.example.TrabajoFinal.service.Service<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente agregar(Paciente o){
        return pacienteRepository.save(o);
    }

    public Paciente modificar (Paciente o)throws NotFound {
        if(buscarPorId(o.getId())==null)
            throw new NotFound("No existe el ID");
        return pacienteRepository.save(o);
    }

    public void eliminar (Long id)throws NotFound {
        if(buscarPorId(id)==null)
            throw new NotFound("No existe el ID");
        pacienteRepository.deleteById(id);
    }

    public Paciente buscarPorId (Long id) throws NotFound{
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (!(paciente.isPresent())){
            throw new NotFound("No existe el ID");
        }
            return paciente.get();

    }
}
