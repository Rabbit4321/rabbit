package view;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class oldBoardGameController implements Initializable {
/////////////Buttons///////////////////////////////Fields////////////

	@FXML
	private Button back_btn;
	@FXML
	private Button pause_btn;
	@FXML
	private Button leave_btn;
	@FXML
	private Button roll_btn;
	@FXML
	private TableView tv;
	@FXML
	private TextField current_square;
	@FXML
	private TextField moves_left;
	
///////////HandleButtons//////////////Functions/////////////////////
	
	@FXML
	private void handleBtnBack(ActionEvent event) throws IOException{
		
   
	      Parent home_page_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	        Scene home_page_scene = new Scene(home_page_parent);
	        
	        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
	        app_stage.hide();
	        app_stage.setScene(home_page_scene);
	        app_stage.setTitle("Home Page");
	        app_stage.show();

	}
	
	@FXML
	private void hundleBtnPause(MouseEvent mouse){
		
	//this button is appointed to stop the game

	}
	
	@FXML
	private void hundleBtnLeave(MouseEvent mouse){
		
	/*this button is appointed to turn on a method that will do is to handle the players in the game
		when a player wants to leave the game, this method will made another method(that belongs to the Game class) to work*/

	}
	@FXML
	private void hundleBtnRoll(MouseEvent mouse){
		
	/*this button is appointed to turn on a method that will do is to activate the dices to roll and bring the results*/

	}
	
	@FXML
	private void hundleTableView(MouseEvent mouse){
		
	/*In this table we will see how much money and disqualification each player have*/
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	
	}
	
}




