package control;

import java.util.ArrayList;

import model.Admin;
import model.Game;
import model.PlayerInGame;
import model.SysData;

public class MonopolyGame implements RunningGame{
	
	private ArrayList<Game> games =new ArrayList<Game>();
	private ArrayList<PlayerInGame> playersForOneGame =new ArrayList<PlayerInGame>();
	private Admin admin;


	@Override
	public void startGame(int num,ArrayList<PlayerInGame> players) {
		Game g = new Game(num, players);
		g.PlayGame();
	}

	public int NumberOfplayersToGame() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void InitializeData() {
		this.admin= new Admin();
		
	}
	
	
	

}
