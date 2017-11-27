package model;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import control.RunningGame;

public class Game implements RunningGame{
	private int GameNum;
	private Board board;
	private Queue<PlayerInGame> players= new PriorityQueue<PlayerInGame>(); // 2-4
	private Dice[] dices= new Dice[GeneralVariables.getNumDiceInGame()]; // 2 dices in game
	private Queue<PlayerInGame> playersInJail= new PriorityQueue<PlayerInGame>();// 2-4
	
	/**
	 * Constructor 1
	 * */
	
	Game(int n,Board b,Queue<PlayerInGame> pg){// מספר שחקנים
		this.setGameNum(n);
		this.board=b;
		this.players=pg;
	}
	/**
	 * Constructor 2
	 * */
	Game(){
		super();
	}
	public void OneRound() {
		int DiceResult = 0;//הכנסה רנדומלית של שחקנים לשחק לפי התור
		PlayerInGame currentPlayer = this.players.poll();
		for(int i=0; i<dices.length;i++) {
			DiceResult += dices[i].Roll();
		}
		while(DiceResult != 0) {
			//currentPlayer.getCurrentSquare().
		}
		
	}
/*	public boolean PutPlayerInJail(PlayerInGame p) {

	}*/
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Queue<PlayerInGame> getPlayers() {
		return players;
	}
	public void setPlayers(Queue<PlayerInGame> players) {
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
	@Override
	public boolean IsInJail(PlayerInGame p) {
	/**	if(!playersInJail.contains(p)) {
			if(p.getNumOfDisqualifications() == GeneralVariables.getNumDisqualificationsForJail() ) { //Disqualifications number is 3 then
				return true;
			}
		}*/
		return false;
	}
	@Override
	public boolean AddPlayerToGame(PlayerInGame p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 		for(PlayerInGame p: pg) {
			Random rand = new Random();
			int i= rand.nextInt(4) + 2;
			this.players.add(i,p);
		}*/
}
