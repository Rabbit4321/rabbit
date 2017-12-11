package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import control.GameLogic;
import control.MonopolyGame;
import control.PlayerInGameControl;
import control.SquareControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
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
	@FXML
	 ImageView player1;
	
	@FXML
	 ImageView player2;
	
	@FXML
	 ImageView player3;
	
	@FXML
	 ImageView player4;
	
	private static HashMap<PlayerInGameView ,ImageView> playersImages;

	@FXML
	protected AnchorPane rootPane;
	
	
	
	/**
	 * Attach players to Images
	 * */
	public static void attachPlayersToImages(ArrayList<PlayerInGameView> ping) {
		playersImages = new HashMap<>();
		ImageView [] images = new ImageView[4];
		int i=1;
		for(PlayerInGameView p : ping) {
			playersImages.put(p, images[i]);
			i++;
		}
		System.out.println(playersImages.size() + "  "+ playersImages.toString());
	}
	
	/**
	 * 
	 * animate player moves
	 * */
    public void bounceImage() {
    	Timeline bouncer1 = new Timeline();
    	Timeline bouncer2 = new Timeline();
    	bouncer1.setCycleCount(1/*Timeline.INDEFINITE*/);
    	bouncer2.setCycleCount(1/*Timeline.INDEFINITE*/);
    	PlayerInGameView pv = new PlayerInGameView(1, BoardView.getStart(), HomePageController.getInstance().gamenum);
        DoubleProperty y = player4.yProperty();
        DoubleProperty x = player4.xProperty();
        System.out.println("check animataion y : "+ ( pv.getCurrentSquare().getY()- BoardView.getSquareByNum(12).getY()));
        System.out.println("check animataion x : "+ (BoardView.getSquareByNum(12).getX() - pv.getCurrentSquare().getX()));
        bouncer1.getKeyFrames().addAll(
        		new KeyFrame(new Duration(1000), new KeyValue(y, pv.getCurrentSquare().getY()- BoardView.getSquareByNum(12).getY() /*new value*/))  //y value
        		);
        bouncer2.getKeyFrames().addAll(
        		new KeyFrame(new Duration(1000), new KeyValue(x, BoardView.getSquareByNum(12).getX() - pv.getCurrentSquare().getX()/*new value*/)) // x value
        		);
        SequentialTransition sequence = new SequentialTransition(bouncer2,bouncer1);
		sequence.play();
       
    }
	/**
	 * 
	 * animate player moves
	 * */
    public void MovePlayerInBoardAnimation(PlayerInGameView pv,SquareView SquareToGo) {
    	Timeline bouncer1 = new Timeline();
    	Timeline bouncer2 = new Timeline();
    	bouncer1.setCycleCount(1/*Timeline.INDEFINITE*/);
    	bouncer2.setCycleCount(1/*Timeline.INDEFINITE*/);
        DoubleProperty y = player1.yProperty();
        DoubleProperty x = player1.xProperty();
        System.out.println("check animataion y : "+ ( pv.getCurrentSquare().getY()- SquareToGo.getY()));
        System.out.println("check animataion x : "+ (SquareToGo.getX() - pv.getCurrentSquare().getX()));
        bouncer1.getKeyFrames().addAll(
        		new KeyFrame(new Duration(1000), new KeyValue(y, pv.getCurrentSquare().getY()- SquareToGo.getY() /*new value*/))  //y value
        		);
        bouncer2.getKeyFrames().addAll(
        		new KeyFrame(new Duration(1000), new KeyValue(x, SquareToGo.getX() - pv.getCurrentSquare().getX()/*new value*/)) // x value
        		);
        SequentialTransition sequence = new SequentialTransition(bouncer2,bouncer1);
		sequence.play();
       
    }

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
	
		int result;
		
		result = Dice.Roll() + Dice.Roll();
		System.out.println("The steps that the current player need to do are: " + result + " steps");
		
        int numGame = HomePageController.getInstance().gamenum;
        
		Player pv = MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(numGame)).peek();//get next player-> bring the next player in the queue
		
		System.out.println("View " +"In board game the number of the player is: " + pv.getPlayerNum());
		
		System.out.println("All players in this game are: " + GameLogic.bringAllPlayersInGame(numGame));
		
		for(PlayerInGame g: GameLogic.bringAllPlayersInGame(numGame)){
			System.out.println(" in the package View there is player number:\n " + g.getPlayerNum());
		}

		/* now we are initialize the current player to start in the start square in the board -> pinv is a PlayerInGameView*/
		pinv.ChangeSquareViews(BoardView.getStart());
		
		int currentSquare = PlayerInGameControl.MovePlayer(pv.getPlayerNum(), numGame,result);
		
		MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(numGame)).poll();
		
		System.out.println( "player number " + pv.getPlayerNum() + " need to go to: " + currentSquare);
		
		//SquareControl.insertPlayerToSquare(p, s)
		pinv.ChangeSquareViews(new SquareView(currentSquare, BoardView.getSquareByNum(currentSquare).getX(),BoardView.getSquareByNum(currentSquare).getY()));
	/* now i need to move the player to the specific square he is supposed to move for*/
		System.out.println("The player now is in: " + pinv.getCurrentSquare());
		
		
//		public void hundleMovingThePlayer(SquareView sqNew){
//			/*
//			 * final Timeline timeline = new Timeline();
//					timeline.setCycleCount(1);		//timeline.setAutoReverse(true);
//					final KeyValue kv = new KeyValue(player.xProperty(), 300);
//					final KeyValue kv2 = new KeyValue(player.yProperty(), player.yProperty().get());
//					final KeyValue kv3 = new KeyValue(player.yProperty(), 500);
//					final KeyFrame kf = new KeyFrame(Duration.millis(1500), kv);// means in how much period of time the rabbit will get to the cordinates i define him
//					final KeyFrame kf2 = new KeyFrame(Duration.millis(1500), kv2);
//				final KeyFrame kf3 = new KeyFrame(Duration.millis(2500), kv3);
//					timeline.getKeyFrames().addAll(kf,kf2,kf3);
//					timeline.play();
//					*/
//					//change in x
//					final Timeline timeline1 = new Timeline();
//					timeline1.setCycleCount(1/*Timeline.INDEFINITE*/);
//					
//					SquareView  s = sqNew;
//					//SquareView currentSquare = new SquareView(11,-210,290);
//					System.out.println( "Square "+s.getX() +" "+s.getY());
//			//		System.out.println(currentSquare.getNum() + " " + currentSquare.getX() + " "+currentSquare.getY());
//					System.out.println(BoardGameController.getPlayer().xProperty());
//					final KeyValue kv = new KeyValue(BoardGameController.getPlayer().xProperty(), s.getX() - currentSquare.getX());//-> don't sure what it means
//					final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);// means in how much period of time the rabbit will get to the cordinates i define him
//					timeline1.getKeyFrames().addAll(kf);
//					
//					
//					//change in y
//					final Timeline timeline2 = new Timeline();
//					timeline2.setCycleCount(1/*Timeline.INDEFINITE*/);
//					
//					final KeyValue kv1 = new KeyValue(BoardGameController.getPlayer().yProperty(), currentSquare.getY() - s.getY());
//					final KeyFrame kf1 = new KeyFrame(Duration.millis(1500), kv1);// means in how much period of time the rabbit will get to the cordinates i define him
//
//					timeline2.getKeyFrames().addAll(kf1);
//					
//					
//					SequentialTransition sequence = new SequentialTransition(timeline1, timeline2);
//					sequence.play();
//		}
		
		
		
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
		
	}*/
		MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(numGame)).add((PlayerInGame)pv);
	}
	
//	
//	@FXML
//	private void hundleTableView(MouseEvent mouse){
//		
//	/*In this table we will see how much money and disqualification each player has*/
//		
//	}

	private void initializeTableView(){
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
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		board = new BoardView();
		board.RestartBoardView();
		pinv = new PlayerInGameView(1, board.getStart(),HomePageController.getInstance().gamenum);
		/*initialize the tableView in the board*/
		//initializeTableView();
	}

public static void main(String[] args) {
	

	//just an example of an existing players for let the game to play
	PlayerInGame p1 = new PlayerInGame(1,"Elinor",new Square(1,TypeSquares.START));
	PlayerInGame p2 = new PlayerInGame(2,"Einav",new Square(1,TypeSquares.START));
	ArrayList<PlayerInGame> playersInGame = new ArrayList<>();
	if(playersInGame.add(p1) && playersInGame.add(p2)){
		Game game = new Game(2,playersInGame);
		game.PlayGame();
	}

	
}
}


