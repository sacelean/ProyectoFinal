package DAO;

import Biblioteca.Model.Libro;
import DAO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static DAO.DAOUtil.prepareStatement;

public class LibroDAOImpl implements DAO<Libro> {

    private DAOFactory daoFactory;

    public LibroDAOImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    private static Libro map(ResultSet resultSet) throws SQLException {
        Libro libro = new Libro();
        libro.setTitulo(resultSet.getString("titulo"));
        libro.setTitulo(resultSet.getString("autor"));
        libro.setEditorial(resultSet.getString("editorial"));
        libro.setISBN(resultSet.getLong("ISBN"));
        libro.setPageNumber(resultSet.getInt("pageNumber"));
        libro.setYear(resultSet.getInt("year"));
        return libro;
    }

    @Override
    public Libro find(long id) throws DAOException {
        Libro result = null;
        String sql = "Select * from libros where idLibros = ?";
        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement statement = prepareStatement(connection, sql, false, String.valueOf(id));
                ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next()) {
                result = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException( e.getMessage() + e.getCause());
        }
        return result;
    }

    @Override
    public List<Libro> search(String... values) throws DAOException {
        return null;
    }

    @Override
    public List<Libro> list() throws DAOException {
        return null;
    }

    @Override
    public int update(Libro libro, String... values) throws IllegalArgumentException, DAOException {
        return 0;
    }

    @Override
    public int delete(Libro libro) throws IllegalArgumentException, DAOException {
        return 0;
    }

    @Override
    public long save(Libro libro) throws IllegalArgumentException, DAOException {
        return 0;
    }
}
