package com.example.Integrador.controllers;

import com.example.Integrador.models.Paciente;
import com.example.Integrador.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/todos")
    public String getAll(){
        List<Paciente> lista=pacienteService.getAll();
        return "todos";
    }

    @GetMapping("/email/{email}")
    public String getPacienteByEmailporpath(@PathVariable String email, Model model){
        Paciente paciente = pacienteService.getPacientByEmail(email);
        if(paciente==null){
            return "error";
        }
        model.addAttribute("name",paciente.getNombre());
        model.addAttribute("surname",paciente.getApellido());
        model.addAttribute("email",paciente.getEmail());
        return "email";
    }

}
