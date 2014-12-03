import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HSGraph extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Login Form");

		GridPane grid = makeGrid();
		
		Label title = new Label("Welcome!");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(title, 0, 0, 2, 1);

		Text userName = new Text("Username: ");
		grid.add(userName, 0, 1);

		Text pwd = new Text("Password: ");
		grid.add(pwd, 0, 2);

		TextField userNameTF = new TextField();
		userNameTF.setOpacity(0.1);
		grid.add(userNameTF, 1, 1);

		PasswordField pwdField = new PasswordField();
		grid.add(pwdField, 1, 2);

		Button login = new Button("Login");
		HBox hbox = new HBox();
		hbox.getChildren().add(login);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(hbox, 1, 3);
		
		Label message = new Label();
		message.setTextFill(Color.RED);
		grid.add(message, 1, 4);
		
		login.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				message.setText("Login button pressed");
			}
		});

		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static GridPane makeGrid(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);
		
		return grid;

	}

}
