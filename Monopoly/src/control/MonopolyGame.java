package control;

import java.util.ArrayList;

import model.Admin;
import model.Game;
import model.PlayerInGame;
import model.SysData;

public class MonopolyGame{
	
	private static MonopolyGame instance;
	
	
	private ArrayList<Game> games = new ArrayList<Game>();
	private Admin admin;

	
	public static MonopolyGame getInstance()
	{
		if (instance == null)
			instance = new MonopolyGame();
		return instance;
	}
	

	public void startGame(int num,ArrayList<PlayerInGame> players) {
		for(PlayerInGame p : players) {
			SysData.AddPlayer(p);
		}
		Game g = new Game(num, players);
		g.PlayGame();
		SysData.AddGame(g);
		
	}
	


	/**
	 * Initialize Data
	 * */
	public void InitializeData() {
		this.admin= new Admin();
		//SysData.getInstance().initQuestions();
		//SysData.getInstance().initProperties();
	}
	
	
	

}
