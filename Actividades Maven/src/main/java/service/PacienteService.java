package service;

import dao.IDao;
import model.Paciente;
import java.sql.SQLException;
import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao){
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) throws SQLException { return pacienteIDao.guardar(p);}
    public Paciente buscar(Long id)throws SQLException {return pacienteIDao.buscar(id);}
    public List<Paciente> buscartodos(){return pacienteIDao.buscarTodos();}
    public void eliminar(Long id){pacienteIDao.eliminar(id);
    }
}
