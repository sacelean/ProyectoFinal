import Biblioteca.Model.Libro;
import dataBaseDAO.DAO;
import dataBaseDAO.DAOFactory;
import dataBaseDAO.LibroDAOImpl;
import org.junit.Test;

import java.time.Clock;

public class TestLibroDAOImp {

    DAO<Libro> db = DAOFactory.getInstance().getLibroDAO();

    @Test
    public void testLibroDAO(){
        Libro l = db.find(1);
        System.out.printf(l.getTitulo());
    }

    @Test
    public void testSaveLibro() {
        Libro l = new Libro(0,"12345TB", "Titulo1", "Natalia", "Everest", 230, 2020);
        db.save(l);
    }
    @Test
    public void testDeleteLibro(){
        Libro l = new Libro(0, "12345WD","Titulo123","Paquito","Edebe",234,2019);
        db.save(l);
        System.out.println(l.getEditorial());
        db.delete(l);
    }
}
