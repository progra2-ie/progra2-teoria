package cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.common.KnockKnockProtocol;

public class KnockKnockServidor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null; // Este socket espera por
        // una conexión entrante

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Servidor activo");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Socket clientSocket;
        // escuchar por una solicitud de conexión
        try {
            clientSocket = serverSocket.accept();
            PrintWriter writer =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            KnockKnockProtocol protocolo =
                    new KnockKnockProtocol();
            String salida = protocolo.procesarEntrada(null);
            writer.println(salida);
            String entrada = null;
            while((entrada= reader.readLine()) != null){
                salida = protocolo.procesarEntrada(entrada);
                writer.println(salida);
                if(salida.equals("Chao!"))
                    break;
            }//while
            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }



    }

}
