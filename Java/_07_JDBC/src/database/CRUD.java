package database;

import java.util.List;

public interface CRUD {
    //object es una clase genérica para los objetos donde cualquier objeto de java puede ser un object
    public Object insert(Object object);

    public boolean update(Object object);

    public boolean delete(Object object);

    public List<Object> findAll();

    public Object findById(int id);
}
