package com.example.TrabajoFinal.repository;

import com.example.TrabajoFinal.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
