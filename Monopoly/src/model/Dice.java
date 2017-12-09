package model;

import java.util.Random;

public class Dice {
	private static final int[] numbers={1,2,3,4,5,6};
	private static int status;
	
	Dice(){
		this.status=0;
	}
	
	/**
	 * Randomly pick a number between 1-6
	 *@return number betweeen 1-6
	 * */
	
	public static int Roll() {
		setStatus(1);
		int rnd = new Random().nextInt(numbers.length-1);
		setStatus(0);
	    return numbers[rnd]; 
	}

	public static int[] getNumbers() {
		return numbers;
	}

	public static int getStatus() {
		return status;
	}

	public static void setStatus(int status) {
		status = status;
	}

}
