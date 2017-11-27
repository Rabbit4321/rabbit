package model;

public class GeneralVariables {

	private static int NumSquaresInGame = 40;
	
	private static int NumDiceInGame = 2;
	
	private static int NumDisqualificationsForJail = 3;
	
	private static int NumOfTurnsInGame = 50;
	
	private static int NumOfLuckyCard = 6;
	
	private static int NumOfQuestionCard = 7;
	
	private static int numQuestionsInLuckyCard =2 ;

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

	public static int getNumOfTurnsInGame() {
		return NumOfTurnsInGame;
	}

	public static void setNumOfTurnsInGame(int numOfTurnsInGame) {
		NumOfTurnsInGame = numOfTurnsInGame;
	}

	public static int getNumOfLuckyCard() {
		return NumOfLuckyCard;
	}

	public static void setNumOfLuckyCard(int numOfLuckyCard) {
		NumOfLuckyCard = numOfLuckyCard;
	}

	public static int getNumOfQuestionCard() {
		return NumOfQuestionCard;
	}

	public static void setNumOfQuestionCard(int numOfQuestionCard) {
		NumOfQuestionCard = numOfQuestionCard;
	}

	public static int getNumQuestionsInLuckyCard() {
		return numQuestionsInLuckyCard;
	}

	public static void setNumQuestionsInLuckyCard(int numQuestionsInLuckyCard) {
		GeneralVariables.numQuestionsInLuckyCard = numQuestionsInLuckyCard;
	}

}
