package main;

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
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import formula.FormulaExtractor;

public class HSGraph extends Application {
	
	private static final int CANVAS_HEIGHT = 300;
	private static final int CANVAS_WIDTH = 300;

	public static void main(String[] args) {
		 
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("HS-Graph");
		primaryStage.getIcons().add(new Image("file:images/icon.png"));

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
		
		//Input fields
		TextField input = new TextField("m value");
		input.setPrefColumnCount(20);
		
		//The buttons
		Button drawButton = new Button("Draw");
		Button clearButton = new Button("Clear");
		
		//Add all components except canvas
		grid.add(yLabel, 0, 0);
		grid.add(input, 1, 0, 2, 1);
		grid.add(drawButton, 3, 0);
		grid.add(clearButton, 4, 0);
		grid.add(list, 0, 1, 2, 1);
		
		//Setup Canvas
		GraphField.initialize(CANVAS_WIDTH, CANVAS_HEIGHT);
		grid.add(GraphField.getCanvas(), 2, 1, 3, 1);
		
		//Draw button action event
		drawButton.setOnAction((ActionEvent e) -> {
			FormulaExtractor.setFormula(input.getText());
			GraphField.paintCanvas();//sets the formula and also draws the graph
		});
		
		//Clear button action event
		clearButton.setOnAction((ActionEvent e) ->{
			GraphField.clearCanvas();
			items.clear();
		});
		
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(HSGraph.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
