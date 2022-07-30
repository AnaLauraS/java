package clase14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final String SQL_CREATE_TABLE =" DROP TABLE IF EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY, " +
            " NOMBRE varchar(100), " +
            " LABORATORIO varchar(100), " +
            "CANTIDAD INT NOT NULL, " +
            "PRECIO DOUBLE NOT NULL)";

    public static void crearBD() throws Exception{
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

}
