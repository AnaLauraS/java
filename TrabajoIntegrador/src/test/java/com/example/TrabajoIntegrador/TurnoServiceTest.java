package com.example.TrabajoIntegrador;

import com.example.TrabajoIntegrador.exceptions.NotFound;
import com.example.TrabajoIntegrador.model.Odontologo;
import com.example.TrabajoIntegrador.model.Paciente;
import com.example.TrabajoIntegrador.model.Turno;
import com.example.TrabajoIntegrador.service.TurnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// NOTA: comenté el @RunWith porque no me gustaba que el JUnit Vintage se mostrara en rojo. Los test funcionan con o sin esa notación.
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTest {
    @Autowired
    private TurnoService t;

    @Test
    void buscarPorIdExistente() throws NotFound {
        Turno turno = t.buscarPorId(1L);
        assertNotNull(turno);
    }

    @Test
    void buscarPorIdInexistente() {
        NotFound thrown = Assertions.assertThrows(NotFound.class, () -> {
            Turno turno = t.buscarPorId(9L);
        });
        Assertions.assertEquals("No existe el ID", thrown.getMessage());
    }

    @Test
    void listarTurnos(){
        List<Turno> turnosListados = t.listar();
        assertTrue(turnosListados.size()!=0);
    }

    @Test
    void agregar(){
        List<Turno> turnosListados = t.listar();
        int primerMonto = turnosListados.size();
        Odontologo o=new Odontologo("Perez", "Fulano", "my8");
        Paciente p=new Paciente("nombre", "apellido", "calle123", 123, LocalDate.now());
        Turno turno = new Turno(o,p, LocalDateTime.now());
        t.agregar(turno);
        int segundoMonto=t.listar().size();
        assertTrue(segundoMonto==primerMonto+1);
    }
}
