package model;

import java.util.ArrayList;

public class Game {
	private int GameNum;
	private Board board;
	private ArrayList<PlayerInGame> players= new ArrayList<PlayerInGame>(); // 1-4
	private Dice[] dices= new Dice[GeneralVariables.getNumDiceInGame()]; // 2 dices in game
	
	/**
	 * Constructor
	 * */
	Game(int n,Board b,ArrayList<PlayerInGame> pg){
		this.setGameNum(n);
		this.board=b;
		this.players=pg;
	}
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
	public int getGameNum() {
		return GameNum;
	}
	public void setGameNum(int gameNum) {
		GameNum = gameNum;
	}
	
	
}
