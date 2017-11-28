package model;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PlayerInGame extends Player{
	
	
	
	
	private double currentMoney;
	private int numOfDisqualifications;
	private int currentSquare;
//	private Square currentSquare;
	public boolean InJail;
	
	
	private ArrayList<Property> properties;
	
	public PlayerInGame(int playerNum, String nickname, Square currentSquare) {
		super(playerNum, nickname);
		
		this.currentMoney = 0;//לפני שהבנק מביא כסף
		this.numOfDisqualifications = 0;
		this.currentSquare = 0;//משבצת התחלה
		this.InJail=false;
		
		this.properties = new ArrayList<Property>();
	}
	
	public void ChangeSqure(int squreNum)
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
		
		this.currentSquare=s;
		
	}
	
	
	public void propertySquare(Property p)
	{
		if(currentMoney-p.getPropertyCost()>=0)
		{
		if(p.getPropertyOwner()==null)
		{
			
			 int n = JOptionPane.showConfirmDialog(
			            null,
			            "Would you like buy this property?",
			            "An Inane Question",
			            JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				//question
				//right
				
				double price=0;
				if(p.getType().equals(PropertyTypes.Low_cost))
				{
					price=currentMoney * 0.95;
					Bank.ChargeMoneyFromPlayer(this, price);
				//	currentMoney-=price;
					p.setPropertyOwner(this);
					p.setLastPropertyCost(price);
					this.properties.add(p);
				}
				if(p.getType().equals(PropertyTypes.Average))
				{
					price=currentMoney * 0.85;
					Bank.ChargeMoneyFromPlayer(this, price);
					//currentMoney-=price;
					p.setPropertyOwner(this);
					p.setLastPropertyCost(price);
					this.properties.add(p);
				}
				if(p.getType().equals(PropertyTypes.Expensive))
				{
					price=currentMoney * 0.75;
					Bank.ChargeMoneyFromPlayer(this, price);
				//	currentMoney-=price;
					p.setPropertyOwner(this);
					p.setLastPropertyCost(price);
					this.properties.add(p);
				}
				
				//wrong
				Bank.ChargeMoneyFromPlayer(this, p.getPropertyCost());
				//currentMoney-=p.getPropertyCost();
				p.setPropertyOwner(this);
				p.setLastPropertyCost(p.getPropertyCost());
				this.properties.add(p);
				plusDisq();
			}
		}
		else //נכס תפוס
		{
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "pay 15% last price - yes OR buy 150% last price - no",
		            "An Inane Question",
		            JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			{
				
			
			
			
			}
			else
			{
				
			}
		}
		}
	}
	
	
	/**
	 * player comes to jail square
	 * @return player goes out from jail - true, player goes to jail and waits - false*/
	public boolean goToJailSquare()
	{
		int n = JOptionPane.showConfirmDialog(
	            null,
	            "pay 100000 - yes OR wait - no",
	            "An Inane Question",
	            JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION)
		{
			
				if(Bank.ChargeMoneyFromPlayer(this, 100000))
					return true;
		}
		
		return false;
	}
	
	
	public void luckyCardSquare(LuckyCard l)
	{
		boolean check1=false;
		boolean check2=false;
		
		
		
		//first que
		
		
		//second que
		
		
		
		
		if(check1 && check2)
		{
			Bank.GiveMoneyToPlayer(this, l.AmountForTwoQuestions());
			//this.currentMoney+=l.AmountForTwoQuestions();
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
		
	}
	
	//הגעתי ללך לכלא
	
	public boolean exitGame()
	{
		int n = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to exit?",
	            "An Inane Question",
	            JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION)
		{
			returnProperties();
				return true;
		}
		return false;
	}
	
	
	//יציאה מהמשחק
	
	//גלגול קוביות
	
	
	public void payToPlayerAndBank(double paymant)
	{
		currentMoney-=paymant;//הוספת בדיקות
	}
	
	public void receivingMoney(double paymant)
	{
		currentMoney+=paymant;//הוספת בדיקות
	}
	
	
/*	public boolean sellProperty(Property p)
	{
		if(this.properties.contains(p))
		{
			currentMoney+=p.getPropertyCost();
			this.properties.remove(p);
		
			
			return true;
		}
		
		
		return false;
	}*/
	
	public void plusDisq()
	{
		this.numOfDisqualifications++;
		
	}
	
	
	/**
	 * cheking if there is 3 Disqualifications
	 * @return player need to go to jail - true*/
	public boolean howManyDisq()
	{
		if(this.numOfDisqualifications==3)
		{
			//go to jail
			
			this.numOfDisqualifications=0;
			return true;
		}
		return false;
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
//מתודת שחרור נכסים בעת פשיטת רגל 
	
	
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

	public int getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(int currentSquare) {
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
	
	
	//ערך כללי של רכוש
}
