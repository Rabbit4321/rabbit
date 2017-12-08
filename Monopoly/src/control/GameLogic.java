package control;

import java.util.PriorityQueue;
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
	
	public String getTypeSquareByNumber(int Num) {
		return board.getSquareType(Num);
	}
	
	public static PriorityQueue<PlayerInGame> bringAllPlayersInGame(int num){
		return null;
		//Game.getCounter();
		
	}
	
	
	
}
