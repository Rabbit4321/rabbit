package model;


public class Square {
	private int num;
	private TypeSquares type = null;
	
	public Square() {
		super();
	}
	/*
	 * full constructor
	 */
	public Square(int num,TypeSquares type){
		this.num = num;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public TypeSquares getType() {
		return type;
	}

	public void setType(TypeSquares type) {
		this.type = type;
	}

}
