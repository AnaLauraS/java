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
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @PostMapping
    public ResponseEntity<?> crearProfe(@RequestBody Profesor profesor) {
        profesorService.guardar(profesor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/new/{id}")
    public String addAlumnosToProfesor(@RequestBody List<Alumno> alumnos,
                                    @PathVariable Long id){
        Profesor profesor = profesorService.buscarPorID(id);
        profesor.setAlumnos(alumnos);
        profesorService.guardar(profesor);
        for (Alumno alumnos1: alumnos) {
            Alumno alumno = alumnoService.buscarPorID(alumnos1.getId());
            alumno.setProfesor(profesor);
            alumnoService.guardar(alumno);
        }
        return "Alumnos Creados con exito";
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

    @GetMapping("/{id}")
    public Profesor buscarPorId(@PathVariable Long id){
        return profesorService.buscarPorID(id);
    }

}
