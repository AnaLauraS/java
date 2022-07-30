package com.example.profesor.Controller;

import com.example.profesor.Service.ProfesorServiceImpl;
import com.example.profesor.modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

    @PostMapping
    public ResponseEntity<?> crearProfe(@RequestBody Profesor profesor) {
        profesorService.guardar(profesor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Profesor> listartodos(){
        return profesorService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
