import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Hi!");
		Label lbl = new Label();
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				lbl.setText("You Smell Funny!");
			}
		});
		
		Group root = new Group();
		Scene scene = new Scene(root, 400, 400);
		
		root.getChildren().add(btn);
		root.getChildren().add(lbl);
		
		btn.setLayoutY(scene.getHeight() / 2);
		btn.setLayoutX(scene.getWidth() / 2);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("GUI leklåda!");
		primaryStage.show();
	}

}
