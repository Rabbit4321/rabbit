package control;

import java.util.ArrayList;
import java.util.Queue;

import model.Admin;
import model.Board;
import model.Game;
import model.GeneralVariables;
import model.PlayerInGame;
import model.Square;
import model.SysData;
import model.TypeSquares;

public class MonopolyGame{
	
	private static MonopolyGame instance;
	
	private static Board board;
	public static ArrayList<Game> games = new ArrayList<Game>();
	private Admin admin;

	
	public static MonopolyGame getInstance()
	{
		if (instance == null)
			instance = new MonopolyGame();
		return instance;
	}

	
	public static String getTypeSquareByNumber(int Num) {
	//	board =new Board();
		return board.getSquareType(Num).toString();
	}

	public static int CreateGame(int num,ArrayList<PlayerInGame> players) {
		Game g = new Game(num, players);
		System.out.println("GAME NUM FROM CONTROL : "+g.getGameNum());
		games.add(g);
		board =new Board();
		SysData.AddGame(g);
		for(PlayerInGame p : players) {
		//	p = new PlayerInGame();
			SysData.AddPlayer(p);
			p.setGameNum(g.getGameNum());
		}
		return g.getGameNum();
		
	}
	//return players in a specific game
	public static Queue<PlayerInGame> getAllPlayersInGame(Game game){
		return game.getPlayersQueqe();
	}
	//return a specific game as an object
	public static Game getGame(Game game){
		return game;
	}
	//return a specific game by number of game
	public static Game getGameFromArray(int num){
		for (Game g: games) {
			if(g.getGameNum() == num)
				return g;
		}
		return null;
	}


	/**
	 * Initialize Data
	 * */
	public void InitializeData() {
		this.admin= new Admin();
		//SysData.getInstance().initQuestions();
		//SysData.getInstance().initProperties();
	}
	
	//public static int getCurrentGame(){
		//return Game.getGameNum();
	//}
	
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
