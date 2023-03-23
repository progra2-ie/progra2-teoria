package cr.ac.ucr.paraiso.ie.progra2.tema1.cursos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarreraTest {

    @Test
    public void crear_instancia_carrera_funciona(){
        //  Arrange
        // Act
        // Assert
        Carrera carrera = new Carrera();
        carrera.setCodCarrera(60002);
        carrera.setNombreCarrera("Informática Empresarial");
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("IF4101", "Lenguajes"));
        Curso curso2 = new Curso("IF6100", "Análisis y Diseño");
        //curso2.setCarrera(carrera);
        cursos.add(curso2);
        carrera.setCursos(cursos);

        System.out.println(carrera.getCodCarrera() + carrera.getNombreCarrera());
        List<Curso> cursosRetornados = carrera.getCursos();
        //recorrer la colección
        for (Curso curso:cursosRetornados ) {
            System.out.println(curso.getSigla() + curso.getNombre());
        }
    }
}
