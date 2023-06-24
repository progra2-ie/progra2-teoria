package cr.ac.ucr.paraiso.ie.progra2.examen1.pregunta3;

public class Pelicula {
    private int codPelicula;
    private String titulo;

    public Pelicula(int codPelicula, String titulo) {
        this.codPelicula = codPelicula;
        this.titulo = titulo;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
