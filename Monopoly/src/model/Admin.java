package model;

import java.util.ArrayList;



public class Admin implements Actions{
	
	private String ID;
	private String password;
	
	public Admin(){
		this.ID="1";
		this.password="1";
	}
	
	/**
	 * Add Question to database 
	 * @param id,Question,possible answers, correct answer 
	 * @return if successful - true, else false*/
	//int id, String team, String text, int diff, boolean isMulti,ArrayList<Answer> answers, ArrayList<Subjects> tags
	public void AddQuestion(int idQu,String que,String team, ArrayList<Answer> poss,int diff,boolean ismulti, ArrayList<Subjects> tags) {
		Question q = new Question(idQu,team,que,diff,ismulti,poss,tags);
		AddQuestion(q);
		
	}
	
	/**
	 * Remove Question from database 
	 * @param id
	 * @return if successful - true, else false*/
	
	public boolean RemoveQuestion(Question q) {
		return SysData.RemoveQuestion(q);
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
		return false;
	//	throw new NotImplementedException();
		//TODO BOM! fix the call to SysData
		//return SysData.AddQuestion(q);
	}

}
