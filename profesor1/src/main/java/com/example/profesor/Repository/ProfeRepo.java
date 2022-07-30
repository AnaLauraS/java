package com.example.profesor.Repository;

import com.example.profesor.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfeRepo extends JpaRepository<Profesor,Long> {
}
