package Clase15.dao;

import Clase15.model.Domicilio;
import Clase15.model.Paciente;
import org.apache.log4j.Logger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente>{

    private static final Logger logger = Logger.getLogger(PacienteDaoH2.class);
    private Clase15.dao.DomicilioDaoH2 domicilioDaoH2 = new Clase15.dao.DomicilioDaoH2();

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    @Override
    public List<Paciente> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();

        try{
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    Long idPaciente = result.getLong("id");
                    String nombre = result.getString("nombre");
                    String apellido = result.getString("apellido");
                    int dni = result.getInt("dni");
                    LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                    Long idDomicilio = result.getLong("domicilio");
                    Domicilio domicilio1 = domicilioDaoH2.buscar(idDomicilio);
                    Paciente paciente = new Paciente(idPaciente, nombre, apellido, dni, fechaIngreso, domicilio1);
                    pacientes.add(paciente);
                }
                preparedStatement.close();
            }
            catch (SQLException e){
                logger.error("Error al hacer la query: ", e);
                }

        }catch (ClassNotFoundException | SQLException e){
                logger.error("Error al conectar con la base de datos: ", e);
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
            logger.info("Conexión a la base de datos realizada");

            try {
                // creo objeto domicilio que va a ser la creacion de un domicilio con el ID que le paso del paciente
                Domicilio domicilio = domicilioDaoH2.guardar(paciente.getDomicilio());
                paciente.getDomicilio().setId(domicilio.getId());

                // Statement.RETURN_GENERATED_KEYS en un insert para que el id sea autoincremental
                preparedStatement = connection.prepareStatement("INSERT INTO pacientes (nombre,apellido,dni,fecha_ingreso,id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, paciente.getNombre());
                preparedStatement.setString(2, paciente.getApellido());
                preparedStatement.setInt(3, paciente.getDni());
                preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
                preparedStatement.setLong(5, paciente.getDomicilio().getId());

                preparedStatement.executeUpdate();
                ResultSet res = preparedStatement.getGeneratedKeys();
                if (res.next()) {
                    paciente.setId(res.getLong(1));
                }

                preparedStatement.close();
            } catch (SQLException e){
                logger.error("Error al hacer la query: ", e);
            }

        }catch (ClassNotFoundException | SQLException e){
            logger.error("Error al conectar con la base de datos: ", e);
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
            logger.info("Conexión a la base de datos realizada");

            try {
            preparedStatement = connection.prepareStatement("SELECT * FROM pacientes where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int dni = result.getInt("dni");
                LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                Long idDomicilio = result.getLong("domicilio");
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
            }
            preparedStatement.close();

            }catch ( SQLException e){
                logger.error("Error al hacer la query: ", e);
            }
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
            logger.info("Conexión a la base de datos realizada");

            try {
            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            }catch (SQLException e){
                logger.error("Error al hacer la query: ", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
