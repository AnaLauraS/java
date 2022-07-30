package com.example.profesor.Repository;

import com.example.profesor.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepo extends JpaRepository<Alumno,Long> {
}
