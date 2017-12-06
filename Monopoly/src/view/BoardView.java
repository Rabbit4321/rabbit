package view;

import java.util.ArrayList;

public class BoardView {
	
	private ArrayList<SquareView> squares;
	
	public ArrayList<SquareView> getSquares() {
		return squares;
	}

	public void setSquares(ArrayList<SquareView> squares) {
		this.squares = squares;
	}

	public BoardView(ArrayList<SquareView> sq) {
		this.squares = sq;
	}

}
