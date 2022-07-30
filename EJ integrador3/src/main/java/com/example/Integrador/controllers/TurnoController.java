package com.example.Integrador.controllers;

import com.example.Integrador.dao.Impl.OdontologoDaoH2;
import com.example.Integrador.dao.Impl.PacienteDaoH2;
import com.example.Integrador.dao.Impl.TurnoDao;
import com.example.Integrador.models.Odontologo;
import com.example.Integrador.models.Paciente;
import com.example.Integrador.models.Turno;
import com.example.Integrador.services.OdontologoService;
import com.example.Integrador.services.PacienteService;
import com.example.Integrador.services.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoDao());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping("")
    public ResponseEntity<List<Turno>> listar(){
        return ResponseEntity.ok(turnoService.listar());
    }

    @PostMapping("")
    public ResponseEntity<Turno> registarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        Paciente paciente = pacienteService.buscar(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscar(turno.getOdontologo().getId());
        if(paciente == null && odontologo == null){
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            response = ResponseEntity.ok(turnoService.registrarTuno(turno));
        }
        return response;
    }

    @PutMapping()
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        ResponseEntity<Turno> response = null;
        if(turnoService.actualizarTurno(turno) != null){
            response =  ResponseEntity.ok(turnoService.actualizarTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity response = null;

        if(turnoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            turnoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id){
        ResponseEntity response = null;
        if(turnoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity(turnoService.buscar(id),HttpStatus.OK);
        }
        return response;
    }
}