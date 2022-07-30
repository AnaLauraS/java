package com.example.Integrador.dao.Impl;

import com.example.Integrador.dao.IDao;
import com.example.Integrador.models.Turno;
import java.util.ArrayList;
import java.util.List;

public class TurnoDao implements IDao<Turno> {

    private List<Turno> turnos;

    public TurnoDao(){
        turnos = new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno actualizar(Turno turno) {
        Turno turnoRes = null;
        if(turno.getId() != null){
            for (int i=0; i<turnos.size(); i++) {
                if(turnos.get(i).getId() == turno.getId()){
                    turnos.get(i).setPaciente(turno.getPaciente());
                    turnos.get(i).setOdontologo(turno.getOdontologo());
                    turnos.get(i).setFecha(turno.getFecha());
                    turnoRes = turnos.get(i);
                }
            }
        }
        return turnoRes;
    }

    @Override
    public Turno buscar(Integer id) {
        Turno turno = null;
        for (int i=0; i<turnos.size(); i++) {
            if(turnos.get(i).getId() == id){
                turno = turnos.get(i);
            }
        }
        return turno;
    }

    @Override
    public void eliminar(Integer id) {
        for (int i=0; i<turnos.size(); i++) {
            if(turnos.get(i).getId() == id){
                turnos.remove(i);
            }
        }
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }
}