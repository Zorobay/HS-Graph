import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Labels");
		
		Button b = new Button("hello!");
		b.getStyleClass().add("bballs");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);

		// add all components
		grid.add(b, 0, 0);
		
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(HSGraph.class.getResource("style.css").toExternalForm());
		primaryStage.show();
	}
}
