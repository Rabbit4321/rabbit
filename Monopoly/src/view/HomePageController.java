package view;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.AdminControl;
import control.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Game;
import model.PlayerInGame;
import model.Square;
import model.TypeSquares;

public class HomePageController {
	
/////////////Buttons///////////////////////////////Fields////////////

/*@FXML
private Button newGame_btn;

@FXML
private Button pscores_btn;
@FXML
private Button gameRoles_btn;
@FXML
private Button admin_btn;*/
	public  int gamenum;

	private static HomePageController instance;
	
	public static HomePageController getInstance()
	{
		if (instance == null)
			instance = new HomePageController();
		return instance;
	}
	

///////////HandleButtons//////////////Functions/////////////////////

@FXML
public void hundleBtnAdmin(ActionEvent event) throws IOException{
	
	
	AdminControl.initAdmin();
	
  Parent home_page_parent = FXMLLoader.load(getClass().getResource("Questions.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    
    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(home_page_scene);
    app_stage.setTitle("Monopoly game by Rabbit team");
    app_stage.show();
}
@FXML
public void hundleBtnNewGame(ActionEvent event) throws IOException{

	  Parent home_page_parent = FXMLLoader.load(getClass().getResource("BoardGame1.fxml"));
	    Scene home_page_scene = new Scene(home_page_parent);
	    
	    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
	    app_stage.hide();
	    app_stage.setScene(home_page_scene);
	    app_stage.setTitle("Monopoly game by Rabbit team");
	    app_stage.show();
	    //restart the boardView
	    BoardView b = new BoardView();
		b.RestartBoardView();
		
		
	}

public void initialize(URL url, ResourceBundle rb) {

	
}
}
