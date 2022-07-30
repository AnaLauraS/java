package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T>{

    public List<T> listarTodos () throws SQLException;
    public T guardar (T t) throws SQLException;
}
