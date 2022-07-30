package com.example.Integrador.services;

import com.example.Integrador.dao.IDao;
import com.example.Integrador.models.Turno;
import org.springframework.stereotype.Service;
import java.util.List;

//@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno registrarTuno(Turno turno){
        return turnoIDao.guardar(turno);
    }

    public List<Turno> listar(){
        return turnoIDao.buscarTodos();
    }

    public Turno actualizarTurno(Turno t){
        return turnoIDao.actualizar(t);
    }

    public Turno buscar(Integer id){
        return turnoIDao.buscar(id);
    }

    public void eliminar(Integer id){
        turnoIDao.eliminar(id);
    }
}
