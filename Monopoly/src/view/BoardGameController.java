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
	

	@FXML
	 ImageView player1; //players image
	
	@FXML
	 ImageView player2;//players image
	
	@FXML
	 ImageView player3;//players image
	
	@FXML
	 ImageView player4;//players image
	
	private static HashMap<PlayerInGameView ,String> playersImages;

	@FXML
	protected AnchorPane rootPane;
	
	public int gamenum; //game num from home page
	
	/**
	 * set the game num
	 * */
	public void setGameNmuToBoard(int num) {
		gamenum = num ;
	}
	/**
	 * Attach players to Images - HomepageController calls this method to initialize players in HashMap
	 * @param players in game
	 * */
	public static void attachPlayersToImages(ArrayList<PlayerInGameView> ping) {
		playersImages = new HashMap<PlayerInGameView,String>();
		int i=0;
		for(PlayerInGameView p : ping) {
			System.out.println("Player Before link to image : = "+ p.getPlayerNum());
			playersImages.put(p, "player"+(i+1));
			System.out.println("players Images !!!! "+p.toString() + "  "+ "player"+(i+1));
			i++;
		}
		System.out.println(playersImages.size() + "  "+ playersImages.toString());
	}
	

	/**
	 * 
	 * animate player moves
	 * @param playerInGame
	 * @param SquareView
	 * */
    public void MovePlayerInBoardAnimation(PlayerInGameView pv,SquareView SquareToGo) {
    	Timeline bouncer1 = new Timeline();
    	Timeline bouncer2 = new Timeline();
    	bouncer1.setCycleCount(1/*Timeline.INDEFINITE*/);
    	bouncer2.setCycleCount(1/*Timeline.INDEFINITE*/);
    	DoubleProperty y = null;
        DoubleProperty x = null;
        System.out.println(playersImages.containsKey(pv));
    	if(playersImages.containsKey(pv)) {
    		if(playersImages.get(pv).compareTo("player1") == 0) {
    			System.out.println( "One");
    			y = player1.yProperty();
    	        x = player1.xProperty();
    		}
    		else if(playersImages.get(pv).compareTo("player2") == 0) {
    			System.out.println( "two");
    			y = player2.yProperty();
    	        x = player2.xProperty();
    		}
    		else if(playersImages.get(pv).compareTo("player3") == 0) {
    			System.out.println( "three");
    			y = player3.yProperty();
    	        x = player3.xProperty();
    		}
    		else if(playersImages.get(pv).compareTo("player4") == 0) {
    			System.out.println( "four");
    			y = player4.yProperty();
    	        x = player4.xProperty();
    		}
    		else {
    			System.out.println( "***none*****");
    		}
    			
    	}
        if( x != null && y != null) {
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
        else {
        	showErrorMessage(null);
        }
       
    }

///////////HandleButtons//////////////Functions/////////////////////
	/* when the screen is ready just to connect it to the TextField(according the name
    @FXML
    public void hundleTextFieldTurnLeft(ActionEvent e, String text){
    	moves_left.appendText(text);
    }
 
   @FXML
    public void hundleTextFieldNumRolled(MouseEvent mouse,String numberRolled){
    	numRolled.appendText(numberRolled);
    } */
    
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
	/**
	 * Show message Error for testing
	 * */
	public static void showErrorMessage(ActionEvent event){

	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information Dialog");
	    alert.setHeaderText("No Game");
	    alert.setContentText("");

	    alert.showAndWait();
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
	 public PlayerInGameView getPlayerByNum(int NumPlayer) {
		 for(PlayerInGameView p: playersImages.keySet()) {
			 if(p.getPlayerNum() == NumPlayer)
				 return p;
		 }
		 return null;
	 }
	 
	 
	//https://docs.oracle.com/javafx/2/animations/basics.htm
	//http://www.java2s.com/Tutorials/Java/JavaFX/1010__JavaFX_Timeline_Animation.htm
	@FXML
	private void hundleBtnRoll(MouseEvent mouse){
		
	/*this button is appointed to turn on a method that will do is to activate the dices to roll and bring the results*/

		int result;
		
		result = Dice.Roll() + Dice.Roll();
		
		//hundleTextFieldNumRolled(mouse,String.valueOf(result));
		System.out.println("RESULT: "+result);
      //  int numGame = MonopolyGame.getInstance().games.get(0).getGameNum();
        System.out.println("Game NUMBER: "+gamenum);
        if(MonopolyGame.getGameFromArray(gamenum) != null) {
				Player pv = MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(gamenum)).peek();//get next player-> bring the next player in the queue
			//	System.out.println("View " +"In board game the number of the player is: " + pv.getPlayerNum());
				System.out.println(GameLogic.bringAllPlayersInGame(gamenum));
				
				for(PlayerInGame g: GameLogic.bringAllPlayersInGame(gamenum)){
					System.out.println("View "+g.getPlayerNum() + " ");
				}
				//trying on one player - work!
					PlayerInGameView p = getPlayerByNum(2);
					if(p != null) {
					p.ChangeSquareViews(BoardView.getStart());
					int currentSquare = PlayerInGameControl.MovePlayer(p.getPlayerNum(), gamenum,result);
					MovePlayerInBoardAnimation(p,BoardView.getSquareByNum(currentSquare));
					SquareView newSquare= BoardView.getSquareByNum(currentSquare) ;
						if(newSquare != null) {
							if(MonopolyGame.getTypeSquareByNumber(currentSquare).compareTo("Property")==0) {
								SquareControl.propertySquare(currentSquare);
								showPropertyMessage(null);
							}
							else if(MonopolyGame.getTypeSquareByNumber(currentSquare).compareTo("LuckyCard")==0) {
								SquareControl.luckyCardSquare(currentSquare);
								showLuckyCardMessage(null);
							}
							else if(MonopolyGame.getTypeSquareByNumber(currentSquare).compareTo("QuestionCard")==0) {
								SquareControl.questionCardSquare(currentSquare);
								showQuestionMessage(null);
							}
						
						}
						else {
							 
						}
					}
					else {
						showErrorMessage(null);
					}
				 //END trying
					
				MonopolyGame.getAllPlayersInGame(MonopolyGame.getGameFromArray(gamenum)).poll();
        }
        else {
        	showErrorMessage(null);
        }
	}


//	
//	@FXML
//	private void hundleTableView(MouseEvent mouse){
//		
//	/*In this table we will see how much money and disqualification each player has*/
//		
//	}

	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		  /** transfer to add players to game controller*/
	    MonopolyGame.getInstance().InitializeData();
		PlayerInGame p1 = new PlayerInGame(1,"Elinor",new Square(1,TypeSquares.START));
		PlayerInGame p2 = new PlayerInGame(2,"Einav",new Square(1,TypeSquares.START));
		ArrayList<PlayerInGame> playersInGame = new ArrayList<>();
		playersInGame.add(p1);
		playersInGame.add(p2);
		gamenum=MonopolyGame.CreateGame(2,playersInGame);
	
		System.out.println("GAME NUM FROM VIEW : "+gamenum);
		PlayerInGameView viewP1 = new PlayerInGameView(1, BoardView.getStart(), gamenum);
		PlayerInGameView viewP2 = new PlayerInGameView(2, BoardView.getStart(), gamenum);
		ArrayList<PlayerInGameView> p = new ArrayList<>();
		p.add(viewP1);
		p.add(viewP2);
		System.out.println(" players in game view**** : "+ p.toString());
		BoardGameController.attachPlayersToImages(p);
		
		
	//	board = new BoardView();
	//	board.RestartBoardView();
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


/*public void start(Stage primaryStage) {
    
	primaryStage.setTitle("Trying");
	Group root = new Group();
	Scene scene = new Scene(root);
	Image image1 = new Image("file:img/Bugsbunny2011.png") ;
  //  Image image2 = new Image("...")  ;
    ImageView imageView = new ImageView(image1);
    
    imageView.setFitWidth(350);
    imageView.setPreserveRatio(true);
    imageView.setSmooth(true);
    imageView.setLayoutX(600);
    imageView.setLayoutY(290);
    
    Timeline timeline = new Timeline();
    timeline.setCycleCount(1);
    KeyFrame movePlane = new KeyFrame(Duration.millis(1500),
    		new KeyValue(imageView.translateXProperty(),-810),
    		new KeyValue(imageView.translateYProperty(),0));

    timeline.getKeyFrames().add(movePlane);
    timeline.play();
    root.getChildren().add(imageView);
    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.show();
}*/
	

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

