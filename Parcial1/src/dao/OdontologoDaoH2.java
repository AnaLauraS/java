package dao;

import model.Odontologo;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao <Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    @Override
    public List<Odontologo> listarTodos() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
                ResultSet result = preparedStatement.executeQuery();
                logger.info("Consulta ejecutada, estos son todos los odontólogos registrados:");

                while (result.next()) {
                    Long id = result.getLong("id");
                    String matricula = result.getString("matricula");
                    String nombre = result.getString("nombre");
                    String apellido = result.getString("apellido");
                    Odontologo odontologo = new Odontologo( id, matricula, nombre, apellido);
                    odontologos.add(odontologo);
                    System.out.println(result.getLong(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+ "\n");
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
        return odontologos;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (id, matricula, nombre, apellido) VALUES (?,?,?,?)");

                preparedStatement.setLong(1, odontologo.getId());
                preparedStatement.setString(2, odontologo.getMatricula());
                preparedStatement.setString(3, odontologo.getNombre());
                preparedStatement.setString(4, odontologo.getApellido());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                logger.info("Odontologo de ID "+odontologo.getId()+" agregado a la base de datos");
            } catch (SQLException e){
                logger.error("Error al hacer al guardar el odontologo de ID " + odontologo.getId() + " :", e);
            }

        }catch (ClassNotFoundException | SQLException e){
            logger.error("Error al conectar con la base de datos: ", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologo;
    }
}
