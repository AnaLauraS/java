package com.example.TrabajoIntegrador.service;

import com.example.TrabajoIntegrador.model.Odontologo;
import com.example.TrabajoIntegrador.model.Paciente;
import com.example.TrabajoIntegrador.model.Turno;
import com.example.TrabajoIntegrador.repository.OdontologoRepository;
import com.example.TrabajoIntegrador.repository.PacienteRepository;
import com.example.TrabajoIntegrador.repository.TurnoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    private OdontologoRepository or;
    private PacienteRepository pr;
    private TurnoRepository tr;

    public DataLoader(OdontologoRepository or, PacienteRepository pr,TurnoRepository tr){
        this.pr=pr;
        this.or=or;
        this.tr=tr;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Odontologo o1  = new Odontologo("Perez", "Jose", "m01");
        Odontologo o2  = new Odontologo("Calix", "Maria", "m02");
        or.save(o1);
        or.save(o2);
        Paciente p1  = new Paciente("Benitez", "Esteban", "calle1", 123435, LocalDate.now());
        pr.save(p1);
        Paciente p2 = new Paciente("Sic", "Ana", "calle2", 123435,LocalDate.now());
        Odontologo d1 = new Odontologo("Luks", "Tefi", "m03");
        Turno t1  = new Turno(d1,p2, LocalDateTime.of(2022,8,10,15,46));
        tr.save(t1);
    }
}