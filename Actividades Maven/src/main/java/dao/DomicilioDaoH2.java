package dao;

import model.Domicilio;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private static final Logger logger = Logger.getLogger(DomicilioDaoH2.class);

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try{
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM domicilios");
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    Long idDom = result.getLong("id");
                    String calle = result.getString("calle");
                    int numero = result.getInt("numero");
                    String localidad = result.getString("localidad");
                    String provincia = result.getString("provincia");

                    Domicilio domicilio = new Domicilio(idDom, calle, numero, localidad, provincia);
                    domicilios.add(domicilio);
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
        return domicilios;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("INSERT INTO domicilios (calle, numero, localidad, provincia, id) VALUES (?,?,?,?,?)");

                preparedStatement.setString(1, domicilio.getCalle());
                preparedStatement.setInt(2, domicilio.getNumero());
                preparedStatement.setString(3, domicilio.getLocalidad());
                preparedStatement.setString(4, domicilio.getProvincia());
                preparedStatement.setLong(5, domicilio.getId());

                preparedStatement.close();
            } catch (SQLException e){
                logger.error("Error al hacer la query: ", e);
            }

        }catch (ClassNotFoundException | SQLException e){
            logger.error("Error al conectar con la base de datos: ", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;

        try {
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM domicilios where id = ?");
                preparedStatement.setLong(1,id);
                ResultSet result = preparedStatement.executeQuery();

                while(result.next()){
                    Long idDom = result.getLong("id");
                    String calle = result.getString("calle");
                    int numero = result.getInt("numero");
                    String localidad = result.getString("localidad");
                    String provincia = result.getString("provincia");
                    domicilio = new Domicilio(idDom, calle, numero, localidad, provincia);
                }
                preparedStatement.close();

            }catch ( SQLException e){
                logger.error("Error al hacer la query: ", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = getConnection();
            logger.info("Conexión a la base de datos realizada");

            try {
                preparedStatement = connection.prepareStatement("DELETE FROM domicilio where id = ?");
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