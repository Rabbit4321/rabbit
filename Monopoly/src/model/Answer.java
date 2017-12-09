package model;

public class Answer {

	private String text;
	private boolean isCorrect;
	public Answer(String text, boolean isCorrect) {
		super();
		this.text = text;
		this.isCorrect = isCorrect;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
}
