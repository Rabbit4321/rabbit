package model;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Question {
	private int id;
	private String team;
	public String text;
	private int difficulty;
	private boolean isMultipleChoice;
	//private HashMap<String, Boolean> answers = new HashMap<String, Boolean>();
	private ArrayList<Object> answers = new ArrayList<Object>();
	private ArrayList<Subjects> tags = new ArrayList<Subjects>();

	
	Question(int id, String team, String text, int diff, boolean isMulti, 
			ArrayList<Object> answers, ArrayList<Subjects> tags){
		this.id=id;
		this.team=team;
		this.text=text;
		this.difficulty=diff;
		this.isMultipleChoice=isMulti;
		this.answers=answers;
		this.tags=tags;
	}
	
	/*
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
*/

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public ArrayList<Object> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Object> answers) {
		this.answers = answers;
	}

	public boolean isMultipleChoice() {
		return isMultipleChoice;
	}


	public void setMultipleChoice(boolean isMultipleChoice) {
		this.isMultipleChoice = isMultipleChoice;
	}




	public ArrayList<Subjects> getTags() {
		return tags;
	}


	public void setTags(ArrayList<Subjects> tags) {
		this.tags = tags;
	}
	
	

	
	
	
	
	
	
	
}
