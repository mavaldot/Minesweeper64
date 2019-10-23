package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	private Scene gameScene;

	@FXML
	private Button button;
	
	@FXML
	private Label label;
	
	public void setGameScene(Scene scene) {
		gameScene = scene;
	}

	public void changeScreen(ActionEvent e) {
		Stage stage = (Stage) ( (Node) e.getSource() ).getScene().getWindow();
		stage.setScene(gameScene);
	}
	
	@FXML
	public void hola(ActionEvent e) {
		System.out.println("WASSUP BRUH");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Do nothing
		
	}
	
}
