package cr.ac.ucr.paraiso.ie.progra2.examen1.pregunta1;

import java.io.IOException;

public interface IProducto {
    public abstract Producto buscar(int idProducto) throws IOException;
}
