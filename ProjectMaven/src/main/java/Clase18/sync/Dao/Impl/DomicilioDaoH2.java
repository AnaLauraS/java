package Clase18.sync.Dao.Impl;

import Clase18.sync.Dao.IDao;
import Clase18.sync.Model.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    @Override
    public List<Domicilio> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try{
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM domicilios");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idDomicilio = result.getLong("domicilio_id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");
                Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
                domicilios.add(domicilio);
            }
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
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

            preparedStatement = connection.prepareStatement("INSERT INTO domicilios (calle,numero,localidad,provincia) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,domicilio.getCalle());
            preparedStatement.setString(2,domicilio.getNumero());
            preparedStatement.setString(3,domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());


            preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();
            if(res.next()){
                domicilio.setId(res.getLong(1));
            }

            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
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

            preparedStatement = connection.prepareStatement("SELECT * FROM domicilios where domicilio_id = ?");
            preparedStatement.setLong(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long IdDomicilio = result.getLong("domicilio_id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");
                domicilio = new Domicilio(IdDomicilio,calle,numero,localidad,provincia);
            }
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
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

            preparedStatement = connection.prepareStatement("DELETE FROM domicilios where domicilio_id = ?");
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
