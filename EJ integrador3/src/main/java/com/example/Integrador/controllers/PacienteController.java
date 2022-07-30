package com.example.Integrador.controllers;

import com.example.Integrador.dao.Impl.PacienteDaoH2;
import com.example.Integrador.models.Paciente;
import com.example.Integrador.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;
        if(paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null){
            response =  ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id){
        ResponseEntity response = null;
        if(pacienteService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity(pacienteService.buscar(id),HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity response = null;

        if(pacienteService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacienteService.eliminar(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity buscarTodos(){
        ResponseEntity response = null;
        if(pacienteService.buscarTodos() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity(pacienteService.buscarTodos(),HttpStatus.OK);
        }
        return response;
    }
}