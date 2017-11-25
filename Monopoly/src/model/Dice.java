package model;

public class Dice {
	private static final int[] numbers={1,2,3,4,5,6};
	private String status; //rolling or not
	
	//public int Roll();

	public static int[] getNumbers() {
		return numbers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
