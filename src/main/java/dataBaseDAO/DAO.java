package dataBaseDAO;

import java.util.List;

public interface DAO<T> {

    T find (long id) throws DAOException;

    List<T> search(String... values) throws DAOException;

    List<T> list() throws DAOException;

    int update(T t, String... values) throws IllegalArgumentException, DAOException;

    int delete(T t) throws  IllegalArgumentException, DAOException;

    void save(T t) throws IllegalArgumentException, DAOException;

}