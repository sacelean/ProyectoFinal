package Biblioteca.Model;

public class Articulo {

    private String ISSN;
    private String titulo;
    private String autor;
    private String nombreRevista;
    private int mes;
    private int year;
    private int paginaInicio;
    private int paginaFin;


    public Articulo (){
        this.ISSN = "";
        this.titulo = "";
        this.autor = "";
        this.nombreRevista = "";
        this.mes = 0;
        this.year = 0;
        this.paginaInicio = 0;
        this.paginaFin = 0;
    }

    public Articulo(String titulo, String autor, String nombreRevista){
        this.titulo = titulo;
        this.autor = autor;
        this.nombreRevista = nombreRevista;
    }

    public Articulo (String ISSN, String titulo, String autor, String nombreRevista, int mes, int year , int paginaIni, int paginaF) {
        this.ISSN = ISSN;
        this.titulo = titulo;
        this.autor = autor;
        this.nombreRevista = nombreRevista;
        this.mes = mes;
        this.year = year;
        this.paginaInicio = paginaIni;
        this.paginaFin = paginaF;

    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

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

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public int getPaginaFin() {
        return paginaFin;
    }

    public void setPaginaFin(int paginaFin) {
        this.paginaFin = paginaFin;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "ISSN='" + ISSN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", nombreRevista='" + nombreRevista + '\'' +
                ", mes=" + mes +
                ", year=" + year +
                ", paginaInicio=" + paginaInicio +
                ", paginaFin=" + paginaFin +
                '}';
    }
}
