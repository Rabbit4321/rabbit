package model;

import java.util.ArrayList;

public class SysData {
	private static ArrayList<Question> AllQuestions= new ArrayList<Question>();
	private static ArrayList<Player> players= new ArrayList<Player>();
	private static ArrayList<Game> games = new ArrayList<Game>();
	
	
	
	public static boolean AddQuestion(Question q) {
		return false;
	}
	public static boolean RemoveQuestion(int idQ) {
		return false;
	}
	public static ArrayList<Question> getAllQuestions() {
		return AllQuestions;
	}
	public static void setAllQuestions(ArrayList<Question> allQuestions) {
		AllQuestions = allQuestions;
	}
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	public static void setPlayers(ArrayList<Player> players) {
		SysData.players = players;
	}
	public static ArrayList<Game> getGames() {
		return games;
	}
	public static void setGames(ArrayList<Game> games) {
		SysData.games = games;
	}
	

}
