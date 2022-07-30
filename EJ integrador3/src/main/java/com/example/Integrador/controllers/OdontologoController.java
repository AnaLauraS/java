package com.example.Integrador.controllers;

import com.example.Integrador.dao.Impl.OdontologoDaoH2;
import com.example.Integrador.models.Odontologo;
import com.example.Integrador.services.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        ResponseEntity<Odontologo> response = null;
        if(odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null){
            response =  ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id){
        ResponseEntity response = null;
        if(odontologoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity(odontologoService.buscar(id),HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity response = null;

        if(odontologoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity buscarTodos(){
        ResponseEntity response = null;
        if(odontologoService.buscarTodos() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            response = new ResponseEntity(odontologoService.buscarTodos(),HttpStatus.OK);
        }
        return response;
    }
}