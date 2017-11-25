package model;

import java.util.ArrayList;

public class Game {
	private Board board;
	private ArrayList<PlayerInGame> players= new ArrayList<PlayerInGame>(4);
	private Dice[] dices= new Dice[2];
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public ArrayList<PlayerInGame> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerInGame> players) {
		this.players = players;
	}
	public Dice[] getDices() {
		return dices;
	}
	public void setDices(Dice[] dices) {
		this.dices = dices;
	}
	

}
