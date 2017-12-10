package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.GameLogic;
import control.MonopolyGame;
import control.PlayerInGameControl;
import control.SquareControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Dice;
import model.Game;
import model.Player;
import model.PlayerInGame;
import model.Square;
import model.TypeSquares;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;

public class BoardGameController implements Initializable {
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
	@FXML
	private Image dices;//found an animation on internet -> in the end of the code*/
	@FXML
	private static ImageView player;
	@FXML
	private TextField numRolled;
	
	public BoardView board;
	
	public PlayerInGameView pinv;
	
	
	/////////////////////////////////////////////getters & setters///////////////////////

	public static ImageView getPlayer(){
		Image image = new Image("file:img/Bugsbunny2011.png");
		ImageView p = new ImageView();
		p.setImage(image);
		p.setX(600);
		p.setY(290);
		player = p;
		return player;
	}
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
	        app_stage.resizableProperty().setValue(Boolean.FALSE);

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
	
	 public static void showPropertyMessage(ActionEvent event){

		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Information Dialog");
		    alert.setHeaderText("You are in  PROPERTY SQUARE");
		    alert.setContentText("");

		    alert.showAndWait();
		      }
	 
	 public static void showLuckyCardMessage(ActionEvent event){

		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Information Dialog");
		    alert.setHeaderText("You are in  PROPERTY SQUARE");
		    alert.setContentText("");

		    alert.showAndWait();
		      }
	 public static void showQuestionMessage(ActionEvent event){

		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Information Dialog");
		    alert.setHeaderText("You are in  PROPERTY SQUARE");
		    alert.setContentText("");

		    alert.showAndWait();
		      }
	//https://docs.oracle.com/javafx/2/animations/basics.htm
	//http://www.java2s.com/Tutorials/Java/JavaFX/1010__JavaFX_Timeline_Animation.htm
	@FXML
	private void hundleBtnRoll(MouseEvent mouse){
		
	/*this button is appointed to turn on a method that will do is to activate the dices to roll and bring the results*/
//
//	int result1;
//		int result2;
//		result1 = Dice.Roll();
//		result2 = Dice.Roll();
//		Game game = new Game(MonopolyGame.getCurrentGame()); // get the current game is playing right now
//		PlayerInGame playerInGame = MonopolyGame.getAllPlayersInGame(game).poll();//get the current player is play right now in the current game
//		playerInGame.hundleMovingThePlayer(result1+result2);

		int result;
		
		result = Dice.Roll() + Dice.Roll();
        int numGame = HomePageController.getInstance().gamenum;
		Player pv = MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(numGame)).poll();//get next player-> bring the next player in the queue
		pinv.ChangeSquareViews(BoardView.getStart());
		int currentSquare = PlayerInGameControl.MovePlayer(pv.getPlayerNum(), numGame,result);
		System.out.println( "player number " + pv.getPlayerNum() + " need to go to : " + currentSquare);
		/*int Numsquare  = 11;
		SquareView newSquare= BoardView.getSquareByNum(Numsquare) ;
		if(newSquare != null) {
			pinv.ChangeSquareViews(newSquare);
			if(MonopolyGame.getTypeSquareByNumber(Numsquare).compareTo("Property")==0) {
				SquareControl.propertySquare(Numsquare);
				//showPropertyMessage(event);
		
			}
			else if(MonopolyGame.getTypeSquareByNumber(Numsquare).compareTo("LuckyCard")==0) {
				SquareControl.luckyCardSquare(Numsquare);
			////	showLuckyCardMessage(mouse);
			}
			else if(MonopolyGame.getTypeSquareByNumber(Numsquare).compareTo("QuestionCard")==0) {
				SquareControl.questionCardSquare(Numsquare);
			//	showQuestionMessage(mouse);
			}
		
		}
		
	}
	
	
	@FXML
	private void hundleTableView(MouseEvent mouse){
		
	/*In this table we will see how much money and disqualification each player has*/
	}
	

	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		board = new BoardView();
		board.RestartBoardView();
		pinv = new PlayerInGameView(1, board.getStart(),HomePageController.getInstance().gamenum);
		/////////////////////table//////////////////////
		/*
        TableColumn nickNameCol = new TableColumn("Nick Name");
        nickNameCol.setMinWidth(100);
        nickNameCol.setCellValueFactory(
        		new PropertyValueFactory<>("nickName"));

        TableColumn moneyCol = new TableColumn("Money");
        moneyCol.setMinWidth(100);
        moneyCol.setCellValueFactory(
                new PropertyValueFactory<>("money"));

        TableColumn disquaCol = new TableColumn("Disqualification");
        disquaCol.setMinWidth(100);
        disquaCol.setCellValueFactory(
                new PropertyValueFactory<>("disqualification"));
        
        TableColumn turnCol = new TableColumn("Turn");
        turnCol.setMinWidth(100);
        turnCol.setCellValueFactory(
                new PropertyValueFactory<>("turn"));


        tv.getColumns().clear();
        tv.getColumns().addAll(nickNameCol, moneyCol, disquaCol,turnCol);
        tv.setItems((ObservableList) GameLogic.bringAllPlayersInGame(Game.getCounter()));
//i think we will needed game logic in a singeltone way and his constructor will provide us the table we need*/
	}
	

/*public static void main(String[] args) {
	// TODO Auto-generated method stub
	//just an example of an existing players for let the game to play
	PlayerInGame p1 = new PlayerInGame(1,"Elinor",new Square(1,TypeSquares.START));
	PlayerInGame p2 = new PlayerInGame(2,"Einav",new Square(1,TypeSquares.START));
	ArrayList<PlayerInGame> playersInGame = new ArrayList<>();
	if(playersInGame.add(p1) && playersInGame.add(p2)){
		Game game = new Game(2,playersInGame);
		game.PlayGame();
	}

	}*/
}

