package control;



import javafx.beans.property.Property;
import model.GeneralVariables;
import model.PlayerInGame;
import model.Question;

public class PlayerInGameControl {

	public static  boolean RollDice(){ // still not finished
	return false;
	}
	public static int MovePlayer(PlayerInGame player, int steps){//to marina - this method needs to return the square num accroding to the steps for the player. 
		
		int currentSquare = player.getCurrentSquare().getNum();
		
		if((currentSquare + steps) > GeneralVariables.getNumSquaresInGame())
			currentSquare=(currentSquare + steps) - GeneralVariables.getNumSquaresInGame();
		else
			currentSquare+=steps;
		
		return currentSquare;
	}
	//
	public  static String Answer(Question q){// still not finished
		return null;
	}
	
	public static void PurchaseProperty(Property p){// still not finished
		
	}
	
	public static boolean payRent(Property p , PlayerInGame payer){// still not finished
		return false;
	}
	
}
