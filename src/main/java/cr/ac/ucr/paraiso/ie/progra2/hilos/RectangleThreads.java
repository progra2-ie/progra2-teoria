package cr.ac.ucr.paraiso.ie.progra2.hilos;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.collections.ListChangeListener;


public class RectangleThreads extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println(Thread.currentThread().toString());
        Pane pane = new Pane(); //container for shapes
        RectangleMaker rectangleMaker = new RectangleMaker (); //make new shapes on other thread
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
        primaryStage.setTitle("Aplicación de hilos básica");
        primaryStage.show();
        primaryStage.sizeToScene();
        rectangleMaker.begin(); //start making new rectangles
    }

    public static void main(String[] args) {
        launch(args);
        //https://medium.com/codex/solved-error-javafx-runtime-components-are-missing-and-are-required-to-run-this-application-ec4779eb796d

    }
}
