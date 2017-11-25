package model;

public class Player {
	
	private int playerNum;
	private String nickname;//משחקים
	
	
	
	
	Player(int pn,String nn){
		this.playerNum=pn;
		this.nickname=nn;
		
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
