package com.example.demo.Controller;

import com.example.demo.Model.Entrenador;
import com.example.demo.Service.entrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private com.example.demo.Service.entrenadorService entrenadorService;

    @GetMapping("")
    public String inicio(){
        return "index";
    }

    @GetMapping("/listado")
        public String listado(Model model){
        ArrayList<Entrenador> entrenadores = (ArrayList<Entrenador>) entrenadorService.listarEntrenadores();
        model.addAttribute("entrenadores",entrenadores);
        return "listado";
    }
}
