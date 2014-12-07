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
		primaryStage.setTitle("Canvas graphics test");
		Canvas canvas = new Canvas(300, 250);
		Group root = new Group();

		root.getChildren().add(canvas);

		for (int i = 0; i <= 200; i++) {
			drawShapes(canvas.getGraphicsContext2D(), i, i * 2);
		}

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void drawShapes(GraphicsContext gc, int x, double d) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, d, 1, 1);
	}

}
