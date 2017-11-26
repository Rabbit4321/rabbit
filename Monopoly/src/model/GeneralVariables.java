package model;

public class GeneralVariables {

	private static int NumSquaresInGame = 40;
	
	private static int NumDiceInGame = 2;
	
	private static int NumDisqualificationsForJail = 3;

	public static int getNumSquaresInGame() {
		return NumSquaresInGame;
	}

	public static void setNumSquaresInGame(int numSquaresInGame) {
		NumSquaresInGame = numSquaresInGame;
	}

	public static int getNumDiceInGame() {
		return NumDiceInGame;
	}

	public static void setNumDiceInGame(int numDiceInGame) {
		NumDiceInGame = numDiceInGame;
	}

	public static int getNumDisqualificationsForJail() {
		return NumDisqualificationsForJail;
	}

	public static void setNumDisqualificationsForJail(int numDisqualificationsForJail) {
		NumDisqualificationsForJail = numDisqualificationsForJail;
	}

}
