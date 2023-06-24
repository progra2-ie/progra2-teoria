package cr.ac.ucr.paraiso.ie.progra2.servertry;

import cr.ac.ucr.paraiso.ie.progra2.examen1.pregunta1.Producto;
import cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.multiclientes.KKMultiServidorHilo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.Map;


public class RectangleThreadsMain extends Application {
    // NUEVO
    private ServerSocket serverSocket = null; // Este socket espera por
    // label
    //private Map<String, Producto> map;
    @Override
    public void start(Stage primaryStage) {
        System.out.println(Thread.currentThread().toString());
        Pane pane = new Pane(); //container for shapes
        RectangleMaker rectangleMaker = new RectangleMaker(); //make new shapes on other thread
        rectangleMaker.getShapes().addListener((ListChangeListener<Shape>) change -> { //respond to shapes added
            while (change.next()) {
                //if items are removed
                for (Shape s : change.getRemoved()) {
                    Platform.runLater(()->  pane.getChildren().remove(s));
                }
                //if items are added
                for (Shape s : change.getAddedSubList()) {
                    Platform.runLater(()-> pane.getChildren().add(s));
                }
            }
        });



        Scene scene = new Scene(pane,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicación con múltiples hilos");
        primaryStage.show();
        primaryStage.sizeToScene();
        rectangleMaker.begin(); //start making new rectangles
        serverStart();
    }

    private void serverStart(){
        //NUEVO
        // una conexión entrante
        boolean escuchando = true;

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Servidor activo");
            while(escuchando){
                KKMultiServidorHilo hilo = new KKMultiServidorHilo(serverSocket.accept());
                hilo.start();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public static void main(String[] args) {
        launch(args);
        //https://medium.com/codex/solved-error-javafx-runtime-components-are-missing-and-are-required-to-run-this-application-ec4779eb796d

    }
}
