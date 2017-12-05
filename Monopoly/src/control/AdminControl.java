package control;



import model.Question;
import model.SysData;
import model.Subjects;

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
	
	public static Subjects[] getSubjects() {
		return SysData.getInstance().getSubjects();	
	}
	public static void main(String[] args) {
		for (int i =0; i<AdminControl.getSubjects().length;i++) {
			System.out.println(AdminControl.getSubjects()[i].toString());
		}
	}
}
