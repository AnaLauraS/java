package Clase18.sync;

import Clase18.sync.Dao.Impl.PacienteDaoH2;
import Clase18.sync.Model.Domicilio;
import Clase18.sync.Model.Paciente;
import Clase18.sync.Service.PacienteService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteServiceTest{

    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @BeforeClass
    public static void cargarDataSet() throws SQLException {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", 88888888, LocalDate.of(2022,05,23), domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", 99999999, LocalDate.of(2022,06,02), domicilio));

    }

    @Test
    public void agregarYBuscarPacienteTest() throws SQLException {
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", 12345678, LocalDate.of(2022,07,23), domicilio));

        assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() throws SQLException {
        pacienteService.eliminar(3L);
        assertTrue(pacienteService.buscar(3L) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscartodos();
        assertTrue(!pacientes.isEmpty());
        assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }
}

