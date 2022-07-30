package com.example.TrabajoFinal.controller;

import com.example.TrabajoFinal.exceptions.NotFound;
import com.example.TrabajoFinal.model.Paciente;
import com.example.TrabajoFinal.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @GetMapping("")
    public ResponseEntity listar(){
        ResponseEntity response = null;
        if(pacienteService.listar() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
            logger.debug("No hay nada en la lista");
        }
        else{
            response = new ResponseEntity(pacienteService.listar(),HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/new")
    // Ejemplo de body: {
    //    "apellido": "paciente",
    //    "nombre": "uno",
    //    "domicilio": "calle 1",
    //    "dni": 123,
    //    "fechaAlta": "2022-12-13"
    //}
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente p){
        return ResponseEntity.ok(pacienteService.agregar(p));
    }

    @PutMapping("")
    // Ejemplo de body: {
    //    "id":1,
    //    "apellido": "paciente",
    //    "nombre": "uno",
    //    "domicilio": "calle 1",
    //    "dni": 123,
    //    "fechaAlta": "2022-12-13"
    //}
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente p) throws NotFound{
        pacienteService.modificar(p);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.modificar(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws NotFound {
        pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) throws NotFound{
        pacienteService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.buscarPorId(id));
    }
}