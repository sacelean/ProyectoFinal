package dataBaseDAO;

import Biblioteca.Model.Articulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dataBaseDAO.DAOUtil.prepareStatement;

public class ArticuloDAOImpl implements DAO<Articulo>{


    private DAOFactory daoFactory;

    public ArticuloDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


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

    private List<String> setValues(Articulo articulo){
        List<String> values = new ArrayList<>();
        values.add(articulo.getISSN());
        values.add(articulo.getTitulo());
        values.add(articulo.getAutor());
        values.add(articulo.getNombreRevista());
        values.add(String.valueOf(articulo.getPaginaInicio()));
        values.add(String.valueOf(articulo.getPaginaFin()));
        values.add(String.valueOf(articulo.getMes()));
        values.add(String.valueOf(articulo.getYear()));
        return values;
    }

    @Override
    public void save(Articulo articulo) throws IllegalArgumentException {
        String sql = "INSERT INTO `mydb`.`articulo` ('idArticulo',`ISSN`,`Titulo`,`Autor`,`Nombre revista`, `Pagina inicio`,`Pagina fin`, `Mes`,`Anio`) VALUES (0,?, ?, ?, ?, ?, ?, ?, ?)";
        sql = "BEGIN " + sql + "; END;";
        List<String> values = setValues(articulo);

        try (
                Connection connection = daoFactory.getConnection();
                CallableStatement statement = connection.prepareCall(sql)
        ) {
            int i = 0;
            for (Object value : values){
                statement.setObject(i++, value);
            }
            statement.registerOutParameter(i, Types.NUMERIC);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
