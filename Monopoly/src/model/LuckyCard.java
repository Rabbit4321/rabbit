package model;

import java.util.Random;

public class LuckyCard extends Square{
	private int LowestAmountForTwoQuestions = 10000;
	private int HighestAmountForTwoQuestions = 250000;
	
	LuckyCard(){
		
	}
	public boolean IsPlayerAnswerIsCorrect() {
		return false;
	}
	public int AmountForTwoQuestions() {
		Random rand = new Random();
		return rand.nextInt(getHighestAmountForTwoQuestions()) + getLowestAmountForTwoQuestions();
	}
	public int getHighestAmountForTwoQuestions() {
		return HighestAmountForTwoQuestions;
	}
	public void setHighestAmountForTwoQuestions(int highestAmountForTwoQuestions) {
		HighestAmountForTwoQuestions = highestAmountForTwoQuestions;
	}
	public int getLowestAmountForTwoQuestions() {
		return LowestAmountForTwoQuestions;
	}
	public void setLowestAmountForTwoQuestions(int lowestAmountForTwoQuestions) {
		LowestAmountForTwoQuestions = lowestAmountForTwoQuestions;
	}

}
