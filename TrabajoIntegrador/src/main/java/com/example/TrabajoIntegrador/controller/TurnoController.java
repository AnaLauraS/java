package com.example.TrabajoIntegrador.controller;

import com.example.TrabajoIntegrador.exceptions.NotFound;
import com.example.TrabajoIntegrador.model.Odontologo;
import com.example.TrabajoIntegrador.model.Paciente;
import com.example.TrabajoIntegrador.model.Turno;
import com.example.TrabajoIntegrador.service.OdontologoService;
import com.example.TrabajoIntegrador.service.PacienteService;
import com.example.TrabajoIntegrador.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoService turnoService;

    private static final Logger logger = Logger.getLogger(TurnoController.class);

    @GetMapping("")
    public ResponseEntity<List<Turno>> listar(){
        ResponseEntity response = null;
        if(turnoService.listar() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
            logger.debug("No hay nada en la lista");
        }
        else{
            response = new ResponseEntity(turnoService.listar(),HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/{idP}/{idO}")
    // En el body, solo pasarle la fecha y hora del turno, por ejemplo: {"diaHora": "2022-08-07 15:40:00"}
    public ResponseEntity<Turno> agregar (@PathVariable Long idP, @PathVariable Long idO, @RequestBody Turno turno) throws NotFound {
        ResponseEntity<Turno> response;
        Paciente paciente = pacienteService.buscarPorId(idP);
        Odontologo odontologo = odontologoService.buscarPorId(idO);
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        if (!this.verificarFecha(turno)) {
            response = ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
            logger.error("Turno ocupado");
        } else {
            response = ResponseEntity.ok(turnoService.agregar(turno));
        }
        return response;
    }

    // codigo para ver que un mismo odontologo no tenga dos turnos en el mismo horario
    public boolean verificarFecha (Turno turno) {
        List<Turno> listado = turnoService.listar();
        boolean respuesta = true;
        for (Turno t:listado) {
            if (t.getOdontologo().equals(turno.getOdontologo()) && t.getDiaHora().equals(turno.getDiaHora())) {
                respuesta = false;
            }
        }
        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws NotFound {
        turnoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    @PutMapping("/{id}/{idPac}/{idOdon}")
    // En el body, solo pasarle la fecha y hora del turno, por ejemplo: {"diaHora": "2022-08-07 15:40:00"}
    public ResponseEntity<Turno> modificar (@PathVariable Long id, @PathVariable Long idPac, @PathVariable Long idOdon, @RequestBody Turno turno) throws NotFound{
        Paciente paciente= pacienteService.buscarPorId(idPac);
        Odontologo odontologo= odontologoService.buscarPorId(idOdon);
        ResponseEntity<Turno> response;
        turno.setId(id);
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        if (!this.verificarFecha(turno)) {
            response = ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
            logger.error("Turno ocupado");
        } else {
            response = ResponseEntity.ok(turnoService.modificar(turno));
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) throws NotFound{
        turnoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.buscarPorId(id));
    }
}
