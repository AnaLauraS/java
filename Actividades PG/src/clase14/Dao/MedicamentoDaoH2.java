package clase14.Dao;

import clase14.Model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento>{

    final static Logger log = Logger.getLogger(MedicamentoDaoH2.class);

//falta el close connection

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        log.debug("Registrando un nuevo medicamento :"+medicamento.toString());
        Connection connection = null;
        try{
            //1 levantar la conexion
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos(nombre,laboratorio,cantidad,precio) VALUES(?,?,?,?)");

            //2 creamos la sentencia
            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getLaboratorio());
            preparedStatement.setInt(3, medicamento.getCantidad());
            preparedStatement.setDouble(4, medicamento.getPrecio());

            //3 ejecutamos la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        log.debug("Buscando un medicamento con id:"+id);
        Connection connection = null;
        Medicamento medicamento = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 levantar la conexion
            connection = getConnection();

            //2 creamos la sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos where id= ?");
            preparedStatement.setInt(1,id);

            //3 ejecutamos la sentencia
            ResultSet result = preparedStatement.executeQuery();

            //4 obtener los datos
            while(result.next()){
                int idMedicamento = result.getInt("id");
                String nombre = result.getString("nombre");
                String laboratorio = result.getString("laboratorio");
                int cantidad = result.getInt("cantidad");
                double precio = result.getDouble("precio");
                medicamento = new Medicamento(idMedicamento,nombre,laboratorio,cantidad,precio);
                log.debug(medicamento.toString());
            }
            preparedStatement.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicamento;
    }

    @Override
    public Medicamento buscarPorNombre(String nombreMedicamento) {
        log.debug("Buscando un medicamento con nombre: "+nombreMedicamento);
        Connection connection = null;
        Medicamento medicamento = null;
        PreparedStatement buscar = null;

        try{
            connection = getConnection();
            buscar = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE NOMBRE = ?");
            buscar.setString(1, nombreMedicamento);

            ResultSet result = buscar.executeQuery();

            while (result.next()) {
                int idMedicamento = result.getInt("id");
                String nombre = result.getString("nombre");
                String laboratorio = result.getString("laboratorio");
                int cantidad = result.getInt("cantidad");
                double precio = result.getDouble("precio");
                medicamento = new Medicamento(idMedicamento, nombre, laboratorio, cantidad, precio);
                log.debug(medicamento.toString());
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return medicamento;
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
}