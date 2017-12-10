package control;

import java.util.PriorityQueue;
import java.util.Queue;

import model.Game;
import model.Board;
import model.PlayerInGame;

public class GameLogic {


	
	/*
	 * method bringAllPlayersInGame
	 * Received number of game
	 * return PriorityQueue of PlayerInGame
	 */

	
	
	/*
	 * this method bring all players in a specific game 
	   from an array of games in the singeltone monopoly
	 * received number of game
	 */
	public static Queue<PlayerInGame> bringAllPlayersInGame(int num){
		return MonopolyGame.getInstance().getGameFromArray(num).getPlayersQueqe();		
		
		
	}
	
	
	
}
