package cr.ac.ucr.paraiso.ie.progra2.tema4.archivos.data;

import cr.ac.ucr.paraiso.ie.progra2.tema4.archivos.domain.Empleado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class EmpleadoDao extends RandomAccessFile {
    private final int TAMANO_REGISTRO = 64;
    private final int TAMANO_ID_EMPLEADO = 4;
    private final int TAMANO_NOMBRE = 30;
    private final int TAMANO_APELLIDOS = 30;

    /* Empleado = {{idEmpleado, int, 4},
     * 			   {nombre, String, 30},
     * 			   {apellidos, String, 30}
     */

    public EmpleadoDao(File file) throws FileNotFoundException {
        super(file, "rw");
    }


    public boolean buscar(int idEmpleadoBuscado)
            throws IOException{
        boolean encontrado = false;
        super.length();
        int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
        int numReg=0;
        while(numReg<totalRegistros && !encontrado){
            this.seek(numReg * TAMANO_REGISTRO);
            int idEmpleadoActual = this.readInt();
            if(idEmpleadoBuscado == idEmpleadoActual)
                encontrado = !encontrado;
            else numReg++;

        }
        return encontrado;
    }//buscar
    /*
     * Inserta un empleado en el archivo. El nuevo empleado no puede
     * tener una identificacion igual a uno que ya exista. Los registros
     * estan ordenados alfabeticamente por nombre
     */
    public void insertarEmpleado(Empleado empInsertar)
            throws IOException, EmpleadoExistenteException  {
        boolean encontrado = this.buscar(empInsertar.getIdEmpleado());
        if (encontrado)
            throw new EmpleadoExistenteException();
        else{
            boolean insertado = false;
            int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
            int numReg=0;
            while(numReg<totalRegistros && !insertado){
                this.seek(numReg * TAMANO_REGISTRO);
                this.skipBytes(TAMANO_ID_EMPLEADO);
                String nombreActual =
                        readString(TAMANO_NOMBRE, this.getFilePointer());
                if(empInsertar.getNombre().compareTo(nombreActual)<=0){
                    this.setLength(this.length()+ TAMANO_REGISTRO);
                    // mover los registros hacia el final
                    for (int i= totalRegistros-1; i>=numReg; i--){
                        this.seek(i*TAMANO_REGISTRO);
                        byte[] registroX = new byte[TAMANO_REGISTRO];
                        this.readFully(registroX);
                        // USUARIOS CONCURRENTES.. HAY QUE TENER MAS CUIDADO
                        this.write(registroX);
                    }// for
                    // Guardar el nuevo registro
                    this.seek(numReg * TAMANO_REGISTRO);
                    this.writeInt(empInsertar.getIdEmpleado());
                    this.write(
                            toBytes(empInsertar.getNombre(),
                                    TAMANO_NOMBRE));
                    this.write(
                            toBytes(empInsertar.getApellidos(),
                                    TAMANO_APELLIDOS));
                    insertado = true;
                }else ++numReg;
            }//while
            if(!insertado){
                this.setLength(this.length()+ TAMANO_REGISTRO);
                this.seek(this.length()-TAMANO_REGISTRO);
                this.writeInt(empInsertar.getIdEmpleado());
                this.write(
                        toBytes(empInsertar.getNombre(),
                                TAMANO_NOMBRE));
                this.write(
                        toBytes(empInsertar.getApellidos(),
                                TAMANO_APELLIDOS));
            }
        }//else

    }//insertarEmpleado

    /*
     * Lee un String en el archivo
     * @param tamanoString
     * @param posicion
     */
    private String readString(int tamanoString, long posicion) throws IOException{
        this.seek(posicion);
        byte[] datos = new byte[tamanoString];
        this.readFully(datos);
        String dato = new String(datos).trim();
        return dato;

    }//readString
    private byte[] toBytes(String dato, int tamanoString){
        byte[] datos = new byte[tamanoString];
        if (dato.length() > tamanoString){
            byte[] temp = dato.getBytes();
            int i = 0;
            for (byte b : temp) {
                datos[i++] = b;
            }
        }else{
            byte temp[] = dato.getBytes();
            int i = 0;
            for (byte c : temp) {
                datos[i++] = c;
            }

        }

        return datos;
    }

    public ArrayList<Empleado> getEmpleados() throws IOException {
        int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
        ArrayList<Empleado> list = new ArrayList<Empleado>();
        for(int i=0; i<totalRegistros; i++){
            this.seek(i*TAMANO_REGISTRO);
            int idEmp = this.readInt();
            String nombre = this.readString(TAMANO_NOMBRE,
                    this.getFilePointer());
            String apellidos = this.readString(TAMANO_APELLIDOS,
                    this.getFilePointer());
            list.add(new Empleado(idEmp,nombre, apellidos));


        }//for

        return list;
    }
}