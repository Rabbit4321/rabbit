package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.omg.CORBA.portable.InputStream;



public class Game{
	private int GameNum;//need to be static gameNum++
	private Board board;
	private Queue<PlayerInGame> players; // 2-4
	private Dice[] dices= new Dice[GeneralVariables.getNumDiceInGame()]; // 2 dices in game
	private HashMap<PlayerInGame,Integer> playersInJail; //players in jail
	private int NumPlayersThatBankruptcy = 0; // players who bankruptcy
	private int NumOfPlayersInGame=0; // number defined by user of players
	private static int Counter=0; // automatic count for games-> don't need it
	private int TurnsLeft; // turns num of left moves
	
	/**
	 * Constructor 1
	 * */
	
	public Game(int numPlayers,ArrayList<PlayerInGame> pg){// מספר שחקנים
		this.setGameNum(getCounter());
		this.board= new Board();
		this.NumOfPlayersInGame=numPlayers;
		this.players= new ArrayBlockingQueue<PlayerInGame>(this.NumOfPlayersInGame);
		Collections.shuffle(pg);//don't remember this method
		//A try/Elinor wrote/
//		this.players.add(pg.get(0));
//		this.players.add(pg.get(1));//-> there is an exception here - don't know why
		//End of try//
		this.players.addAll(pg);//ArrayList can't enter to a Queue-> need to convert it to queue somehow
		System.out.println("Model "+players.toString());
		for(PlayerInGame g: players){
			System.out.println("Model "+g.getPlayerNum());
		}
		this.playersInJail = new HashMap<PlayerInGame,Integer>(this.NumOfPlayersInGame);
		this.TurnsLeft = GeneralVariables.getNumOfTurnsInGame();
		UpdateAllPlayersToStart();
		AddToCounter();
	}
	/**
	 * Constructor 2
	 * */
	public Game(){
		super();
	}
	/**
	 * Constructor 3
	 * */
	public Game(int gameNum){//Elinor wrote this
		GameNum = gameNum;
		
	}
	
	/**
	 * One Round of all players
	 * */
	
	public void OneRound() {
 
	//	while(!this.players.isEmpty()) {
			
	//	}
		
		
	}
	
 public void OneTurnForPlayer(PlayerInGame p, int DiceResult) {
//		//int DiceResult = 0;
	 PlayerInGame currentPlayer = this.players.poll();// pull the player from queue
		if(!currentPlayer.isInJail()){
//			for(int i=0; i<dices.length;i++){
//		//	DiceResult += dices[i].Roll();
		//	}
			System.out.println(DiceResult); //check
			int NumNewDice = (DiceResult + currentPlayer.getCurrentSquare().getNum()) % GeneralVariables.getNumSquaresInGame(); // number of dice for the player
			System.out.println(NumNewDice);// check
			currentPlayer.ChangeSqure(NumNewDice); // update dice to player
			if(!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.JAIL)) && 
					!(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.START))) {
				
			/*	if(currentPlayer.getCurrentSquare() instanceof Property) {
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
				}*/
				 if(currentPlayer.getCurrentSquare().getType().equals(TypeSquares.GO_TO_JAIL)) {
					Square s = currentPlayer.getCurrentSquare();
					currentPlayer.setCurrentSquare(board.getJail());
					if(!currentPlayer.goToJailSquare()) {
						this.playersInJail.put(currentPlayer, 0); // insert to jail with 0 turns
					}
					else {
						currentPlayer.setCurrentSquare(s);
					}
				}
			 } 
		else if(this.playersInJail.containsKey(currentPlayer)) {
			this.playersInJail.replace(currentPlayer, this.playersInJail.get(currentPlayer)+1);
		}
		this.players.add(currentPlayer); //add to the end of the queue
		}
 }
	/**
	 * play Game - running all 50 turns
	 * */
	
	public void PlayGame() {
		board.RestartBoard(); //restart board
		UpdateAllPlayersToStart(); // restart players money and position on board
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
		if(this.playersInJail.get(p) == 1)
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

	public Queue<PlayerInGame> getPlayersQueqe() {		
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

	public static int getCounter() {
		return Counter;
	}
	public static void AddToCounter() {
		Counter++;
	}

}

