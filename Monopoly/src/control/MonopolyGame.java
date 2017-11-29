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
