package Clase18.sync;

import Clase18.sync.Dao.Impl.OdontologoDaoH2;
import Clase18.sync.Model.Odontologo;
import Clase18.sync.Service.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class OdontologoServiceTest {

    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeEach
    public void alistarBaseDeDatos() throws Exception {
        BD.crearBD();
    }
    @Test
    public void guardarOdontologo(){
        Odontologo odontologo = new Odontologo(45L,"Camilo","Martínez");
        odontologo = odontologoService.guardar(odontologo);
        assertEquals(1, (long) odontologo.getId());
    }

    @Test
    public void buscartodosLosOdontologos(){
        Odontologo odontologo = new Odontologo(45L,"Camilo","Martínez");
        odontologoService.guardar(odontologo);

        odontologo = new Odontologo(124L,"Alberto","Alba");
        odontologoService.guardar(odontologo);

        odontologo = new Odontologo(32L,"Sandra","Pinzón");
        odontologoService.guardar(odontologo);

        List<Odontologo> result = odontologoService.buscartodos();
        assertEquals(3, result.size());
    }


}