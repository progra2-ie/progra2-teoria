package cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.multiclientes;

import java.net.ServerSocket;
import java.io.IOException;

public class KKMultiServidor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null; // Este socket espera por
        // una conexión entrante
        boolean escuchando = true;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Servidor activo");
            while(escuchando){
                new KKMultiServidorHilo(serverSocket.accept()).start();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }



    }

}
