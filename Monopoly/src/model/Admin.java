package model;

import java.util.ArrayList;

public class Admin {
	
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
	
	public boolean AddQuestion(int idQu,String que,String ans, ArrayList<String> poss,QuestionTypes level) {
		Question q = new Question(idQu,que,poss,ans,level);
		return SysData.AddQuestion(q);
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

}
