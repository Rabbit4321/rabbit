package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import control.RunningGame;

public class Game implements RunningGame{
	private int GameNum;
	private Queue<PlayerInGame> players; // 2-4
	private Dice[] dices= new Dice[GeneralVariables.getNumDiceInGame()]; // 2 dices in game
	private HashMap<PlayerInGame,Integer> playersInJail;
	private int NumPlayersThatBankruptcy = 0;
	private int NumOfPlayersInGame=0;
	private static int Counter=0;
	private int TurnsLeft;
	
	/**
	 * Constructor 1
	 * */
	
	public Game(int numPlayers,ArrayList<PlayerInGame> pg){// מספר שחקנים
		this.setGameNum(getCounter());
		this.NumOfPlayersInGame=numPlayers;
		this.players= new PriorityQueue<PlayerInGame>(this.NumOfPlayersInGame);
		Collections.shuffle(pg);
		this.players.addAll(pg);
		this.playersInJail = new HashMap<PlayerInGame,Integer>(this.NumOfPlayersInGame);
		this.TurnsLeft = GeneralVariables.getNumOfTurnsInGame();
		AddToCounter();
	}
	/**
	 * Constructor 2
	 * */
	public Game(){
		super();
	}
	
	/**
	 * One Round of all players
	 * */
	
	public void OneRound() {
		int DiceResult = 0; 
		boolean PlayerFinished =false;
		for(PlayerInGame p : this.players) {
			PlayerInGame currentPlayer = this.players.poll();// pull the player from queue
			PlayerFinished =false;
			if(!currentPlayer.InJail) {
				for(int i=0; i<dices.length;i++) {// roll dice
					DiceResult += dices[i].Roll();
				}
				System.out.println(DiceResult); //check
				int NumNewDice = (DiceResult + currentPlayer.getCurrentSquare()) % GeneralVariables.getNumSquaresInGame(); // number of dice for the player
				System.out.println(NumNewDice);// check
				currentPlayer.ChangeSqure(NumNewDice); // update dice to player
				if(!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.JAIL)) && 
						!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.START))) {
					if(currentPlayer.getCurrentSquare() instanceof Property) {
							Property pr = (Property)currentPlayer.getCurrentSquare();
							 currentPlayer.propertySquare(pr);
					}
				}

			}
			this.players.add(currentPlayer); //add to the end of the queue
			
		}
		
		
	}
	
	/**
	 * play Game
	 * */
	
	public void PlayGame() {
		Board.RestartBoard(); //restart board
		UpdateAllPlayersToStart(); // restart players money
		while( (0.75 * this.NumOfPlayersInGame) != this.NumPlayersThatBankruptcy && this.TurnsLeft != 0) {
			OneRound();
			this.TurnsLeft--;
			if(this.NumOfPlayersInGame == this.playersInJail.size()) {
				
			}
		}
		
	}
	public void UpdateAllPlayersToStart() {
		for(PlayerInGame p : this.players) {
			p.ChangeSqure(Board.getInstance().getStart().getNum());
		}
	}
/*	public boolean PutPlayerInJail(PlayerInGame p) {

	}*/
	
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
	public static int getCounter() {
		return Counter;
	}
	public static void AddToCounter() {
		Counter++;
	}
	
	/**
	 * 		for(PlayerInGame p: pg) {
			Random rand = new Random();
			int i= rand.nextInt(4) + 2;
			this.players.add(i,p);
		}*/
}
