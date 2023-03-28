package cr.ac.ucr.paraiso.ie.progra2.tema4.archivos.data;

public class EmpleadoExistenteException extends Exception {

    public EmpleadoExistenteException() {
        super("Un empleado con esta identificación ya existe");
    }

    public EmpleadoExistenteException(String mensaje) {
        super(mensaje);

    }

}
