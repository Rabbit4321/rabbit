package model;

import java.util.ArrayList;

public class Board {
	private ArrayList<Square> AllSquares=new ArrayList<Square>(GeneralVariables.getNumSquaresInGame());
	
	/**
	 * Contractor
	 * */
	Board(){
		
	}
	
	/**
	 * restart the board and locate any square in her place (notice: 'Go to jail','Free parking','Jail','Start' are already defined in specific place
	 * @param list of squares*/
	
	public void RestartBoard(ArrayList<Square> sq) {
	/**TODO*/
		
	}

	public ArrayList<Square> getAllSquares() {
		return AllSquares;
	}

	public void setAllSquares(ArrayList<Square> allSqures) {
		AllSquares = allSqures;
	}

}
