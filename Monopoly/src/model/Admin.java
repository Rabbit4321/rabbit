package model;

public class Admin {
	
	private String ID;
	private String password;
	
	Admin(String id,String pass){
		this.ID=id;
		this.password=pass;
	}
	
	//public boolean AddQuestionToGame(int idQu,String que,String ans, int GameId);
	
	//public boolean RemoveQuestionFromGame(int idQu,int GameId);
	
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
