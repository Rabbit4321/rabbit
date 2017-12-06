package model;

import javafx.beans.property.SimpleStringProperty;

public class ScoresTable {
	    
	private final SimpleStringProperty nickName;
	private final SimpleStringProperty money;
	private final SimpleStringProperty disqualification;
	private SimpleStringProperty turn;
	
	
	public ScoresTable(String nickName, String money, String disqualification, String turn){
		 this.nickName = new SimpleStringProperty(nickName);
		 this.money = new SimpleStringProperty(money);
		 this.disqualification = new SimpleStringProperty(disqualification);
		 this.turn = new SimpleStringProperty(turn);

	}


	public String getTurn() {
		return turn.get();
	}


	public void setTurn(SimpleStringProperty turn) {
		this.turn = turn;
	}


	public String getNickName() {
		return nickName.get();
	}


	public String getMoney() {
		return money.get();
	}


	public String getDisqualification() {
		return disqualification.get();
	}
	
}
