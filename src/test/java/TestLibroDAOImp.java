import Biblioteca.Model.Libro;
import DAO.DAO;
import DAO.DAOFactory;
import org.junit.Test;

public class TestLibroDAOImp {
    @Test
    public void testLibroDAO(){
        DAO<Libro> libro = DAOFactory.getInstance().getLibroDAO();
        libro.find(1);
    }
}
