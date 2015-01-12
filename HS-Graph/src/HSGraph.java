import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	int r = 0;
	int g = 0;
	int b = 0;

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Labels");
		Image img = new Image("file:images/ok-icon.png", 30, 30, true, true);
		ToggleButton tb = new ToggleButton("Red");
		tb.getStyleClass().add("redb");
		ToggleButton tb2 = new ToggleButton("Green");
		tb2.getStyleClass().add("greenb");
		ToggleButton tb3 = new ToggleButton("Blue");
		tb3.getStyleClass().add("blueb");
		tb3.setTooltip(new Tooltip("The blue button"));

		Rectangle rect = new Rectangle();
		rect.setHeight(50);
		rect.setWidth(135);
		rect.setFill(Color.rgb(0, 0, 0));
		rect.setArcHeight(10);
		rect.setArcWidth(10);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);

		// action events
		tb.setOnAction((ActionEvent e) -> {
			if (r == 255)
				r = 0;
			else
				r = 255;
			rect.setFill(Color.rgb(r, g, b));
		});

		tb2.setOnAction((ActionEvent e) -> {
			if (g == 255)
				g = 0;
			else
				g = 255;
			rect.setFill(Color.rgb(r, g, b));
		});

		tb3.setOnAction((ActionEvent e) -> {
			if (b == 255)
				b = 0;
			else
				b = 255;
			rect.setFill(Color.rgb(r, g, b));
		});
		// add all components
		grid.add(tb, 0, 0);
		grid.add(tb2, 1, 0);
		grid.add(tb3, 2, 0);
		grid.add(rect, 0, 1, 3, 1);

		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(
				HSGraph.class.getResource("style.css").toExternalForm());
		primaryStage.show();
	}
}
