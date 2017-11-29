package model;

import java.util.Random;

public class LuckyCard extends Square{
	private int LowestAmountForTwoQuestions = 10000;
	private int HighestAmountForTwoQuestions = 250000;
	private Question [] questions= new Question[GeneralVariables.getNumQuestionsInLuckyCard()];
	
	LuckyCard(){
		super();
	//	setQuestions(SysData.getInstance().luckyCardQuestions()); 
	}
	public boolean IsPlayerAnswerIsCorrect() {
		return false;
	}
	/**
	 * Use this function if the player answers correct in both questions
	 * @return money reward
	 * */
	
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
	public Question [] getQuestions() {
		return questions;
	}
	public void setQuestions(Question [] questions) {
		this.questions = questions;
	}

}
