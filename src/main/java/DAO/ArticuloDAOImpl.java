package DAO;

import Biblioteca.Model.Articulo;

import java.util.List;

public class ArticuloDAOImpl implements DAO<Articulo>{


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
    public Articulo save(Articulo articulo) throws IllegalArgumentException, DAOException {
        articulo.setTitulo(articulo.getTitulo());
        articulo.setTitulo(articulo.getAutor());
        articulo.setNombreRevista(articulo.getNombreRevista());
        articulo.setYear(articulo.getYear());
        articulo.setMes(articulo.getMes());
        articulo.setPaginaInicio(articulo.getPaginaInicio());
        articulo.setPaginaFin(articulo.getPaginaFin());
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
