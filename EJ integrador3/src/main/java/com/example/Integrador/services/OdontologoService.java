package com.example.Integrador.services;

import com.example.Integrador.dao.IDao;
import com.example.Integrador.models.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public OdontologoService(){
    }

    public Odontologo guardarOdontologo(Odontologo o){
        return odontologoIDao.guardar(o);
    }

    public Odontologo actualizarOdontologo(Odontologo o){
        return odontologoIDao.actualizar(o);
    }

    public Odontologo buscar(Integer id){
        return odontologoIDao.buscar(id);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoIDao.buscarTodos();
    }

    public void eliminar(Integer id){
        odontologoIDao.eliminar(id);
    }
}