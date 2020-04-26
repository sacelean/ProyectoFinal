package DAO;

import Biblioteca.Model.Libro;

public interface LibroDAO {

    void insertLibro(Libro libro) throws DAOException;

    void updateLibro(Libro libro) throws DAOException;

    Libro findLibro(String titulo) throws DAOException;
}
