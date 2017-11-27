package model;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private ArrayList<Square> AllSquares=new ArrayList<Square>(GeneralVariables.getNumSquaresInGame());
	
	/**
	 * Contractor
	 * */
	public Board(){
		super();		
	}
	
	/**
	 * restart the board and locate any square in her place (notice: 'Go to jail','Free parking','Jail','Start' are already defined in specific place
	 * @param list of squares*/
	
	public void RestartBoard(ArrayList<Square> sq) {
	/**TODO*/
		int NumOfLuckyCard = 6;
		int NumOfQuestionCard = 7;
		Square[] Squares = new Square[GeneralVariables.getNumSquaresInGame()+1];
		int [] OptionsForEdgesBoard= {1,11,21,31};
		int rnd = new Random().nextInt(OptionsForEdgesBoard.length);
		Squares[rnd].setType(TypeSquares.START);
		Squares[rnd+10].setType(TypeSquares.GO_TO_JAIL);
		Squares[rnd+20].setType(TypeSquares.JAIL);
		int i= rnd +39;
		int j=1;
		while( rnd != i || j < Squares.length) {
			if( Squares[j].getType() == null ){
				
			}
			
			i--;
			j++;


			/*if(i == 0){
				squares[i] = new GoSquare("GO");
			}else if(i == 9){
				squares[i] = new JailSquare("Jail");
			}else if(i == 19){
				squares[i] = new VacationSquare("Vacation");
			}else if(i == 29){
				squares[i] = new GoToJailSquare("Go to Jail");
			}else{
				squares[i] = new HouseSquare(names[rand.nextInt(names.length)] + " " + names[rand.nextInt(names.length)], 400 + rand.nextInt(300));
			}**/
		}
		
	}
	
	/**
	 * Move player to steps on the board
	 * @param player,steps
	 * @return if succeed - current square, 
	 * */
	
	public Square MovePlayer(PlayerInGame p,int steps) {
		
	}

	public ArrayList<Square> getAllSquares() {
		return AllSquares;
	}

	public void setAllSquares(ArrayList<Square> allSqures) {
		AllSquares = allSqures;
	}

}
