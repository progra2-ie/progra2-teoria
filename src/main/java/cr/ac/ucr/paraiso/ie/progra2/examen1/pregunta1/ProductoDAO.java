package cr.ac.ucr.paraiso.ie.progra2.examen1.pregunta1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ProductoDAO extends RandomAccessFile implements IProducto{
    private final static int ID_PRODUCTO=4;
    private static int DESCRIPCION=60;
    private static int PRECIO=4;
    private static int TAMANO_REGISTRO=68;

    public ProductoDAO(File file, String mode) throws FileNotFoundException {
        super(file, mode);
    }

    @Override
    public Producto buscar(int idProducto) throws IOException {
        boolean encontrado = false;
        int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
        int numReg=0;
        Producto producto = null;
        while(numReg<totalRegistros && !encontrado){
            this.seek(numReg * TAMANO_REGISTRO);
            int idProductoActual = this.readInt();
            if(idProducto == idProductoActual){
                encontrado = !encontrado;
                String descripcion = readString(DESCRIPCION,this.getFilePointer());
                float precio = this.readFloat();
                producto = new Producto();
                producto.setIdProducto(idProductoActual);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
            }
            else numReg++;

        }
        return producto;
    }
    private String readString(int tamanoString, long posicion) throws IOException {
        this.seek(posicion);
        byte[] datos = new byte[tamanoString];
        this.readFully(datos);
        String dato = new String(datos).trim();
        return dato;

    }//readString
}
