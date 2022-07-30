package clase13;

import org.apache.log4j.Logger;
import java.sql.*;

public class Base3 {
    // inicio el logger
    private static final Logger logger = Logger.getLogger(Base3.class);

    // creo las sentencias sql
    // crear tabla
    private static final String crearTabla = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS "
            + "("
            + "ID INT PRIMARY KEY, "
            + "APELLIDO varchar(20), "
            + "NOMBRE varchar(20), "
            + "MATRICULA varchar(20)"
            + ")";
    // inserto los objetos
    private static final String insert1 = "INSERT INTO ODONTOLOGOS ( ID, APELLIDO, NOMBRE, MATRICULA ) VALUES ( ?, ?, ?, ? )";
    // actualizo datos
    private static final String update = "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE ID = ?";
    // query
    private static final String query1 = "SELECT * FROM ODONTOLOGOS";

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
            res +=resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+" "+resultado.getString(4)+ "\n";
        }
        return res;}

    // ejecuto el programa observando las excepciones
    public static void main(String[] args) throws Exception{
        Connection connection = null;
        Odontologo doc1 = new Odontologo(1,"Gonzalez","Carlos", "m007");
        Odontologo doc2 = new Odontologo(2,"Otro","Fulano", "sinMatri");
        try{
            connection = getConnection();
            Statement stm = connection.createStatement();
            stm.execute(crearTabla);
            logger.info("creamos la conexión a la base de datos");

            connection.setAutoCommit(false);

            PreparedStatement pStm = connection.prepareStatement(insert1);
            pStm.setInt(1, 1);
            pStm.setString(2, doc1.getApellido());
            pStm.setString(3, doc1.getNombre());
            pStm.setString(4, doc1.getMatricula());
            pStm.execute();

            pStm.setInt(1, doc2.getID());
            pStm.setString(2, doc2.getApellido());
            pStm.setString(3, doc2.getNombre());
            pStm.setString(4, doc2.getMatricula());
            pStm.execute();

            System.out.println(verQuery(connection,query1));

            PreparedStatement pStm2 = connection.prepareStatement(update);
            pStm2.setString(1,"Mt2");
            pStm2.setInt(2,1);
            pStm2.executeUpdate();

            logger.debug("Actualizamos datos: \n" + verQuery(connection, query1));

            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            connection.rollback();
            logger.error("Algo salio mal: ", e);
            logger.debug(verQuery(connection, query1));
        }

        finally {
            try {connection.close();}
            catch (Exception e){
                logger.error("Tenemos error al cerrar la BD: ", e);
            }
        }
    }
}

