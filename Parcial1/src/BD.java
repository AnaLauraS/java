import java.sql.*;
import org.apache.log4j.Logger;

public class BD {

    private static final Logger logger = Logger.getLogger(BD.class);
    private static final String crearTabla = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS "
            + "("
            + "ID LONG PRIMARY KEY, "
            + "MATRICULA varchar (20), "
            + "NOMBRE varchar(20), "
            + "APELLIDO varchar(20)"
            + ")";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    public static void crearBD() throws Exception{
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(crearTabla);
            logger.info("Conexión a la base de datos realizada");
        }catch (Exception e){
            logger.error("Error al crear la tabla en la base de datos: ", e);
        } finally {
            connection.close();
        }
    }
}