import dao.OdontologoDaoH2;
import model.Odontologo;
import org.junit.BeforeClass;
import service.OdontologoService;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class OdontologoServiceTest {

        private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        @BeforeClass
        public static void cargarDataSet() throws Exception {
            Odontologo o1 = new Odontologo(1L,"mt001","Adrian", "Fulano");
            Odontologo o2 = new Odontologo(2L,"mt002","Carla", "Mengano");
            BD.crearBD();
            odontologoService.guardar(o1);
            odontologoService.guardar(o2);
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

