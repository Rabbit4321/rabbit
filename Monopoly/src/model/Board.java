package model;

import java.util.ArrayList;

public class Board {
	private ArrayList<Square> AllSquares=new ArrayList<Square>(GeneralVariables.getNumSquaresInGame());
	
	Board(){
		
	}

	public ArrayList<Square> getAllSquares() {
		return AllSquares;
	}

	public void setAllSquares(ArrayList<Square> allSqures) {
		AllSquares = allSqures;
	}

}
