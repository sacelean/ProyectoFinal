import Biblioteca.Model.Libro;
import dataBaseDAO.DAO;
import dataBaseDAO.DAOFactory;
import org.junit.Test;

public class TestLibroDAOImp {

    DAO<Libro> db = DAOFactory.getInstance().getLibroDAO();

    @Test
    public void testLibroDAO(){
        Libro l = db.find(1);
        System.out.printf(l.getTitulo());
    }

    @Test
    public void testSaveLibro() {
        Libro l = new Libro("titulo2", "autor12", "123124re2", 2019, "editorial21", 1220, 0);
        db.save(l);
    }
}
