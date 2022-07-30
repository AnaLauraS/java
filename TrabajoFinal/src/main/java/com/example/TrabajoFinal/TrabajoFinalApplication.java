package com.example.TrabajoFinal;

import com.example.TrabajoFinal.model.Odontologo;
import com.example.TrabajoFinal.model.Paciente;
import com.example.TrabajoFinal.model.Turno;
import com.example.TrabajoFinal.repository.IUserRepository;
import com.example.TrabajoFinal.repository.OdontologoRepository;
import com.example.TrabajoFinal.repository.PacienteRepository;
import com.example.TrabajoFinal.repository.TurnoRepository;
import com.example.TrabajoFinal.service.OdontologoService;
import com.example.TrabajoFinal.service.PacienteService;
import com.example.TrabajoFinal.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class TrabajoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

	@Bean
	CommandLineRunner start(OdontologoRepository or){
		return args -> {
			Odontologo o1  = new Odontologo("Perez", "Jose", "m01");
			Odontologo o2  = new Odontologo("Calix", "Maria", "m02");
			or.save(o1);
			or.save(o2);
		};
	}

	@Bean
	CommandLineRunner start2(PacienteRepository or){
		return args -> {
			Paciente o1  = new Paciente("Benitez", "Esteban", "calle1", 123435,LocalDate.now());
			or.save(o1);
		};
	}

	@Bean
	CommandLineRunner start3(TurnoRepository or){
		return args -> {
			Paciente p1 = new Paciente("Sic", "Ana", "calle2", 123435,LocalDate.now());
			Odontologo d1 = new Odontologo("Luks", "Tefi", "m03");
			Turno o1  = new Turno(d1,p1, LocalDateTime.of(2022,8,10,15,46));
			or.save(o1);
		};
	}
}