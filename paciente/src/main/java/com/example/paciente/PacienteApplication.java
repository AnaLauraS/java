package com.example.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //informa que es un controlador

public class PacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);
	}

	@GetMapping //le digo cual será la URL. por ejemplo, si le pongo: ("/urlbienvenida") , va a aparecer en el puerto 8080/urlbienvenida
	public String holaPAciente(){
		return "Hola Paciente";
	}

}
