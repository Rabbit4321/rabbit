package view;

public class SquareView {
	
	private int num;
	private int x;
	private int y;
	
	public SquareView(int num,int x,int y) {
		this.num= num;
		this.x= x;
		this.y= y;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
