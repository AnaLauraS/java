package clase12;

import clase11.Base1;
import org.apache.log4j.Logger;

import java.sql.*;

public class Base2 {
    // inicio el logger
    private static final Logger logger = Logger.getLogger(Base1.class);

    // creo las sentencias sql
    // crear tabla
    private static final String crearTabla = "DROP TABLE IF EXISTS EMPLEADOS; CREATE TABLE EMPLEADOS "
            + "("
            + "ID INT PRIMARY KEY, "
            + "LEGAJO varchar(20), "
            + "COLORDEPELO varchar(20), "
            + "TALLEZAPATILLA INT, "
            + "TIENEHIJOS boolean"
            + ")";
    // inserto los objetos
    private static final String insert1 = "INSERT INTO EMPLEADOS (ID, LEGAJO, COLORDEPELO, TALLEZAPATILLA, TIENEHIJOS) VALUES (1,'legajo1','rojo', 41, true)";
    private static final String insert2 = "INSERT INTO EMPLEADOS (ID, LEGAJO, COLORDEPELO, TALLEZAPATILLA, TIENEHIJOS) VALUES (1,'legajo2','verde', 36, false)";
    private static final String insert3 = "INSERT INTO EMPLEADOS (ID, LEGAJO, COLORDEPELO, TALLEZAPATILLA, TIENEHIJOS) VALUES (3,'legajo3','morocho', 40, true)";

    // actualizo datos
    private static final String update = "UPDATE EMPLEADOS SET COLORDEPELO='rubio' WHERE ID=3 ";

    // elimino usuarios
    private static final String delete1 = "DELETE FROM EMPLEADOS WHERE ID=3 ";
    private static final String delete2 = "DELETE FROM EMPLEADOS WHERE TALLEZAPATILLA=41 ";

    // query
    private static final String query1 = "SELECT * FROM EMPLEADOS";
    private static final String query2 = "SELECT * FROM EMPLEADOS WHERE ID=3";

    //creo la conexión a la base de datos
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    // creo el metodo para mostrar la información, pasándole como parámetro la query
    public static String verQuery (Connection connection, String consulta) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet resultado = stm.executeQuery(consulta);
        String res="";
        while (resultado.next()){ //mientras haya resultados que mostrar, va a mostrar las siguientes columnas
            res +=resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+" "+resultado.getInt(4)+" "+resultado.getBoolean(5) + "\n";
        }
    return res;}

    // ejecuto el programa observando las excepciones
    public static void main(String[] args) throws Exception{
        Connection connection = null;
        try{
            connection = getConnection();
            Statement stm = connection.createStatement();
            stm.execute(crearTabla);
            stm.execute(insert1);
            stm.execute(insert3);

            logger.info("creamos la conexión a la base de datos");
            System.out.println(verQuery(connection,query1));

            stm.execute(update);
            logger.debug(verQuery(connection, query2));

            stm.execute(delete1);
            stm.execute(delete2);
            logger.info(verQuery(connection, query2));

        } catch (Exception e) {
            logger.error("Algo salio mal: ", e);
        }

        finally {
            try {connection.close();}
            catch (Exception e){
                logger.error("Tenemos error al cerrar la BD: ", e);
            }
        }
    }
}
