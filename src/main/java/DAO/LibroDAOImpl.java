package DAO;

import Biblioteca.Model.Articulo;
import Biblioteca.Model.Libro;

import java.sql.*;
import java.util.List;

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
        libro.setISBN(resultSet.getString("ISBN"));
        libro.setPageNumber(resultSet.getInt("pageNumber"));
        libro.setYear(resultSet.getInt("year"));
        return libro;
    }

    @Override
    public Libro find(long id) throws DAOException {
        Libro result = null;
        String sql = "Select * from libro where idLibro = ?";
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

        //como decirle la columna y el valor?
       String sql =  ("UPDATE libro SET columna= algo where idLibro =" + libro.setIdLibro(libro.getIdLibro()));

        int generatedKey;
        try (
                Connection connection = daoFactory.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            int i = 1;
            for (Object value : values){
                statement.setObject(i++, value);
            }
            statement.registerOutParameter(i, Types.NUMERIC);
            statement.execute();
            generatedKey = statement.getInt(i);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return generatedKey;
    }

    @Override
    public int delete(Libro libro) throws IllegalArgumentException, DAOException {
        String sql = ( "delete libro from libro where idLibro ="+ libro.getIdLibro());

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

       return 0;
    }

    @Override
    public Libro save(Libro libro) throws IllegalArgumentException, DAOException {
        libro.setISBN(libro.getISBN());
        libro.setTitulo(libro.getTitulo());
        libro.setAutor(libro.getAutor());
        libro.setEditorial(libro.getEditorial());
        libro.setPageNumber(libro.getPageNumber());
        libro.setYear(libro.getYear());

        return libro;
    }
}
