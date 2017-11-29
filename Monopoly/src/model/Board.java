package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Board {
	private static ArrayList<Square> AllSquares;
	private static Board instance = null;
	private static Square Start = new Square();
	
	  protected Board() {
	      // Exists only to defeat instantiation.
	   }
	 public static Board getInstance() {
	      if(instance == null) {
	         instance = new Board();
	      }
	      return instance;
	   }

	/**
	 * restart the board and locate any square in her place (notice: 'Go to jail','Free parking','Jail','Start' are already defined in specific place
	 * @param list of squares*/
	
	public static void RestartBoard() {
	/**TODO*/
		AllSquares = new ArrayList<Square>(GeneralVariables.getNumSquaresInGame());
		Square[] Squares = new Square[GeneralVariables.getNumSquaresInGame()+1];
		int [] OptionsForEdgesBoard= {1,11,21,31};
		ArrayList<Property> properties = new ArrayList<Property>();
		ArrayList<LuckyCard> luckycards = new ArrayList<LuckyCard>();
		ArrayList<QuestionCard> quesCards = new ArrayList<QuestionCard>();
		
		//Initialize all the data from SysData (json files)
		
		properties = SysData.getProperties();
	//	luckycards = SysData.getLuckycards();
	//	quesCards = SysData.getQuestionCards();
		
		
		//Initialize start,jail and go to jail squares
		
		int rnd = new Random().nextInt(OptionsForEdgesBoard.length);
		Squares[OptionsForEdgesBoard[rnd]] = new Square();
		Squares[OptionsForEdgesBoard[rnd]].setType(TypeSquares.START);
		Start = Squares[OptionsForEdgesBoard[rnd]];
		
	/*checks	
	 * System.out.println(OptionsForEdgesBoard[rnd]);
		System.out.println((OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame());
		System.out.println((OptionsForEdgesBoard[rnd] + 20) % GeneralVariables.getNumSquaresInGame());
		}*/
		
		
		Squares[(OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame()] = new Square();
		Squares[(OptionsForEdgesBoard[rnd] + 10) % GeneralVariables.getNumSquaresInGame()].setType(TypeSquares.GO_TO_JAIL);
		Squares[(OptionsForEdgesBoard[rnd] + 20) % GeneralVariables.getNumSquaresInGame()] = new Square();
		Squares[(OptionsForEdgesBoard[rnd] + 20) % GeneralVariables.getNumSquaresInGame()].setType(TypeSquares.JAIL);

		for( int i=1; i<Squares.length; i++) {
			if(Squares[i] == null) {
				Squares[i]= new Square();
				
				
			}
		}
		AllSquares = Arrays.asList(Squares);
		
	}
	
	/**
	 * Move player to steps on the board
	 * @param player,steps
	 * @return if succeed - current square, 
	 * */
	
	public Square MovePlayer(PlayerInGame p,int steps) {
		return null;
		
	}
	
	public Square getStart() {
		return Start;
	}

	public ArrayList<Square> getAllSquares() {
		return AllSquares;
	}

	public void setAllSquares(ArrayList<Square> allSqures) {
		AllSquares = allSqures;
	}
	public static void main(String[] args) {
		//Board b= new Board();
		new Board();
		RestartBoard();
		//check for 
		int i=39;
		int j=2;
		int newPosition = (i + j) % GeneralVariables.getNumSquaresInGame();
		int t=2;
		double g=0.75;
		int div=(int) (g * t);
		System.out.println(newPosition+"  "+ div);
	
	}

}
