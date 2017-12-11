package view;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
	
  Parent home_page_parent = FXMLLoader.load(getClass().getResource("ManageQuestions.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    
    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(home_page_scene);
    app_stage.setTitle("Monopoly game by Rabbit team");
    app_stage.show();


}

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
		
	    /** transfer to add players to game controller*/
	    MonopolyGame.getInstance().InitializeData();
		PlayerInGame p1 = new PlayerInGame(1,"Elinor",new Square(1,TypeSquares.START));
		PlayerInGame p2 = new PlayerInGame(2,"Einav",new Square(1,TypeSquares.START));
		ArrayList<PlayerInGame> playersInGame = new ArrayList<>();
		playersInGame.add(p1);
		playersInGame.add(p2);
		gamenum=MonopolyGame.CreateGame(2,playersInGame);
		PlayerInGameView viewP1 = new PlayerInGameView(1, BoardView.getStart(), gamenum);
		PlayerInGameView viewP2 = new PlayerInGameView(2, BoardView.getStart(), gamenum);
		ArrayList<PlayerInGameView> p = new ArrayList<>();
		p.add(viewP2);
		p.add(viewP2);
		BoardGameController.attachPlayersToImages(p);

	}

public void initialize(URL url, ResourceBundle rb) {

	
}
}
