package DAO;

import Biblioteca.Model.Articulo;
import Biblioteca.Model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOImpl implements DAO<Articulo> {


    private DAOFactory daoFactory;

    @Override
    public Articulo find(long id) throws DAOException {
        return null;
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
    public long save(Articulo articulo) throws IllegalArgumentException, DAOException {
        Long generatedKey;
        String sql = "INSERT INTO `mydb`.`articulo` (`ISSN`,`Titulo`,`Autor`,`Nombre revista`,`Pagina inicio`,`Pagina fin`,`Mes`,`Anio`,`Representacion_idRepresentacion`) VALUES (?,?,?,?,?,?,?,?,?)";
        sql = "BEGIN " + sql + "; END;";
        try (
                Connection connection = daoFactory.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            int i = 1;
            statement.setObject(i++, articulo.getISSN());
            statement.setObject(i++, articulo.getTitulo());
            statement.setObject(i++, articulo.getAutor());
            statement.setObject(i++, articulo.getNombreRevista());
            statement.setObject(i++, articulo.getPaginaInicio());
            statement.setObject(i++, articulo.getPaginaFin());
            statement.setObject(i++, articulo.getMes());
            statement.setObject(i++, articulo.getYear());
            statement.registerOutParameter(i, Types.NUMERIC);
            statement.execute();
            generatedKey = statement.getLong(i);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return generatedKey;
    }

    private static Articulo map(ResultSet resultSet) throws SQLException {
        Articulo articulo = new Articulo();
        articulo.setISSN(resultSet.getString("ISSN"));
        articulo.setTitulo(resultSet.getString("TITULO"));
        articulo.setAutor(resultSet.getString("autor"));
        //TODO: add next fields of the articulo class
        return articulo;
    }
}
