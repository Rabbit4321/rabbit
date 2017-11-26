package control;

import model.PlayerInGame;

public interface RunningGame {
	public boolean IsInJail(PlayerInGame p);
	public boolean AddPlayerToGame(PlayerInGame p);
	

}
