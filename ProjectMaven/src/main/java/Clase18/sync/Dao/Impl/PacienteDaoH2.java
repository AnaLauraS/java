package Clase18.sync.Dao.Impl;

import Clase18.sync.Dao.IDao;
import Clase18.sync.Model.Domicilio;
import Clase18.sync.Model.Paciente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();

    @Override
    public List<Paciente> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();
        try{
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int dni = result.getInt("dni");
                LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                Long idDomicilio = result.getLong("domicilio_id");
                Domicilio domicilio1 = domicilioDaoH2.buscar(idDomicilio);
                Paciente paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio1);
                pacientes.add(paciente);
            }
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pacientes;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            Domicilio domicilio = domicilioDaoH2.guardar(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            preparedStatement = connection.prepareStatement("INSERT INTO pacientes (nombre,apellido,dni,fecha_ingreso,domicilio_id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setInt(3,paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setDouble(5,paciente.getDomicilio().getId());

            preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();
            if(res.next()){
                paciente.setId(res.getLong(1));
            }

            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM pacientes where id = ?");
            preparedStatement.setLong(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int dni = result.getInt("dni");
                LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                Long idDomicilio = result.getLong("domicilio_id");
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
            }
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{

            connection = getConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

                            public static Connection getConnection() throws Exception{
                                return DriverManager.getConnection("jdbc:h2:~/test","sa","");
                            }
}
