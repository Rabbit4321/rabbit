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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class SysData implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
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
	
	
	public ArrayList<Question> questionsAcordingToLevel(int level)
	{
		
		
		ArrayList<Question> questions= new ArrayList<Question>();
		
		
			for(int i=0; i<SysData.getInstance().getAllQuestions().size(); i++)
			{
				if(SysData.getInstance().getAllQuestions().get(i).getDifficulty()==level)
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
	
	
	
	public Question CardQuestionQuestion(Subjects sub)
	{
		ArrayList<Question> questions=questionsAcordingToSubject(sub);
		
		Random rand = new Random();
		int  n = rand.nextInt(questions.size());
		
		return questions.get(n);
	}

	public Question [] luckyCardQuestions()
	{
		Question[] questions = new Question[2];
		
		ArrayList<Question> questions1 = questionsAcordingToLevel(1); //בינוני
		ArrayList<Question> questions2 = questionsAcordingToLevel(2); //קשה
		
		
		Random rand = new Random();
		int  n1 = rand.nextInt(questions1.size());
		int  n2 = rand.nextInt(questions2.size());
		
		questions[0] = questions1.get(n1);
		questions[1] = questions1.get(n2);
		
		return questions;
	}
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public void initProperties(){

	
		JSONParser parser = new JSONParser();

        try {
        	
        	
        	
        	
        	Object obj = parser.parse(new FileReader("Data/properties.json"));
        	JSONObject jsonObject = (JSONObject) obj;
        	JSONArray fileContent = (JSONArray) jsonObject.get("property");
			Iterator<JSONObject> fileIterator = fileContent.iterator();
			while (fileIterator.hasNext())
			{
				
				
				
				
            JSONObject jsonObj = (JSONObject) fileIterator.next();
				System.out.println(jsonObj);
				
				String name = (String)jsonObj.get("name");
				System.out.println(name);
				
				
				String d = (String)jsonObj.get("cost");
				
				double cost = Double.parseDouble(d);

				System.out.println(cost);
				Cities city = Cities.valueOf((String)jsonObj.get("city"));
				System.out.println(city);
			
			
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
	
	
	
	
	
	
	
	public void initQuestions(){

		
		JSONParser parser = new JSONParser();

        try {
        	

        	Object obj = parser.parse(new FileReader("Data/questions.json"));
        	JSONObject jsonObject = (JSONObject) obj;
        	JSONArray fileContent = (JSONArray) jsonObject.get("questions");
			Iterator<JSONObject> fileIterator = fileContent.iterator();
			while (fileIterator.hasNext())
			{
				
				
				
				
            JSONObject jsonObj = (JSONObject) fileIterator.next();
				System.out.println(jsonObj);
				
				
				
				long id=(long) jsonObj.get("id");
				System.out.println(id);
				
				String team = (String)jsonObj.get("team");
				System.out.println(team);
				
				String text = (String)jsonObj.get("text");
				System.out.println(text);
				
				long difficulty= (long)jsonObj.get("difficulty");
				System.out.println(difficulty);
				
				boolean isMultipleChoice=(boolean) jsonObj.get("isMultipleChoice");
				System.out.println(isMultipleChoice);
				
				
				JSONArray answers= (JSONArray)jsonObj.get("answers");
				ArrayList<Answer> a= new ArrayList<Answer>();
				Iterator<JSONObject> iterator1 = answers.iterator();
				while (iterator1.hasNext()) 
				{
					
					JSONObject jsonObj1 = (JSONObject) iterator1.next();
					
					String text1 = (String)jsonObj1.get("text");
					System.out.println(text1);
					
					boolean isCorrect=(boolean)jsonObj1.get("isCorrect");
					System.out.println(isCorrect);
					
					Answer ans = new Answer(text1,isCorrect);
					a.add(ans);
					
					
				}
	
				JSONArray tags= (JSONArray)jsonObj.get("tags");
				ArrayList<Subjects> t= new ArrayList<Subjects>();
				Iterator<String> iterator2 = tags.iterator();
				while (iterator2.hasNext()) 
				{
					Subjects s=Subjects.valueOf((String)iterator2.next());
					System.out.println(s);
					t.add(s);
				
					
				
				
				
					
				}
				
				
				
			}
        	
        	
        	
        	/*
        	
				
				int id= (int)jsonObject.get("id");
				String team = (String)jsonObject.get("team");
				String text = (String)jsonObject.get("text");
				int difficulty= (int)jsonObject.get("difficulty");
				boolean isMultipleChoice=(boolean)jsonObject.get("isMultipleChoice");
				
				JSONArray answers= (JSONArray)jsonObject.get("answers");
				ArrayList<Answer> a= new ArrayList<Answer>();
				Iterator<String> iterator1 = answers.iterator();
				while (iterator1.hasNext()) 
				{

					Answer ans = new Answer(iterator1.next(), Boolean.parseBoolean(iterator1.next()));
					a.add(ans);
					
					
				}
				
				JSONArray tags= (JSONArray)jsonObject.get("tags");
				ArrayList<Subjects> t= new ArrayList<Subjects>();
				Iterator<String> iterator2 = tags.iterator();
				while (iterator2.hasNext()) 
				{
					t.add(Subjects.valueOf(iterator2.next()));
					
				}
			
			
				
				
				if(validQuestion(id, team, text, difficulty, isMultipleChoice, answers, tags))
				{
					AllQuestions.add(new Question(id, team, text, difficulty, isMultipleChoice, answers, tags));
				}
				
				
			*/
	
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
	
	
	
	/**
	 * checks validation according to json orders
	 * @param id
	 * @param team
	 * @param text
	 * @param diff
	 * @param isMulti
	 * @param answers
	 * @param tags
	 * @return
	 */
	public static boolean validQuestion(int id, String team, String text, int diff, boolean isMulti, 
			ArrayList<Answer> answers, ArrayList<Subjects> tags)
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
	
	
	public ArrayList<Property> getProperties()
	{
		return this.properties;
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
	
	/*
	public static void main(String[] args) {
		SysData.getInstance();
		getInstance().initProperties();
		getInstance().initQuestions();
	
	}*/
	

}
