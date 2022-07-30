package Clase18.sync.Dao.Impl;


import Clase18.sync.Dao.IDao;
import Clase18.sync.Model.Domicilio;
import Clase18.sync.Model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static Logger log = LogManager.getLogger(OdontologoDaoH2.class);

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long id = result.getLong("id");
                Long matricula = result.getLong("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Odontologo odontologo = new Odontologo(id,matricula,nombre,apellido);
                odontologos.add(odontologo);
            }

            log.info("Se realizó la búsqueda de todos los odontólogos con el motor de base de datos H2 de manera exitosa");
            preparedStatement.close();
        }catch (Exception e){
            log.error(e);
        }finally {
            try {
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                log.error(e);
            }
        }

        return odontologos;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO odontologos (matricula,nombre,apellido) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1,odontologo.getMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());


            preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();
            if(res.next()){
                odontologo.setId(res.getLong(1));
            }

            log.info("Se creó un odontólogo con el motor de base de datos H2 de manera exitosa");
            preparedStatement.close();

        }catch (Exception e) {
            log.error(e);
        }finally {
            try {
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                log.error(e);
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos where id = ?");
            preparedStatement.setLong(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idOdontologo = result.getLong("id");
                Long matricula = result.getLong("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                odontologo = new Odontologo(idOdontologo,matricula,nombre,apellido);
            }
            preparedStatement.close();

        }catch (Exception e){
            log.error(e);
        }finally {
            try {
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                log.error(e);
            }
        }
        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{

            connection = getConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            log.error(e);
        }finally {
            try {
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                log.error(e);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
}
