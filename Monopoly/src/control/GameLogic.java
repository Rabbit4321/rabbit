package control;

import java.util.PriorityQueue;
import java.util.Queue;

import model.Game;
import model.Board;
import model.PlayerInGame;

public class GameLogic {

	private static Board board = new Board();
	/*
	 * method bringAllPlayersInGame
	 * Received number of game
	 * return PriorityQueue of PlayerInGame
	 */
	public static void RestartBoard() {
		board.RestartBoard();
	}
	
	public static String getTypeSquareByNumber(int Num) {
		return board.getSquareType(Num);
	}
	
	/*
	 * this method bring all players in a specific game 
	   from an array of games in the singeltone monopoly
	 * received number of game
	 */
	public static Queue<PlayerInGame> bringAllPlayersInGame(int num){
		return MonopolyGame.getInstance().getGameFromArray(num).getPlayers();
		
		
		
	}
	
	
	
}
