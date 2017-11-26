package model;

import java.util.ArrayList;

public class Player {
	
	private int playerNum;
	private String nickname;
	private ArrayList<Game> games= new ArrayList<Game> ();	// games he played in
	
	/**
	 * Constructor
	 * */
	Player(int pn,String nn){
		this.playerNum=pn;
		this.nickname=nn;	
	}
	/**
	 * Adding game to list for history
	 * @param game to add
	 * @return if not already exists -true , else false
	 * */
	public boolean AddGame(Game g) {
		if(!games.contains(g)) {
			games.add(g);
			return true;
		}
		return false;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

}
