package Clase18.sync.Dao;

import java.util.List;

public interface IDao<T> {

    public List<T> buscarTodos();
    public T guardar(T t);
    public T buscar(Long id);
    public void eliminar(Long id);

}