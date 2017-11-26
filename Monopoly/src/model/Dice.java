package model;

import java.util.Random;

public class Dice {
	private static final int[] numbers={1,2,3,4,5,6};
	private int status; //rolling = 1 or not = 0
	
	Dice(){
		this.status=0;
	}
	
	/**
	 * Randomly pick a number between 1-6
	 *@return number betweeen 1-6
	 * */
	
	public int Roll() {
		setStatus(1);
		int rnd = new Random().nextInt(numbers.length);
		setStatus(0);
	    return numbers[rnd]; 
	}

	public static int[] getNumbers() {
		return numbers;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
