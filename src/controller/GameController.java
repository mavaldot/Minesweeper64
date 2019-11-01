package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import model.Buscaminas;
import model.Casilla;

public class GameController implements Initializable {

	private Scene menuScene;
	private Buscaminas buscaminas;
	private int level;
	
	@FXML
	HBox hbox;
	
	@FXML
	GridPane grid;
	
	@FXML
	Label label;
	
	public void setMenuScene(Scene scene) {
		menuScene = scene;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Do nothing
	}
	
	public void loadBoard() {
		
		createNewGrid();
//		hbox.getChildren().add(grid);
	}
	
	public void showGameOver() {
		
		hbox.getChildren().remove(grid);
		solveGrid();
		label.setText("YOU LOSE");
	}
	
	public void createNewGrid() {
		
		buscaminas = null;	
		buscaminas = new Buscaminas(level);

		grid = null;
		grid = new GridPane();
		
		updateGrid();
		
	}
	
	public void showClue(ActionEvent e) {
		
		buscaminas.darPista();
		updateGrid();
		checkWin();
	}
	
	public void updateGrid() {
		
		
		Casilla[][] casillas = buscaminas.darCasillas();
		
		hbox.getChildren().removeAll();
		hbox.getChildren().clear();
		
		grid = null;
		grid = new GridPane();
		
		int width = casillas.length;
		int height = casillas[0].length;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				int row = i;
				int column = j;
				
				Button b = new Button(casillas[row][column].mostrarValorCasilla());
				
				b.setOnMouseClicked(e -> { 

		            if (e.getButton().equals(MouseButton.SECONDARY)) {
		            	
		            	casillas[row][column].flag();
		            	
		            	((Button) e.getSource()).setText(casillas[row][column].mostrarValorCasilla());
		            		
		            }
		            else {      
		            	
		            	casillas[row][column].destapar();
		            	
		            	if (!casillas[row][column].getFlagged()) {
		            		
			            	if (!casillas[row][column].esMina()) {
				            	b.setText(casillas[row][column].mostrarValorCasilla());
				            	checkWin();
			            	}
			            	else
			            		showGameOver(); 
		            		
		            	}
		            	
         
				            	
		            }
				});
				
				grid.add(b, j, i);
			}	
		}
		
		hbox.getChildren().add(grid);
	}
	
	public void flagCasilla(Button button, int i, int j) {
		buscaminas.flagCasilla(i, j);
		Casilla[][] casillas = buscaminas.darCasillas();
		button.setText(casillas[i][j].mostrarValorCasilla());
	}
	
	public void checkWin() {
		
		if (buscaminas.gano()) {			
			solveGrid();
			label.setText("YOU WIN");
		}
		
	}
	
	public void solveGrid() {
		
		buscaminas.resolver();
		updateGrid();
		
	}
	
	public void changeScreen(ActionEvent e) {
		
		Stage stage = (Stage) ((Node) e.getSource() ).getScene().getWindow();
		stage.setScene(menuScene);
		
	}
	
	public void giveSolution(ActionEvent e) {
		solveGrid();
		checkWin();
	}
	
}
