package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.paco;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    @Test
    public void crear_instancias_funciona(){
        Persona persona = new Persona();
        persona.setNombre("Paco");
        persona.setNombre("Apellido1 Appellido2");
        persona.setHorasObservadas(10);
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setColor("Rojo");
        vehiculo.setFuncional(true);
        vehiculo.setMarca("Tesla");
        persona.setVehiculo(vehiculo);

    }
}
