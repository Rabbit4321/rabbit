package control;



import java.util.ArrayList;

import model.Board;
import model.Game;
import model.GeneralVariables;
import model.PlayerInGame;
import model.Question;
import model.Square;
import model.Property;

public class PlayerInGameControl {

	public static  boolean RollDice(){ // still not finished
	return false;
	}
	public static int MovePlayer(int player,int gameNum, int steps ){//to marina - this method needs to return the square num accroding to the steps for the player. 
		
		int NumNewDice  = 0;
		PlayerInGame pig = null;
		ArrayList<PlayerInGame> playersInGame = new ArrayList<>(MonopolyGame.getGameFromArray(gameNum).getPlayersQueqe());
		System.out.println("PlayerIn game control: size: " + playersInGame.size() + " has "+ playersInGame.toString());
		for(PlayerInGame p : playersInGame)	{
			if(p != null){
				if(p.getPlayerNum() == player){
					 pig = p;
				}
			}
		}
		if(!(pig == null)){
			System.out.println("Players current square: "+pig.getCurrentSquare().getNum());
			NumNewDice = (steps+ pig.getCurrentSquare().getNum()) % GeneralVariables.getNumSquaresInGame(); // number of dice for the player
			System.out.println(" *checking Dice result* : "+NumNewDice);
			System.out.println("PlayerInGameControl-MovePlayer: move player " + pig.getPlayerNum() + " to sqaure " + NumNewDice);
			pig.setCurrentSquare(Board.getSquareByIndex(NumNewDice));
			return NumNewDice;
		/*	int currentSquare = pig.getCurrentSquare().getNum();
			
			if((currentSquare + steps) > GeneralVariables.getNumSquaresInGame())
				currentSquare=(currentSquare + steps) - GeneralVariables.getNumSquaresInGame();
			else
				currentSquare+=steps;
			
			return currentSquare;//the new square the player is in it*/
		}
		return -1;
	}
	
	public  static String Answer(Question q){// still not finished
		return null;
	}
	
	public static String PropertySquare(Property pr,PlayerInGame p){// still not finished
		Question q =p.propertySquare(pr);
		return q.getText();
	}
	
	public static boolean payRent(Property p , PlayerInGame payer){// still not finished
		return false;
	}
	
}
