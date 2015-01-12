import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class canvas extends Application {

	public static void main(String args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		final int WIDTH = 500;
		final int HEIGHT = 500;
		primaryStage.setTitle("Canvas graphics test");
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		Group root = new Group();
		
		//Draw Axes
		canvas.getGraphicsContext2D().setLineWidth(0.5);
		canvas.getGraphicsContext2D().strokeLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
		canvas.getGraphicsContext2D().strokeLine(0, HEIGHT/2, WIDTH, HEIGHT/2);
		
		//Draw graph y = x^(2)
		for (int x = 0; x <= WIDTH/2; x++) { //for x >0
			int m = -100;
			drawLine(canvas, x, Math.pow(x*2, 2) -30*x, x + 1, Math.pow((x + 1)*2, 2) -30*(x+1));
		}
		
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void drawLine(Canvas c, int x, double y, int x2, double y2) {
		c.getGraphicsContext2D().setLineWidth(2);
		c.getGraphicsContext2D().setStroke(Color.YELLOWGREEN);
		c.getGraphicsContext2D().strokeLine(x + c.getWidth()/2, c.getHeight()/2 - y, x2 + c.getWidth()/2, c.getHeight()/2 - y2);
	}

}
