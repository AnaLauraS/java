package service;

import dao.IDao;
import model.Domicilio;
import java.util.List;

public class DomicilioService {
    private IDao<Domicilio> domicilioIDao;

    public DomicilioService(IDao<Domicilio> domicilioIDao){
        this.domicilioIDao = domicilioIDao;
    }

    public Domicilio guardar(Domicilio p) { return domicilioIDao.guardar(p);}
    public Domicilio buscar(Long id) {return domicilioIDao.buscar(id);}
    public List<Domicilio> buscartodos(){return domicilioIDao.buscarTodos();}
    public void eliminar(Long id){domicilioIDao.eliminar(id);
    }
}