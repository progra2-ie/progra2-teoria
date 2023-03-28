package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.cursos;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int codCarrera;
    private String nombreCarrera;
    private List<Curso> cursos;

    public Carrera() {
        this.nombreCarrera = "";
        this.cursos = new ArrayList<Curso>();
    }

    public int getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(int codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
