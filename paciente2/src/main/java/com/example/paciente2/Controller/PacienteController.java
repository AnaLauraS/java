package com.example.paciente2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    @GetMapping("/index") //cuando model es el parámetro, es la forma de mandar datos del controlador a la vista
    public String welcome(Model model) {
        // el primer parámetro es el nombre del atributo. el segundo parámetro es el valor. Luego en el index.html, llamo los datos como variables (como las APIs)
        model.addAttribute("nombre", "diez");
        return "index";
    }
}
