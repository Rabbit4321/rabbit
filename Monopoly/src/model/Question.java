package model;

import java.util.ArrayList;

public class Question {
	private int numQue;
	private String Question;
	private ArrayList<String> possibleAnswers= new ArrayList<String>(3);
	private String CorrectAnswer;
	private QuestionTypes level;
	Question(int num, String q, ArrayList<String> ans,String ansCorr, QuestionTypes level){
		this.numQue=num;
		this.Question=q;
		this.possibleAnswers=ans;
		this.CorrectAnswer=ansCorr;
		this.setLevel(level);
	}
	public boolean replacePossibleAnswer(String newAnswer, String existAnswer)
	{
		if(!possibleAnswers.contains(newAnswer))
		{
			this.possibleAnswers.remove(existAnswer);
			this.possibleAnswers.add(newAnswer);
			return true;
		}
		return false;
	}
	public int getNumQue() {
		return numQue;
	}
	public void setNumQue(int numQue) {
		this.numQue = numQue;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public ArrayList<String> getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(ArrayList<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	public String getCorrectAnswer() {
		return CorrectAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}
	public QuestionTypes getLevel() {
		return level;
	}
	public void setLevel(QuestionTypes level) {
		this.level = level;
	}

}
