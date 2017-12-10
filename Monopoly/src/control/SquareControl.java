package control;

import model.LuckyCard;
import model.Player;
import model.Property;
import model.QuestionCard;
import model.Square;
import model.TypeSquares;

public class SquareControl {
	
	public static boolean insertPlayerToSquare (Player p, Square s){
		return false;
	}//still not finished
	
	public static boolean  movePlayerFromSquare(Player p, Square s){
		return false;
	}//////still not finished
	public static void propertySquare(int numSquare)
	{
	/*	if(currentMoney-p.getPropertyCost()>=0)
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
				
				Question q = SysData.getInstance().propertyQuestion(p);
				
				if(answerResult(q))
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
				transwerMoneyFromPlayerToPlayer(p.getPropertyOwner(), p.getLastPropertyCost()*0.85);
			
			
			}
			else
			{
				buyPropertyFromPlayer(p, p.getPropertyOwner(), p.getLastPropertyCost()*1.5);
			}
		}
		}*/
	}
	public static void luckyCardSquare(int numSquare)
	{
		/*
		boolean check1 = false;
		boolean check2 = false;
				
		//first que
		check1= answerResult(l.getQuestions()[0]); //תוצאת מענה על שאלה בינונית
		
		//second que
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
		*/
	}
	
	public static void questionCardSquare(int numSquare)
	{
	/*	Subjects sub = null; //נושא שהשחקן בוחר
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
		}*/
	}

}
