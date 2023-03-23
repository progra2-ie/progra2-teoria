package cr.ac.ucr.paraiso.ie.progra2.tema1.cursos;

public class Curso {
    private String sigla;
    private String nombre;
    private Carrera carrera;

    public Curso() {
        this.sigla = nombre = "";
        this.carrera = new Carrera();
    }

    public Curso(String sigla, String nombre) {
        this.sigla = sigla;
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
