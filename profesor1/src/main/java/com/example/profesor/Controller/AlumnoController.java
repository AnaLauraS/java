package com.example.profesor.Controller;

import com.example.profesor.Service.AlumnoServiceImpl;
import com.example.profesor.Service.ProfesorServiceImpl;
import com.example.profesor.modelo.Alumno;
import com.example.profesor.modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @PostMapping
    public ResponseEntity<?> crearProfesor(@RequestBody Alumno alumno) {
        alumnoService.guardar(alumno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Alumno> listartodos(){
        return alumnoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProfesor(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
