package control;

import model.PlayerInGame;
import model.Game;

public interface RunningGame {
	
	public void startGame(Game g);
	
	public int NumberOfplayersToGame();
	
	public PlayerInGame getPlayer();
	

}
