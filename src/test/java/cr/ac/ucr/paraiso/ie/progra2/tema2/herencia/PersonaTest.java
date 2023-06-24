package cr.ac.ucr.paraiso.ie.progra2.tema2.herencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {
    private Persona p;
    private Estudiante e;

    @BeforeEach
    public void init(){
        p = new Estudiante(100,"Juana", "Pereira",
                600, "Religion");
        e = new Estudiante(120,"Felipe", "Porras",
                600, "Relaciones Exteriores");
    }

    @Test
    public void toString_funciona(){
        System.out.println(p.toString());
    }
    @Test
    public void equals_con_instancia_persona_funciona(){
        //persona 2
        Persona persona2 = new Estudiante(120, "Felipe",
                "Porras", 600, "Relaciones Exteriores");
        boolean resultadoObtenido = e.equals(persona2);
        boolean resultadoEsperado = true;
        //assert (resultadoObtenidoresultadoEsperado);
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void equals_con_instancia_invalida_funciona(){
     Integer integer = 4;
     boolean resultadoEsperado = false;
     boolean resultadoObtenido = e.equals(integer);
     Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }


}
