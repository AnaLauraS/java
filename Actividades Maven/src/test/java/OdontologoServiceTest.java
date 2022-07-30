import dao.BD;
import dao.DomicilioDaoH2;
import dao.OdontologoDaoH2;
import dao.PacienteDaoH2;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import org.junit.BeforeClass;
import service.DomicilioService;
import service.OdontologoService;
import service.PacienteService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class OdontologoServiceTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private static DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());

    @BeforeClass
    public static void cargarDataSet() throws Exception {
        Odontologo o1 = new Odontologo(1L,"mt001","Adrian", "Fulano");
        Odontologo o2 = new Odontologo(2L,"mt002","Carla", "Mengano");
        Domicilio d1 = new Domicilio(1L,"calle1", 123, "loc1", "bsas");
        Domicilio d2 = new Domicilio(2L,"calle2", 123, "loc2", "bsas");
        Paciente p1 = new Paciente(1L,"juan", "mendez", 123, LocalDate.now(),d1);
        Paciente p2 = new Paciente(2L,"laura", "gonzalez", 623, LocalDate.now(),d2);
        BD.crearBD();
        odontologoService.guardar(o1);
        odontologoService.guardar(o2);
        pacienteService.guardar(p1);
        pacienteService.guardar(p2);

    }

    @org.junit.jupiter.api.Test
    protected void listarTodos() throws SQLException{
        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertTrue(!odontologos.isEmpty());
        assertTrue(odontologos.size() > 0);
    }

    @org.junit.jupiter.api.Test
    public void guardar() throws SQLException{
        Odontologo o3 = new Odontologo(3L,"mt003","Andrea", "Tito");
        odontologoService.guardar(o3);
        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertFalse(odontologos.size() < 3);
    }
}

