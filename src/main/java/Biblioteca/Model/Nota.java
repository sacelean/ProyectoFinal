package Biblioteca.Model;

public class Nota {

    private int idNota;
    private Tema tema;

    public Nota(int idNota, Tema tema) {
        this.idNota = idNota;
        this.tema = tema;
    }

    public int getIdNota() {
        return idNota;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    //Una o varias notas pueden ser de un tema.
    //Un libro o articulo pueden tener una o varias notas
}
