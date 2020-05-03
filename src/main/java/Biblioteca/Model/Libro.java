package Biblioteca.Model;

public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private int year;
    private String editorial;
    private int pageNumber;
    private int idLibro;

    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.editorial = "";
        this.year = 0000;
        this.ISBN = "";
        this.pageNumber = 0;
        this.idLibro = 0;
    }

    public Libro(String titulo, String autor, String ISBN, int year, String editorial, int pageNumber, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.year = year;
        this.editorial = editorial;
        this.pageNumber = pageNumber;
        this.idLibro = id;
    }

    //Getter Setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
}
