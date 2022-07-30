package Clase15;

import Clase15.dao.PacienteDaoH2;
import Clase15.model.Domicilio;
import Clase15.model.Paciente;
import Clase15.service.PacienteService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        BD15.crearBD();
        Domicilio domicilio = new Domicilio("calle1",45,"loc1","bsas");
        Paciente paciente = new Paciente("ana","laura",111, LocalDate.now(),domicilio);
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
    }
}
