package control;

import java.util.ArrayList;

import model.Game;
import model.PlayerInGame;

public class MonopolyGame implements RunningGame{
	
	private ArrayList<Game> games =new ArrayList<Game>();
	private ArrayList<PlayerInGame> playersForOneGame =new ArrayList<PlayerInGame>();


	@Override
	public void startGame(Game g) {
		
		
	}
	@Override
	public int NumberOfplayersToGame() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
