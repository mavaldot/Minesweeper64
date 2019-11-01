package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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

	public void changeScreen(ActionEvent e) {
		Stage stage = (Stage) ( (Node) e.getSource() ).getScene().getWindow();
		stage.setScene(gameScene);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Do nothing
	}
	
	public void startBeginner(ActionEvent e) throws IOException {
		
		Scene menuScene = ((Node) e.getSource()).getScene();
		loadScene(menuScene, 1);
		
	}
	
	public void startIntermediate(ActionEvent e) throws IOException {
		
		Scene menuScene = ((Node) e.getSource()).getScene();
		loadScene(menuScene, 2);
		
	}
	
	public void startExpert(ActionEvent e) throws IOException {
		
		Scene menuScene = ((Node) e.getSource()).getScene();
		loadScene(menuScene, 3);
		
	}
	
	
	public void loadScene(Scene menuScene, int level) throws IOException {
		
		FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/game.fxml"));
		Parent gamePane = gameLoader.load();
		
		Stage stage = (Stage) menuScene.getWindow();
		Scene gameScene = new Scene(gamePane, 800, 600);
		GameController gameController = (GameController) gameLoader.getController();
		gameController.setMenuScene(menuScene);
		gameController.setLevel(level);
		gameController.loadBoard();
		stage.setScene(gameScene);
	}
	
}
