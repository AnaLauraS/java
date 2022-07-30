package com.example.Integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjIntegradorApplication {

	public static void main(String[] args) throws Exception {
		BD.crearBD();
		SpringApplication.run(EjIntegradorApplication.class, args);
	}
}