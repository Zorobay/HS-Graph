package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import function.FormulaExtractor;
import function.Function;

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
		grid.setGridLinesVisible(true);

		//Setup TableView
		TableView table = new TableView();
		table.setEditable(true);
		
		//Setup table columns
		TableColumn<Function, String> functionColumn = new TableColumn<>("Function");
		functionColumn.setSortable(false);
		functionColumn.setCellValueFactory(new PropertyValueFactory<>("Function"));
		functionColumn.setCellFactory(TextFieldTableCell.<Function>forTableColumn());
		
		TableColumn enabledColumn = new TableColumn("Enabled");
		functionColumn.setSortable(false);
		enabledColumn.setCellValueFactory(new PropertyValueFactory<>("enabled"));
		
		//Create empty list of table data
		ObservableList<Function> data = FXCollections.observableArrayList(
		);
		
		//Action event for editing a formula
		functionColumn.setOnEditCommit((CellEditEvent<Function, String> t) -> {
			((Function) t.getTableView().getItems().get(
					t.getTablePosition().getRow())).setFunction(t.getNewValue());
					GraphField.paintCanvas();//sets the formula and also draws the graph
		});
				
		//Populate table
		table.setItems(data);
		table.getColumns().addAll(functionColumn, enabledColumn);
		
		//Setup Color Picker
		ColorPicker functionColorPicker = new ColorPicker(Color.GREEN);
		functionColorPicker.setMaxWidth(40);
		ColorPicker graphFieldColorPicker = new ColorPicker(Color.BLACK);
		graphFieldColorPicker.setMaxWidth(40);
		
		
		//The buttons
		Button addButton = new Button("Add");
		Button clearButton = new Button("Clear");
		
		//Setup text field
		TextField inputField = new TextField();
		inputField.setPromptText("Function f(x)");
		inputField.setPrefWidth(200);
		
		//Setup axis scaling
		TextField xAxisMin = new TextField();
		TextField xAxisMax = new TextField();
		TextField yAxisMin = new TextField();
		TextField yAxisMax = new TextField();
		
		//Setup HBox for colorPicker, inputfield and add button
		HBox inputHBox = new HBox();
		inputHBox.getChildren().addAll(functionColorPicker, inputField, addButton);
		
		//Add all components except canvas
		grid.add(inputHBox, 0, 0);
		grid.add(table, 0, 1);
		grid.add(clearButton, 2, 2);
		grid.add(graphFieldColorPicker, 2, 1);
		
		//Setup Canvas
		GraphField.initialize(CANVAS_WIDTH, CANVAS_HEIGHT);
		grid.add(GraphField.getCanvas(), 1, 1);
		
		//Action event for the add button
		addButton.setOnAction((ActionEvent e) -> {
			Function f = new Function(functionColorPicker.getValue(), inputField.getText(), "true");
			data.add(f); //Add new Function object
			GraphField.setFunctionArray(dataToFunctionArray(data));
			GraphField.paintCanvas();
			
			//Clear the inputField
			inputField.clear();
		});
		
		//Clear button action event
		clearButton.setOnAction((ActionEvent e) ->{
			GraphField.clearCanvas();
			data.clear();
		});
		
		//Action Event for graphFieldColorPicker
		graphFieldColorPicker.setOnAction((ActionEvent) -> {
			GraphField.setAxisColor(graphFieldColorPicker.getValue());
		});
		
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(HSGraph.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private static Function[] dataToFunctionArray(ObservableList<Function> data){
		Function[] funcArray = new Function[data.toArray().length];
		Object[] dataArray = data.toArray();
		
		for(int i = 0; i < data.toArray().length; i++){
			funcArray[i] = (Function)dataArray[i];
		}
		
		return funcArray;
	}
}
