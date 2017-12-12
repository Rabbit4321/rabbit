package control;



import java.util.ArrayList;

import javax.security.auth.Subject;

import model.Admin;
import model.Answer;
import model.Question;
import model.SysData;
import model.Subjects;

public class AdminControl {
	
	private static Admin a= new Admin(); // not supposed to be here - just for trying

	
	public static boolean addQuestion(int id, String team, String text, int diff, boolean isMulti,Answer ans1,Answer ans2,Answer ans3,Answer ans4, ArrayList<String> tags){//not finished
	 ArrayList<Subjects> sub = new ArrayList<Subjects>();
	 for(String s : tags) {
		 sub.add(Subjects.valueOf(s));
	 }
	 ArrayList<Answer> answers = new ArrayList<Answer>();
	 answers.add(ans1);
	 answers.add(ans2);
	 answers.add(ans3);
	 answers.add(ans4);
	 
	 a.AddQuestion(id, null, text, answers, diff, isMulti, sub);
	 return true;
		
	}
	
	public static boolean removeQuestion(Question q){ //not finished
		return false;
	}
	
	
	public static boolean updateQuestion(Question q){ //not finished
		return false;
	}
	
	
	
	/**
	 * get all subjects for questions 
	 * */
	
	public static Subjects[] getSubjects() {
		return SysData.getInstance().getSubjects();	
	}
	
	/**
	 * check if Admin
	 * */
	public static boolean CheckIfAdmin(String id, String pass) {

		if(a.getID().equals(id) && a.getPassword().equals(pass))
			return true;
		return false;
	}
	/**
	 * create answer
	 * */
	public static Answer CreateAns(String text, boolean isCorrect) {
		Answer ans = new Answer (text,isCorrect);
		return ans;
	}
}
