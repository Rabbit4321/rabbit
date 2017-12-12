package model;

import java.util.ArrayList;




import control.MonopolyGame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import view.BoardGameController;
import view.BoardView;
import view.SquareView;

public class PlayerInGame extends Player{
	
	private double currentMoney;
	private int numOfDisqualifications;
	//more field of turn-> true/false
	private Square currentSquare;
	public boolean InJail;
	private ArrayList<Property> properties;
	private int gameNum;// Elinor added this -> for knowing the connection between a specific game to a specific player
	
	/*
	 * constructor 1
	 */
	public PlayerInGame(int playerNum, String nickname, Square currentSquare) {
		super(playerNum, nickname);
		
		this.currentMoney = 0;//לפני שהבנק מביא כסף
		this.numOfDisqualifications = 0;
		this.currentSquare = Board.getStart();//start square
		this.InJail=false;
		this.properties = new ArrayList<Property>();
	//gameNum = MonopolyGame.getCurrentGame();//Dont sure if its ok-Elinor
	}
	
	public int ChangeSqure(int squreNum)
	{
		int s;
		s = squreNum;
		
		if(s<0)
		{
			s+=GeneralVariables.getNumSquaresInGame();
		}
		
		if(s>= GeneralVariables.getNumSquaresInGame())
		{
			s-=GeneralVariables.getNumSquaresInGame();
		}
		 return s;
	}

	
	/**
	 * arriving to property square
	 * @param Property p
	 * @return question to the player if property Available, other - null
	 */
	public Question propertySquare(Property p)
	{
		Question q=null;
		if(p.getPropertyOwner()==null)
		{
			q = SysData.getInstance().propertyQuestion(p);
			
			
		
		}
	
			return q;
		
	}
	
	/**
	 * Dealing with the player answer (calling this method if property is available)
	 * @param p
	 * @param a
	 */
	public void propertyAvailable(Property p, boolean a)//להחזיר אם ענה נכון או לא על השאלה
	{
		if(a)
		{
		//right
		
		double price=0;
		if(p.getType().equals(PropertyTypes.Low_cost))
		{
			price=currentMoney * 0.95;
			Bank.ChargeMoneyFromPlayer(this, price);
	
			p.setPropertyOwner(this);
			p.setLastPropertyCost(price);
			this.properties.add(p);
		}
		if(p.getType().equals(PropertyTypes.Average))
		{
			price=currentMoney * 0.85;
			Bank.ChargeMoneyFromPlayer(this, price);
		
			p.setPropertyOwner(this);
			p.setLastPropertyCost(price);
			this.properties.add(p);
		}
		if(p.getType().equals(PropertyTypes.Expensive))
		{
			price=currentMoney * 0.75;
			Bank.ChargeMoneyFromPlayer(this, price);
		
			p.setPropertyOwner(this);
			p.setLastPropertyCost(price);
			this.properties.add(p);
		}
		}
		else
		{
		//wrong
		Bank.ChargeMoneyFromPlayer(this, p.getPropertyCost());
		
		p.setPropertyOwner(this);
		p.setLastPropertyCost(p.getPropertyCost());
		this.properties.add(p);
		plusDisq();
		}
	}
	
	/**
	 * Dealing with the unavailable property (calling this method if property is unavailable)
	 * @param p
	 * @param a - pay 15% last price - true OR buy 150% last price - false
	 */
	public void propertyUnAvailable(Property p, boolean a)//לשאול את השחקן אם הוא רוצה לשלם קנס או לקנות את הנכס
	{

				if(a)
				{
					transwerMoneyFromPlayerToPlayer(p.getPropertyOwner(), p.getLastPropertyCost()*0.85);
				
				}
				else
				{
					buyPropertyFromPlayer(p, p.getPropertyOwner(), p.getLastPropertyCost()*1.5);
				}
	}
	
	
	
	/**
	 * player comes to gotojail square
	 * @param 
	 * @return player goes out from jail - true, player goes to jail and waits because doesn't have money - false*/
	public boolean goToJailSquare()// קוראים למתודה הזאת אם רוצה לשלם 1000 ולצאת
	{
	//	setInJail(true);
		
		if(this.getNumOfDisqualifications()==3)
			threeDisq();	
	
		
		//		setInJail(false);
				if(Bank.ChargeMoneyFromPlayer(this, 100000))
				{
					
					return true;
				}
		
		
		return false;
	}
	

	
	/**
	 * arriving to luckyCard Square and giving the player questions to answer
	 * @param l
	 * return array of two questions for the player
	 */
	public Question[] luckyCardSquare(LuckyCard l)
	{
		
		return l.getQuestions();
	
	}
	
	/**
	 * Dealing with the player answers
	 * @param a1
	 * @param a2
	 * @param l
	 */
	public void luckyCardAnswers(boolean a1, boolean a2, LuckyCard l)//תשתמשו במתודה הזאת ותגידו למשתמש מה הרוויח/הפסיד בהתאם לתשובות שלו
	{
		if(a1 && a2)
		{
			Bank.GiveMoneyToPlayer(this, l.AmountForTwoQuestions());
			
		}
		if(!a1)
		{
			
			Bank.ChargeMoneyFromPlayer(this, 50000);
			this.plusDisq();
		}
		if(!a2)
		{
			Bank.ChargeMoneyFromPlayer(this, 25000);
		}
	}
	
	/**
	 * arriving to questionCard Square and giving the player question to answer
	 * @param q, sub-subject that the player chooses
	 * return Question for the player
	 */
	public Question questionCardSquare(QuestionCard q, Subjects sub)//קוראים למתודה הזאת אחרי ששואלים את המשתמש איזה תחום הוא רוצה
	{
		
	
		
		Question que = SysData.getInstance().CardQuestionQuestion(sub); // שאלה לפי התחום הנבחר שמקבלים מהמשתמש
	
		return que;
		
		
	}
	
	/**
	 * Dealing with the player answer
	 * @param a - answer
	 */
	public void questionCardAnswer(boolean a)//להחזיר אם ענה נכון או לא על השאלה
	{
		//סכומי הקנסות והפרסים יטופלו בהמשך
		double knas = 0;
		double price = 0;
		
		if(a)
		{
			Bank.GiveMoneyToPlayer(this, price);
		}
		else
		{
			Bank.ChargeMoneyFromPlayer(this, knas);
			plusDisq();
		}
	}
	
	
	
	
	public void exitGame()//תשאלו בוויו אם הוא בטוח ורק אז תקראו למתודה
	{
	
			returnProperties();

	}
	
	public void payToPlayerAndBank(double paymant)
	{
		currentMoney-=paymant;
	}
	
	public void receivingMoney(double paymant)
	{
		currentMoney+=paymant;
	}

	
	public boolean buyPropertyFromPlayer(Property pro, PlayerInGame pla, double amount)
	{
		if(transwerMoneyFromPlayerToPlayer(pla, amount))
		{
			pla.getProperties().remove(pro);
			this.getProperties().add(pro);
			pro.setPropertyOwner(this);
			
			return true;
		}
			
		return false;
	}
	
	/**
	 * checking if there is 3 Disqualifications
	 * @return player need to go to jail - true*/
	public void plusDisq()
	{
		this.numOfDisqualifications++;
		if(this.numOfDisqualifications==3)
		{
			goToJailSquare();
		}
	}

	/**
	 * dealing with player with 3 Disqualifications
	 */
	public void threeDisq()
	{
		
			this.numOfDisqualifications=0;
	
	}
	
	public void minusDisq()
	{
		this.numOfDisqualifications--;
	}
	
	
	public boolean bankruptcy()
	{
		if(this.properties.isEmpty())
		{
			if(this.currentMoney<=0)
			{
				returnProperties();
				return true;
			}
		}
		else
		{
			if(this.currentMoney<=-100000)
			{
				returnProperties();
				return true;
			}
		}
		
		
		return false;
	}
	
	public void returnProperties()
	{
		for(int i=0; i<this.properties.size(); i++)
		{
			this.properties.get(i).setPropertyOwner(null);
		}
	}
 
	public double playerValue()
	{
		int value = 0;
		
		for(int i=0; i<this.properties.size(); i++)
		{
			value+=this.properties.get(i).getPropertyCost();
		}
		value+=this.currentMoney;
		return value;
	}

	/**
	 * 
	 * @param q
	 * @return true if player answerd correct , false - other
	 */
	public boolean answerResult(Question q)
	{
		return false;
	}
	
	
	public boolean transwerMoneyFromPlayerToPlayer(PlayerInGame p, double amount)
	{
		if((p.getCurrentMoney()-amount) > -100000) {
			p.payToPlayerAndBank(amount);
			p.receivingMoney(amount);
			return true;
		}
		return false;
	}
		
	public double getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(double currentMoney) {
		this.currentMoney = currentMoney;
	}

	public int getNumOfDisqualifications() {
		return numOfDisqualifications;
	}

	public void setNumOfDisqualifications(int numOfDisqualifications) {
		this.numOfDisqualifications = numOfDisqualifications;
	}

	public Square getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}

	public boolean isInJail() {
		return InJail;
	}

	public void setInJail(boolean inJail) {
		InJail = inJail;
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}

	public int getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}

	
	

	
}
