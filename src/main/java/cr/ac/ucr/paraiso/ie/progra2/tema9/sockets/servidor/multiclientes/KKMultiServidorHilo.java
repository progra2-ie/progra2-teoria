package cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.multiclientes;

import cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.common.KnockKnockProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class KKMultiServidorHilo extends Thread {
    private Socket socket;

    public KKMultiServidorHilo(Socket socket) {
        super("KKMultiServidorHilo");
        this.socket = socket;
    }

    public void run() {

        PrintWriter writer;
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            KnockKnockProtocol protocolo = new KnockKnockProtocol();
            String salida = protocolo.procesarEntrada(null);
            writer.println(salida);
            String entrada = null;
            while ((entrada = reader.readLine()) != null) {
                salida = protocolo.procesarEntrada(entrada);
                writer.println(salida);
                if (salida.equals("Chao!"))
                    break;
            }// while
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }// run

}
