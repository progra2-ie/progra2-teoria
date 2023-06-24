package cr.ac.ucr.paraiso.ie.progra2.hilos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.concurrent.TimeUnit;

public class RectangleMaker implements Runnable {

    //store the shapes created in an observable list
    private final ObservableList<Shape> shapes;
    private boolean cancel;
    private final Thread t;

    public RectangleMaker() {
        shapes = FXCollections.observableArrayList();
        t= new Thread(this);
    }

    @Override
    public void run(){
        cancel = false;
        while (! cancel){

            Rectangle rect = new Rectangle((int) (Math.random() * 600), (int) (Math.random() * 600),100,100);
            rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            shapes.add(rect);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) { ex.printStackTrace();   }
        }
    }

    ObservableList<Shape>  getShapes(){
        return shapes;
    }

    void begin(){
        stop(); //stop previous run if any
        t.start();
    }

    void stop(){
        cancel = true;
        try {
            t.join(); //wait for completion
        } catch (InterruptedException ex) { ex.printStackTrace();   }
    }
}