package clase14.Dao;

import java.sql.SQLException;

public interface IDao  <T> {

    public T guardar(T t) throws SQLException;
    public T buscar(Integer id);
    public T buscarPorNombre(String nombre);

}
