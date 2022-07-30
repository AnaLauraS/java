package com.example.TrabajoIntegrador.controller;

import com.example.TrabajoIntegrador.exceptions.NotFound;
import com.example.TrabajoIntegrador.model.Odontologo;
import com.example.TrabajoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @GetMapping("")
    public ResponseEntity listar(){
        ResponseEntity response = null;
        if(odontologoService.listar() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
            logger.debug("No hay nada en la lista");
        }
        else{
            response = new ResponseEntity(odontologoService.listar(),HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/new")
    // Ejemplo de body: {
    //    "apellido": "Lopez",
    //    "nombre": "Juan",
    //    "matricula": "mt05"
    //}
    public ResponseEntity<Odontologo> agregar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.agregar(odontologo));
    }

    @PutMapping("")
    // Ejemplo de body: {
    //    "id": 1,
    //    "apellido": "Lopez",
    //    "nombre": "Juan",
    //    "matricula": "mt05"
    //}
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo) throws NotFound {
        odontologoService.modificar(odontologo);
        return ResponseEntity.status(HttpStatus.OK).body(odontologoService.modificar(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws NotFound {
        odontologoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) throws NotFound{
        odontologoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(odontologoService.buscarPorId(id));
    }
}
