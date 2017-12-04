package control;

import javax.security.auth.Subject;

import model.Question;
import model.SysData;

public class AdminControl {

	
	public static boolean addQuestion(Question q){//not finished
		return false;
		
	}
	
	public static boolean removeQuestion(Question q){ //not finished
		return false;
	}
	/**
	 * get all subjects for questions 
	 * */
	
	public static Subject[] getSubjects() {
		return SysData.getInstance().getSubjects();	
	}
}
