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
	private Board board;
	private Queue<PlayerInGame> players; // 2-4
	private Dice[] dices= new Dice[GeneralVariables.getNumDiceInGame()]; // 2 dices in game
	private HashMap<PlayerInGame,Integer> playersInJail; //players in jail
	private int NumPlayersThatBankruptcy = 0; // players who bankruptcy
	private int NumOfPlayersInGame=0; // number defined by user of players
	private static int Counter=0; // automatic count for games
	private int TurnsLeft; // turns
//	private HashMap<PlayerInGame,boolean> WhoIsAnActivePlayer
	
	/**
	 * Constructor 1
	 * */
	
	public Game(int numPlayers,ArrayList<PlayerInGame> pg){// מספר שחקנים
		this.setGameNum(getCounter());
		this.board= new Board();
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
		while(!this.players.isEmpty()) {
			PlayerInGame currentPlayer = this.players.poll();// pull the player from queue
			PlayerFinished =false;
			if(!currentPlayer.InJail) {
				for(int i=0; i<dices.length;i++) {// roll dice
					DiceResult += dices[i].Roll();
				}
				System.out.println(DiceResult); //check
				int NumNewDice = (DiceResult + currentPlayer.getCurrentSquare().getNum()) % GeneralVariables.getNumSquaresInGame(); // number of dice for the player
				System.out.println(NumNewDice);// check
				currentPlayer.ChangeSqure(NumNewDice); // update dice to player
				if(!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.JAIL)) && 
						!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.START))) {
					if(currentPlayer.getCurrentSquare() instanceof Property) {
							Property pr = (Property)currentPlayer.getCurrentSquare();
							 currentPlayer.propertySquare(pr);
					}
					else if(currentPlayer.getCurrentSquare() instanceof LuckyCard) {
					        LuckyCard lc = (LuckyCard)currentPlayer.getCurrentSquare();
					        currentPlayer.luckyCardSquare(lc);
					}
					else if(currentPlayer.getCurrentSquare() instanceof QuestionCard) {
						QuestionCard lc = (QuestionCard)currentPlayer.getCurrentSquare();
				        currentPlayer.questionCardSquare(lc);
					}
					else if(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.GO_TO_JAIL)) {
						if(!currentPlayer.goToJailSquare())
							this.playersInJail.put(currentPlayer, 0); // insert to jail with 0 turns
					}
				 } 
			}
			else if(this.playersInJail.containsKey(currentPlayer)) {
				this.playersInJail.replace(currentPlayer, this.playersInJail.get(currentPlayer)+1);
			}
			if(currentPlayer.howManyDisq()) {
				currentPlayer.setInJail(true);
				this.playersInJail.put(currentPlayer, 0); // insert to jail with 0 turns
			}
			this.players.add(currentPlayer); //add to the end of the queue
		}
		
		
	}
	
	/**
	 * play Game - running all 50 turns
	 * */
	
	public void PlayGame() {
		board.RestartBoard(); //restart board
		UpdateAllPlayersToStart(); // restart players money
		while( (0.75 * this.NumOfPlayersInGame) != this.NumPlayersThatBankruptcy && this.TurnsLeft != 0 && this.players.size() > GeneralVariables.getMinimumPlayerInGame()) { //while 0.75 not bankruptcy and still have turns
			OneRound();
			PlayersInJailValidation();
			this.TurnsLeft--;
			if(this.NumOfPlayersInGame == this.playersInJail.size()) {
				UpdateAllPlayersToStart();
			}
		}
		EndGame();
		
	}
	
	/**
	 * update all players to start square
	 * */
	
	public void UpdateAllPlayersToStart() {
		for(PlayerInGame p : this.players) {
			p.ChangeSqure(board.getStart().getNum());
		}
	}
	
	/**
	 * check if player can get out of jail
	 * @param player
	 * @return player if true, else null
	 * */
	
	public PlayerInGame CheckIfPlayerCanBeOutOfJail(PlayerInGame p) {
		if(this.playersInJail.get(p) == 3)
			return p;
		return null;
	}
	
	/**
	 * update players back to game if they can go out of jail
	 * 
	 * */
	
	public void PlayersInJailValidation() {
		for(PlayerInGame p: this.playersInJail.keySet()) {
			if(CheckIfPlayerCanBeOutOfJail(p) != null) {
				p.setInJail(false);
				this.playersInJail.remove(p);
			}
		}
	}
	
	/**
	 * for player who wants to exit the game
	 * */
	
	public void playerExit(PlayerInGame p){
		this.players.remove(p);
		if(this.players.size() < GeneralVariables.getMinimumPlayerInGame()) {
			EndGame();
		}
	}
	
	/**
	 * exit the game and announce the winner
	 * */
	
	public void EndGame() {
		PlayerInGame winner = null;
		for (PlayerInGame p: this.players) {
			if(winner == null)
				winner = p;
			if(winner.playerValue() < p.playerValue())
				winner = p;
		}
	System.out.println("The Winner Is :" + winner.getNickname() + "With score:" + winner.playerValue());
		
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
