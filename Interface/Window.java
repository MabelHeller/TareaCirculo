package Interface;

import domain.Oval;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application implements Runnable {

    //atributos
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Thread thread;
    private Oval oval;
    private Random generador = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Random Graphics");
        initComponents(primaryStage);
        primaryStage.show();
    }

    //metodo que inicializa todos los componentes y ademas llena de los datos necesarios al objeto Oval
    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.thread = new Thread(this);
        this.thread.start();
        this.pane.getChildren().add(this.canvas);
        primaryStage.setScene(this.scene);
        int x = generador.nextInt(500) + 20;
        int y = generador.nextInt(500) + 20;
        int addressX = generador.nextInt(2);
        int addressY = generador.nextInt(2);
        if (addressX == 0 || addressY == 0) {
            addressX = 1;
            addressY = 1;
        } else {
            addressX = -1;
            addressY = -1;
        }
        oval = new Oval(x, y, 20, addressX, addressY);
    }

    //dibuja el circulo
    private void myDraw(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.AQUA);
        gc.fillOval(oval.getX(), oval.getY(), 100, 100);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //aqui se hace el rebote dependiendo si el circulo toca las 
                //medidas del panel entonces llama los metodos que cambian la direccion x o y
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                if ((oval.getX() == 0) || (oval.getX() + 20) == 700) {
                    oval.changeAddressX();
                }
                if ((oval.getY() == 0) || (oval.getY() + 20) == 515) {
                    oval.changeAddressY();
                }
                oval.moveX();//suma un numero mas a la coordenada X para que se mueva de forma que se vea continua
                oval.moveY();//suma un numero mas a la coordenada Y para que se mueva de forma que se vea continua
                myDraw(gc);
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
