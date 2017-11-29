package control;

import model.PlayerInGame;

import java.util.ArrayList;

import model.Game;

public interface RunningGame {
	
	public void startGame(int num,ArrayList<PlayerInGame> players);
	
	public void InitializeData();

	

}
