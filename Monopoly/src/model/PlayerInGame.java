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
	
	private int gameNum;
	private double currentMoney;
	private int numOfDisqualifications;
	private Square currentSquare;
	public boolean InJail;
	private ArrayList<Property> properties;
	
	/* I need : Find the current square the player is at in the game, and send also the type of the square*/
	
	/*
	 * constructor 1
	 */
	public PlayerInGame(int playerNum, String nickname, Square currentSquare) {
		
		super(playerNum, nickname);
		this.currentMoney = 0; /* before the bank is giving the players money*/
		this.numOfDisqualifications = 0;
		this.currentSquare = new Square(1,TypeSquares.START); /* Start square*/
		this.InJail=false;/* in the beginning of the game the player is not in jail(he is in the Start square*/
		this.properties = new ArrayList<Property>();/* now the Array is empty*/
		gameNum = MonopolyGame.getCurrentGame();/* give the number of last game that created(the newest game)*/
	}
	
	/**
	 * This method get a square number(the current number the player is at)
	 * return @param number of the new square the player is moving for
	 */
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
	 * arriving to property square -  This method is checking which property i it(cheap,average,expensive)
	 * @param Property p
	 */
	public void propertySquare(Property p)
	{
		if(currentMoney-p.getPropertyCost()>=0)
		{
		if(p.getPropertyOwner()==null)
		{
			System.out.println("You can buy this property -  do you want?");/* need to do a pop up of this question*/
			/* need to wait to the response of the player*/
			if(true) //if the response is positive
			{
				Question q = SysData.getInstance().propertyQuestion(p); // poll a Question for the player from the sysdata
				
				if(answerResult(q))//means the player answer right the question
				{	
				double price=0;
				/*get which property is that property(cheap,average,expensive)->according to the type the system will know
				 * how much the player need to pay*/
				 
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
				/*means the player answer the Question wrong so he don't have any discount on the property*/
				Bank.ChargeMoneyFromPlayer(this, p.getPropertyCost());
				
				p.setPropertyOwner(this);
				p.setLastPropertyCost(p.getPropertyCost());
				this.properties.add(p);
				plusDisq();
				}
			}
		}
		else /* the Property has a owner and the player need to pay him money*/
		{
		//	int n = JOptionPane.showConfirmDialog(null,"pay 15% last price - yes OR buy 150% last price - no","An Inane Question",JOptionPane.YES_NO_OPTION);
			// waiting the player to response the pop up
			if(true)//response positive
			{
				transwerMoneyFromPlayerToPlayer(p.getPropertyOwner(), p.getLastPropertyCost()*0.85);
			
			}
			else//response not positive
			{
				buyPropertyFromPlayer(p, p.getPropertyOwner(), p.getLastPropertyCost()*1.5);
			}
		}
		}
	}
	
	/**
	 * player comes to goToJail square
	 * @return player goes out from jail - true, player goes to jail and waits - false*/
	public boolean goToJailSquare()
	{
		setInJail(true);
		
		if(this.getNumOfDisqualifications()==3)
			threeDisq();	
		//int n = JOptionPane.showConfirmDialog(null,"pay 100000 - yes OR wait - no","An Inane Question",JOptionPane.YES_NO_OPTION);
		/* waiting to player response the pop up if he want to pay a bail to get out from jail*/
		if(true)//response positive - > means he go out from jail
		{
				setInJail(false);
				if(Bank.ChargeMoneyFromPlayer(this, 100000)) // the bank charge from player the money for bail
				{
					
					return true;
				}
		}
		
		return false;
	}

	public void luckyCardSquare(LuckyCard l)
	{
		boolean check1 = false;
		boolean check2 = false;
				
		/*first question*/
		check1= answerResult(l.getQuestions()[0]); //תוצאת מענה על שאלה בינונית
		
		/*second question*/
		check2= answerResult(l.getQuestions()[1]); //תוצאת מענה על שאלה קשה
		
		if(check1 && check2)
		{
			Bank.GiveMoneyToPlayer(this, l.AmountForTwoQuestions());
			
		}
		if(!check1)
		{
			
			Bank.ChargeMoneyFromPlayer(this, 50000);
			this.plusDisq();
		}
		if(!check2)
		{
			Bank.ChargeMoneyFromPlayer(this, 25000);
		}
		
	}
	
	public void questionCardSquare(QuestionCard q)
	{
		Subjects sub = null; //נושא שהשחקן בוחר
		double knas = 0;
		double price = 0;
		
		Question que = SysData.getInstance().CardQuestionQuestion(sub); //שאלה לפי התחום הנבחר
	
		if(answerResult(que))
		{
			Bank.GiveMoneyToPlayer(this, price);
		}
		else
		{
			Bank.ChargeMoneyFromPlayer(this, knas);
			plusDisq();
		}
	}
	
	public boolean exitGame()
	{
		//int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","An Inane Question",JOptionPane.YES_NO_OPTION);
		/*waiting the player to response the pop up for exiting the game*/
		if(true)//answered yes
		{
			returnProperties();
				return true;
		}
		return false;//answered no
	}
	
	public void payToPlayerAndBank(double paymant)
	{
		currentMoney-=paymant;// To Marina הוספת בדיקות
	}
	
	public void receivingMoney(double paymant)
	{
		currentMoney+=paymant;// To Marina הוספת בדיקות
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
	 * @return true if player answered correct , false - other
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
	
	 /* Getters & Setters*/	
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
	

	
}
