package dataBaseDAO;

import Biblioteca.Model.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dataBaseDAO.DAOUtil.prepareStatement;

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
       String sql =  ("UPDATE libro SET columna= algo where idLibro = ? ");

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
        String sql = ( "delete libro from libro where idLibro = ?");
        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement statement = prepareStatement(connection, sql, false, String.valueOf(libro.getIdLibro()));
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Error al borrar un Libro, ninguna fila eliminada.");
            }
        } catch (SQLException e) {
            throw new DAOException( e.getMessage() + e.getCause());
        }

       return 0;
    }


    private List<String> setValues(Libro libro){
        List<String> values = new ArrayList<>();
        values.add(libro.getISBN());
        values.add(libro.getTitulo());
        values.add(libro.getAutor());
        values.add(libro.getEditorial());
        values.add(String.valueOf(libro.getPageNumber()));
        values.add(String.valueOf(libro.getYear()));
        return values;
    }

    @Override
    public void save(Libro libro) throws IllegalArgumentException {
        String sql = "INSERT INTO `libro` (`ISBN`,`Titulo`,`Autor`, `Editorial`, `Numero de paginas`, `Anio`, `idLibro`) VALUES (?, ?, ?, ?, ?, ?, 0)";
        List<String> values = setValues(libro);

        try (
                Connection connection = daoFactory.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            int i = 0;
            for (Object value : values){
                statement.setObject(++i, value);
            }
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
