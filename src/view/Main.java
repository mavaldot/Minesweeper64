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
			
			FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
			
			Parent menuPane = menuLoader.load();
			Scene menuScene = new Scene(menuPane,800,600);
			menuScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);
			
			
			
			primaryStage.setTitle("Buscaminas");
			primaryStage.setScene(menuScene);
			primaryStage.show();
			
			
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
