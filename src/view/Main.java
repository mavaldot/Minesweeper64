package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
			
			Parent menuPane = menuLoader.load();
			Scene menuScene = new Scene(menuPane,600,400);
			menuScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("game.fxml"));
			
			Parent gamePane = gameLoader.load();
			Scene gameScene = new Scene(gamePane,600,400);
			
			MenuController menuController = (MenuController) menuLoader.getController();
			menuController.setGameScene(gameScene);
			
			GameController gameController = (GameController) gameLoader.getController();
			gameController.setMenuScene(menuScene);
			
			primaryStage.setMinWidth(600);
			primaryStage.setMinHeight(400);
			
			primaryStage.setTitle("Buscaminas");
			primaryStage.setScene(menuScene);
			primaryStage.show();
			
			
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
