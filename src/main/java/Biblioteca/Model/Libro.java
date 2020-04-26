package Biblioteca.Model;

public class Libro {

    private String titulo;
    private String autor;
    private long ISBN;
    private int year;
    private String editorial;
    private int pageNumber;

    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.editorial = "";
        this.year = 0000;
        this.ISBN = 0;
        this.pageNumber = 0;
    }

    public Libro(String titulo, String autor, long ISBN, int year, String editorial, int pageNumber) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.year = year;
        this.editorial = editorial;
        this.pageNumber = pageNumber;
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

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
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
}