package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.paco;

public class Persona {
    private String nombre;
    private String apellidos;
    private float horasObservadas;
    private Vehiculo vehiculo;

    public Persona() {
        this.vehiculo = new Vehiculo();
        this.nombre = this.apellidos = "";
    }

    public Persona(String nombre, String apellidos, float horasObservadas, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.horasObservadas = horasObservadas;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getHorasObservadas() {
        return horasObservadas;
    }

    public void setHorasObservadas(float horasObservadas) {
        this.horasObservadas = horasObservadas;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
