package DAO;

import Biblioteca.Model.Articulo;
import Biblioteca.Model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static DAO.DAOUtil.prepareStatement;

public class ArticuloDAOImpl implements DAO<Articulo>{


    private DAOFactory daoFactory;


    private static Articulo map(ResultSet resultSet) throws SQLException {
        Articulo articulo1 = new Articulo();
        articulo1.setISSN(resultSet.getString("ISSN"));
        articulo1.setTitulo(resultSet.getString("titulo"));
        articulo1.setAutor(resultSet.getString("autor"));
        articulo1.setNombreRevista(resultSet.getString("Nombre revista"));
        articulo1.setPaginaInicio(resultSet.getInt("Pagina inicio"));
        articulo1.setPaginaFin(resultSet.getInt("Pagina fin"));
        articulo1.setMes(resultSet.getInt("Mes"));
        articulo1.setYear(resultSet.getInt("Anio"));
        return articulo1;
    }

    @Override
    public Articulo find(long id) throws DAOException {

        Articulo result = null;
        String sql = "Select * from articulo where idArticulo = ?";
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
    public List<Articulo> search(String... values) throws DAOException {
        return null;
    }

    @Override
    public List<Articulo> list() throws DAOException {
        return null;
    }

    @Override
    public int update(Articulo articulo, String... values) throws IllegalArgumentException, DAOException {
        return 0;
    }

    @Override
    public int delete(Articulo articulo) throws IllegalArgumentException, DAOException {
        return 0;
    }

    @Override
    public Articulo save(Articulo articulo) throws IllegalArgumentException, DAOException {
        articulo.setISSN(articulo.getISSN());
        articulo.setTitulo(articulo.getTitulo());
        articulo.setAutor(articulo.getAutor());
        articulo.setNombreRevista(articulo.getNombreRevista());
        articulo.setPaginaInicio(articulo.getPaginaInicio());
        articulo.setPaginaFin(articulo.getPaginaFin());
        articulo.setMes(articulo.getMes());
        articulo.setYear(articulo.getYear());
        return articulo;
    }

   /* @Override
    public long save(Articulo articulo) throws IllegalArgumentException, DAOException {
        Long generatedKey;
        String sql = "BEGIN " + "INSERT INTO `mydb`.`articulo` (`ISSN`,`Titulo`,`Autor`,`Nombre revista`, `Pagina inicio`,`Pagina fin`, `Mes`,`Anio`,`idArticulo`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" + "; END;";
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
            generatedKey = statement.getLong(i);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return generatedKey;
    }*/
}
