package Clase15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD15 {
    private static final String crearTablaPacientes = "DROP TABLE IF EXISTS pacientes; CREATE TABLE pacientes "
            + "("
            + "ID long PRIMARY KEY, "
            + "NOMBRE varchar(20), "
            + "APELLIDO varchar(20) NOT NULL, "
            + "DNI int, "
            + "FECHA_INGRESO date, "
            + "DOMICILIO int"
            + ")";

    private static final String crearTablaDomicilios = "DROP TABLE IF EXISTS domicilios; CREATE TABLE domicilios "
            + "("
            + "ID long PRIMARY KEY, "
            + "CALLE varchar(20), "
            + "NUMERO int, "
            + "LOCALIDAD varchar(20), "
            + "PROVINCIA varchar(20)"
            + ")";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
    public static void crearBD() throws Exception{
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(crearTablaDomicilios);
            statement.execute(crearTablaPacientes);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}

