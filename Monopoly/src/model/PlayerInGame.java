package model;

import java.util.ArrayList;

public class PlayerInGame extends Player{
	private int playerNum;
	private int currentMoney;
	private int numOfDisqualifications;
	private Square currentSquare;
	private ArrayList<Property> properties;
	
	public PlayerInGame(int playerNum, Square currentSquare) {
		super();
		this.playerNum = playerNum;
		this.currentMoney = 0;
		this.numOfDisqualifications = 0;
		this.currentSquare = currentSquare;//משבצת התחלה
		this.properties = new ArrayList<Property>();
	}
	
	
	
	public void payToPlayerAndBank(int paymant)
	{
		currentMoney-=paymant;//הוספת בדיקות
	}
	
	public void receivingMoney(int paymant)
	{
		currentMoney+=paymant;//הוספת בדיקות
	}
	
	public boolean BuyProperty(Property p)
	{
		boolean answer=false;
		if(p.getPropertyOwner()!=null && (currentMoney-p.getPropertyCost())>=0)
		{
			
			//question
			
			
			if(answer)
			{
				//hanaha
			}
			else
			{
				currentMoney-=p.getPropertyCost();
				this.properties.add(p);
				
			//	p.setPropertyOwner((this.playerNum); לקיחת הלקוח לפני המספר שלו מהלקוחות הקיימים (סינגלטון)
				plusDisq();
			}
			
			
			
			return true;
		}
		else
		{
			//לשלם דמי שכירות לשחקן שבבעלותו הנכס בשווי של %15 ממחיר
			//הקנייה האחרון של הנכס, או לקנות אותו ממנו במחיר של %150 ממחיר הנכס האחרון.
		}
		
		
		return false;
	}
	
	public boolean sellProperty(Property p)
	{
		if(this.properties.contains(p))
		{
			currentMoney+=p.getPropertyCost();
			this.properties.remove(p);
		//	p.setPropertyOwner((this.playerNum); לקיחת הלקוח לפני המספר שלו מהלקוחות הקיימים (סינגלטון)
			
			return true;
		}
		
		
		return false;
	}
	
	public void plusDisq()
	{
		this.numOfDisqualifications++;
		if(this.numOfDisqualifications==3)
		{
			//go to jail
			this.numOfDisqualifications=0;
		}
	}
	
	public void minusDisq()
	{
		this.numOfDisqualifications--;
	}
	
	/**
	 * */
	
	public boolean BankRuptcy()
	{
		if(this.properties.isEmpty())
		{
			if(this.currentMoney<=0)
				return true;
		}
		else
		{
			if(this.currentMoney<=-100000)
				return true;
		}
		
		
		return false;
	}

}
