package clase11;

import org.apache.log4j.Logger;

import java.sql.*;

public class Base1 {
    // inicio el logger
    private static final Logger logger = Logger.getLogger(Base1.class);

    // creo las sentencias sql
    // crear tabla
    private static final String crearTabla = "DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS "
            + "("
            + "ID INT PRIMARY KEY, "
            + "FIGURA varchar(20), "
            + "COLOR varchar(20)"
            + ")";
    // inserto los objetos
    private static final String insert1 = "INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (1,'circulo','rojo')";
    private static final String insert2 = "INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (2,'circulo','verde')";
    private static final String insert3 = "INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (3,'cuadrado','rojo')";
    private static final String insert4 = "INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (4,'cuadrado','verde')";
    private static final String insert5 = "INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (5,'cuadrado','violeta')";
    // query para ver circulos rojos
    private static final String query1 = "SELECT * FROM FIGURAS";
    private static final String query2 = "SELECT * FROM FIGURAS WHERE FIGURA='circulo' AND COLOR='rojo'";

    //creo la conexión a la base de datos
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }

    // creo el metodo para mostrar la información, pasándole como parámetro la query
    public static void verQuery (Connection connection, String consulta) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet resultado = stm.executeQuery(consulta);
        while (resultado.next()){ //mientras haya resultados que mostrar, va a mostrar las siguientes columnas
            System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3));
    }}

    // ejecuto el programa observando las excepciones
    public static void main(String[] args) throws Exception{
            Connection connection = null;
            try{
                connection = getConnection();
                Statement stm = connection.createStatement();
                stm.execute(crearTabla);
                stm.execute(insert1);
                stm.execute(insert2);
                stm.execute(insert3);
                stm.execute(insert4);
                stm.execute(insert5);
                logger.info("creamos la conexión a la base de datos");
                verQuery(connection,query1);
                verQuery(connection,query2);

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
