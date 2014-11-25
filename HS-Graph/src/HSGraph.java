import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Hi!");
		Button btn2 = new Button("Apa!");
		Group root = new Group();
		Scene scene = new Scene(root, 400, 400);
		
		
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		
		btn.setLayoutY(scene.getHeight() / 2);
		btn.setLayoutX(scene.getWidth() / 2);
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("How the fuck does this work?");
		primaryStage.show();
	}

}
