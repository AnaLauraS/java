package Clase18.sync.Service;

import Clase18.sync.Dao.IDao;
import Clase18.sync.Model.Odontologo;

import java.util.List;

public class OdontologoService {

    private final IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo)
    {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscartodos(){
        return odontologoIDao.buscarTodos();
    }
}
