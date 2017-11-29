package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import org.json.simple.JSONArray;




public class SysData implements Serializable{
	
	//private static final long serialVersionUID
	
	private static ArrayList<Question> AllQuestions= new ArrayList<Question>();
	private static ArrayList<Player> players= new ArrayList<Player>();
	private static ArrayList<Game> games = new ArrayList<Game>();

	private static ArrayList<Property> properties = new ArrayList<Property>();

	private static SysData instance;
	
	
	/**
	 * singelton
	 */
	public static SysData getInstance()
	{
		if (instance == null)
			instance = new SysData();
		return instance;
	}
	
	
	

	
	/**
	 * all the questions that their level is like the property type
	 * @param type of the property
	 * @return arraylist of questions
	 */
	public ArrayList<Question> questionsAcordingToType(PropertyTypes type)
	{
		int queType = 0;
		
		
	//	if(type.equals(PropertyTypes.Low_cost))
	//		queType=0;
		if(type.equals(PropertyTypes.Average))
			queType=1;
		if(type.equals(PropertyTypes.Expensive))
			queType=2;
		
		ArrayList<Question> questions= new ArrayList<Question>();
		
		
			for(int i=0; i<SysData.getInstance().getAllQuestions().size(); i++)
			{
				if(SysData.getInstance().getAllQuestions().get(i).getDifficulty()==queType)
					questions.add(SysData.getInstance().getAllQuestions().get(i));
			}
		
		
		return questions;
	}
	
	
	
	/**
	 * all the questions that contains the Subject 
	 * @param Subjects sub
	 * @return arraylist of questions
	 */
	public ArrayList<Question> questionsAcordingToSubject(Subjects sub)
	{
	
		
		ArrayList<Question> questions= new ArrayList<Question>();
		
		
			for(int i=0; i<SysData.getInstance().getAllQuestions().size(); i++)
			{
				if(SysData.getInstance().getAllQuestions().get(i).getTags().contains(sub))
					questions.add(SysData.getInstance().getAllQuestions().get(i));
			}
		
		
		return questions;
	}
	
	
	
	
	public Question propertyQuestion(Property p)
	{
		ArrayList<Question> questions=questionsAcordingToType(p.getProType());
		
		Random rand = new Random();
		int  n = rand.nextInt(questions.size());
		
		return questions.get(n);
	}
	
	
	
	public Question questionCardQuestion(Subjects sub)
	{
		ArrayList<Question> questions=questionsAcordingToSubject(sub);
		
		Random rand = new Random();
		int  n = rand.nextInt(questions.size());
		
		return questions.get(n);
	}

	
	
	
	
	
	
	
	
	
	private void initProperties(){

		
		JSONParser parser = new JSONParser();

        try {
        	Object obj = parser.parse(new FileReader("properties.json"));
        	JSONArray fileContent = (JSONArray) obj;
			Iterator<JSONObject> fileIterator = fileContent.iterator();
			while (fileIterator.hasNext())
			{
            JSONObject jsonObject = (JSONObject) fileIterator.next();
				
				
				String name = (String)jsonObject.get("name");
				double cost = (double)jsonObject.get("cost");
				Cities city = (Cities)jsonObject.get("city");
			
			
				properties.add(new Property(name, cost, city));
				
			}
	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	private void initQuestions(){

		
		JSONParser parser = new JSONParser();

        try {
        	Object obj = parser.parse(new FileReader("questions.json"));
        	JSONArray fileContent = (JSONArray) obj;
			Iterator<JSONObject> fileIterator = fileContent.iterator();
			while (fileIterator.hasNext())
			{
            JSONObject jsonObject = (JSONObject) fileIterator.next();
				
				int id= (int)jsonObject.get("id");
				String team = (String)jsonObject.get("team");
				String text = (String)jsonObject.get("text");
				int difficulty= (int)jsonObject.get("difficulty");
				boolean isMultipleChoice=(boolean)jsonObject.get("isMultipleChoice");
				
				JSONArray answers= (JSONArray)jsonObject.get("answers");
				ArrayList<String> a= new ArrayList<String>();
				Iterator<String> iterator1 = answers.iterator();
				while (iterator1.hasNext()) 
				{
					
					a.add(iterator1.next());
					
					
				}
				
				JSONArray tags= (JSONArray)jsonObject.get("tags");
				ArrayList<String> t= new ArrayList<String>();
				Iterator<String> iterator2 = tags.iterator();
				while (iterator2.hasNext()) 
				{
					t.add(iterator2.next());
					
				}
			
			
				if(validQuestion(id, team, text, difficulty, isMultipleChoice, (ArrayList<Object>)answers, (ArrayList<Subjects>)tags))
				{
					AllQuestions.add(new Question(id, team, text, difficulty, isMultipleChoice, answers, tags));
				}
				
				
			}
	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	public static boolean validQuestion(int id, String team, String text, int diff, boolean isMulti, 
			ArrayList<Object> answers, ArrayList<Subjects> tags)
	{
		return false;
		//todo
	}
	
	
	public static boolean AddQuestion(Question q) {
		
		if(!AllQuestions.contains(q))
		{
			if(validQuestion(q.getId(), q.getTeam(), q.getText(), q.getDifficulty(), q.isMultipleChoice(), q.getAnswers(), q.getTags()))
			{
				
			
			AllQuestions.add(q);
			//write to json
			
			JSONObject obj = new JSONObject();
			obj.put("id", q.getId()+"");
			obj.put("team", q.getTeam()+"");
			obj.put("text", q.getText()+"");
			obj.put("difficulty", q.getDifficulty()+"");
			obj.put("isMultipleChoice", q.isMultipleChoice()+"");
			
			JSONArray list1 = new JSONArray();
			
			for(int i=0; i<=q.getAnswers().size(); i++)
			{
				list1.add(q.getAnswers().get(i));
			}
			
			obj.put("answers", list1);
			
			
			JSONArray list2 = new JSONArray();
			
			for(int i=0; i<=q.getTags().size(); i++)
			{
				list2.add(q.getTags().get(i));
			}
			
			obj.put("tags", list2);
			
			try (FileWriter file = new FileWriter("questions.json"))
			{
				
				
				file.write(obj.toString());
				file.flush();
				return true;
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			
			
			
		}
		
		
		return false;
	}
	
	
	
	public static boolean RemoveQuestion(Question q) {
		if(AllQuestions.contains(q))
		{
			AllQuestions.remove(q);
			//remove from json
			return true;
		}
		
		
		return false;
	}
	
	public static boolean AddPlayer(Player p) {
	
		if(!players.contains(p))
		{
			players.add(p);
			
			return true;
		}
		return false;
	}
	
	public static boolean AddGame(Game g) {
		
		if(!games.contains(g))
		{
			games.add(g);
			
			return true;
		}
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
