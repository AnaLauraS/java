package com.example.TrabajoIntegrador.service;

import com.example.TrabajoIntegrador.exceptions.NotFound;
import com.example.TrabajoIntegrador.model.Turno;
import com.example.TrabajoIntegrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements com.example.TrabajoIntegrador.service.Service <Turno> {

    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno agregar (Turno t){
        return turnoRepository.save(t);
    }

    public Turno modificar(Turno o) throws NotFound {
        if(buscarPorId(o.getId())==null)
            throw new NotFound("No existe el ID");
        return turnoRepository.save(o);
    }

    public List<Turno> listar (){
        return turnoRepository.findAll();
    }

    public void eliminar (Long id) throws NotFound {
        if(buscarPorId(id)==null)
            throw new NotFound("No existe el ID");
        turnoRepository.deleteById(id);
    }

    public Turno buscarPorId (Long id) throws NotFound{
        Optional<Turno> turno = turnoRepository.findById(id);
        if (!(turno.isPresent())){
            throw new NotFound("No existe el ID");
        }
        return turno.get();
    }
}