package model;

import java.util.ArrayList;

public class Admin implements Actions{
	
	private String ID;
	private String password;
	
	Admin(String id,String pass){
		this.ID=id;
		this.password=pass;
	}
	
	/**
	 * Add Question to database 
	 * @param id,Question,possible answers, correct answer 
	 * @return if successful - true, else false*/
	
	public void AddQuestion(int idQu,String que,String ans, ArrayList<String> poss,boolean ismulti,QuestionTypes level) {
		Question q = new Question(idQu,que,poss,ans,level,ismulti);
		AddQuestion(q);
		
	}
	
	/**
	 * Remove Question from database 
	 * @param id
	 * @return if successful - true, else false*/
	
	public boolean RemoveQuestion(int idQu) {
		return SysData.RemoveQuestion(idQu);
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean AddQuestion(Question q) {
		return SysData.AddQuestion(q);
	}

}
