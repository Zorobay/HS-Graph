import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("inkalen");

		//Grid Pane Setup
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);

		//List view test!!
		ListView<String> list = new ListView<>();
		list.setPrefWidth(70);
		ObservableList<String> items = FXCollections.observableArrayList();
		list.setItems(items);
		
		//Labels
		Label yLabel = new Label("y = ");
		Label xLabel = new Label("x");
		Label plusLabel = new Label (" + ");
		
		//Input fields
		TextField mValue = new TextField("m value");
		mValue.setPrefColumnCount(4);
		TextField cValue = new TextField("c value");
		cValue.setPrefColumnCount(4);
		
		//The buttons
		Button drawButton = new Button("Draw");
		Button clearButton = new Button("Clear");
		
		//Add all components except canvas
		grid.add(yLabel, 0, 0);
		grid.add(mValue, 1, 0);
		grid.add(xLabel, 2, 0);
		grid.add(plusLabel, 3, 0);
		grid.add(cValue, 4, 0);
		grid.add(drawButton, 5, 0);
		grid.add(clearButton, 6, 0);
		grid.add(list, 0, 1, 2, 1);
		
		//Setup Canvas
		GraphField graphField = new GraphField(300, 300);
		grid.add(graphField.getCanvas(), 2, 1, 5, 1);
		
		//Draw button action event
		drawButton.setOnAction((ActionEvent e) -> {
			graphField.setm(Integer.parseInt(mValue.getText()));
			graphField.setc(Integer.parseInt(cValue.getText()));
			graphField.paintCanvas();
		
			items.add("y = " + mValue.getText() + "x +" + cValue.getText());
		});
		
		//Clear button action event
		clearButton.setOnAction((ActionEvent e) ->{
			graphField.clearCanvas();
			items.clear();
		});

		Scene scene = new Scene(grid);
		scene.getStylesheets().add(HSGraph.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
