package com.example.Integrador.controllers;

import com.example.Integrador.dao.Impl.OdontologoDaoH2;
import com.example.Integrador.models.Odontologo;
import com.example.Integrador.services.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/")
    public List<Odontologo> buscartodos(){
        return odontologoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorIdPorPath(@PathVariable Integer id){
        return odontologoService.buscarPorId(id);
    }

    @GetMapping("/RP")
    public Odontologo buscarPorIdPorRP(@RequestParam Integer id){
        return odontologoService.buscarPorId(id);
    }

    @PutMapping("/")
    public Odontologo actualizar(@RequestBody Odontologo o){
        return odontologoService.actualizarOdontologo(o);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        odontologoService.eliminar(id);
    }

    @PostMapping("/")
    public Odontologo crear(@RequestBody Odontologo o){
        return odontologoService.guardar(o);
    }

}
