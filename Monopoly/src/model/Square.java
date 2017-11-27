package model;


public class Square {
	private int num;
	private int NextSquare;
	private int preSquare;
	private TypeSquares type = null;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNextSquare() {
		return NextSquare;
	}

	public void setNextSquare(int nextSquare) {
		NextSquare = nextSquare;
	}

	public int getPreSquare() {
		return preSquare;
	}

	public void setPreSquare(int preSquare) {
		this.preSquare = preSquare;
	}

	public TypeSquares getType() {
		return type;
	}

	public void setType(TypeSquares type) {
		this.type = type;
	}

}
