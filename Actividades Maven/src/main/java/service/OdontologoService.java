package service;

import dao.IDao;
import model.Odontologo;
import java.sql.SQLException;
import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public List<Odontologo> listarTodos () throws SQLException { return this.odontologoIDao.buscarTodos();};
    public Odontologo guardar (Odontologo odontologo) throws SQLException { return this.odontologoIDao.guardar(odontologo);};
    public Odontologo buscar(Long idO) { return this.odontologoIDao.buscar(idO);};
    public void eliminar(Long id) { this.odontologoIDao.eliminar(id);};
    }
