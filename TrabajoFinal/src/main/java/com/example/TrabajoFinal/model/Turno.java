package com.example.TrabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_odon")
    private Odontologo odontologo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pac")
    private Paciente paciente;
    @Column
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime diaHora;

    public Turno(Long id, Odontologo odontologo, Paciente paciente, LocalDateTime diaHora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.diaHora = diaHora;
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime diaHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.diaHora = diaHora;
    }

    public Turno(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(LocalDateTime diaHora) {
        this.diaHora = diaHora;
    }
}
