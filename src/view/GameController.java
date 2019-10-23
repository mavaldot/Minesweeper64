package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameController implements Initializable {

	private Scene menuScene;
	
	@FXML
	GridPane grid;
	
	public void setMenuScene(Scene scene) {
		menuScene = scene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Button b1 = new Button("a");
		Button b2 = new Button("b");
		Button b3 = new Button("c");
		Button b4 = new Button("d");
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("You lose! HAHAHAAHAH");
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("You lose!");
			}
		});
		
		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("You WIN!");
			}
		});
		
		b4.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("You ARE THE BEST!");
			}
		});
		
		
		grid.add(b1, 0, 0);
		grid.add(b2, 0, 1);
		grid.add(b3, 1, 0);
		grid.add(b4, 1, 1);
		
		
		
	}
	
	public void changeScreen(ActionEvent e) {
		
		Stage stage = (Stage) ((Node) e.getSource() ).getScene().getWindow();
		stage.setScene(menuScene);
		
	}
	
	public void handleEvent(ActionEvent e) {
		
		String msg = ((Button) e.getSource()).getText();
		
		System.out.println(msg);
		
	}
	
}
