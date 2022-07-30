package Clase18.sync;

import Clase18.sync.Dao.Impl.OdontologoDaoH2;
import Clase18.sync.Dao.Impl.PacienteDaoH2;
import Clase18.sync.Model.Domicilio;
import Clase18.sync.Model.Odontologo;
import Clase18.sync.Model.Paciente;
import Clase18.sync.Service.OdontologoService;
import Clase18.sync.Service.PacienteService;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        BD.crearBD();
        Domicilio domicilio = new Domicilio("Av siempre viva","45","Usme","Bogotá");
        Paciente paciente = new Paciente("Jeisson","López",123, LocalDate.now(),domicilio);
        pacienteService.guardar(paciente);

        List<Paciente> result = pacienteService.buscartodos();
        for(Paciente paciente1 : result)
        {
            System.out.println(paciente1.getId());
            System.out.println(paciente1.getNombre());
            System.out.println(paciente1.getApellido());
            System.out.println(paciente1.getDni());
            System.out.println(paciente1.getFechaIngreso());
            System.out.println(paciente1.getDomicilio().getId());
            System.out.println(paciente1.getDomicilio().getCalle());
            System.out.println(paciente1.getDomicilio().getNumero());
            System.out.println(paciente1.getDomicilio().getLocalidad());
            System.out.println(paciente1.getDomicilio().getProvincia());
        }

        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
        BD.crearBD();
        Odontologo odontologo = new Odontologo(45L,"Camilo","Martínez");
        odontologoService.guardar(odontologo);

        odontologo = new Odontologo(124L,"Alberto","Alba");
        odontologoService.guardar(odontologo);

        odontologo = new Odontologo(32L,"Sandra","Pinzón");
        odontologoService.guardar(odontologo);

        List<Odontologo> result1 = odontologoService.buscartodos();
        for(Odontologo odontologo1 : result1)
        {
            System.out.println(odontologo1.toString());
        }
    }
}
