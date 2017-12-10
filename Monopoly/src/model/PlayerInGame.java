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
		
		this.currentMoney = 0;//���� ����� ���� ���
		this.numOfDisqualifications = 0;
		this.currentSquare = null;//����� �����
		this.InJail=false;
		this.properties = new ArrayList<Property>();
		gameNum = MonopolyGame.getCurrentGame();//Dont sure if its ok-Elinor
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
	 */
	public void propertySquare(Property p)
	{
		if(currentMoney-p.getPropertyCost()>=0)
		{
		if(p.getPropertyOwner()==null)
		{
			
			// int n = JOptionPane.showConfirmDialog(null,"Would you like buy this property?", "An Inane Question",JOptionPane.YES_NO_OPTION);
			if(true)
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
		else //��� ����
		{
		//	int n = JOptionPane.showConfirmDialog(null,"pay 15% last price - yes OR buy 150% last price - no","An Inane Question",JOptionPane.YES_NO_OPTION);
			if(true)
			{
				transwerMoneyFromPlayerToPlayer(p.getPropertyOwner(), p.getLastPropertyCost()*0.85);
			
			}
			else
			{
				buyPropertyFromPlayer(p, p.getPropertyOwner(), p.getLastPropertyCost()*1.5);
			}
		}
		}
	}
	
	/**
	 * player comes to gotojail square
	 * @return player goes out from jail - true, player goes to jail and waits - false*/
	public boolean goToJailSquare()
	{
		setInJail(true);
		
		if(this.getNumOfDisqualifications()==3)
			threeDisq();	
		//int n = JOptionPane.showConfirmDialog(null,"pay 100000 - yes OR wait - no","An Inane Question",JOptionPane.YES_NO_OPTION);
		if(true)
		{
				setInJail(false);
				if(Bank.ChargeMoneyFromPlayer(this, 100000))
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
				
		//first que
		check1= answerResult(l.getQuestions()[0]); //����� ���� �� ���� �������
		
		//second que
		check2= answerResult(l.getQuestions()[1]); //����� ���� �� ���� ���
		
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
		Subjects sub = null; //���� ������ ����
		double knas = 0;
		double price = 0;
		
		Question que = SysData.getInstance().CardQuestionQuestion(sub); //���� ��� ����� �����
	
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
		if(true)
		{
			returnProperties();
				return true;
		}
		return false;
	}
	
	public void payToPlayerAndBank(double paymant)
	{
		currentMoney-=paymant;//����� ������
	}
	
	public void receivingMoney(double paymant)
	{
		currentMoney+=paymant;//����� ������
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
	
	public void hundleMovingThePlayer(int numOfSteps){
		/*
		 * final Timeline timeline = new Timeline();
				timeline.setCycleCount(1);		//timeline.setAutoReverse(true);
				final KeyValue kv = new KeyValue(player.xProperty(), 300);
				final KeyValue kv2 = new KeyValue(player.yProperty(), player.yProperty().get());
				final KeyValue kv3 = new KeyValue(player.yProperty(), 500);
				final KeyFrame kf = new KeyFrame(Duration.millis(1500), kv);// means in how much period of time the rabbit will get to the cordinates i define him
				final KeyFrame kf2 = new KeyFrame(Duration.millis(1500), kv2);
			final KeyFrame kf3 = new KeyFrame(Duration.millis(2500), kv3);
				timeline.getKeyFrames().addAll(kf,kf2,kf3);
				timeline.play();
				*/
				//change in x
				final Timeline timeline1 = new Timeline();
				timeline1.setCycleCount(1/*Timeline.INDEFINITE*/);
				BoardView b = new BoardView();
				b.RestartBoardView();
				SquareView  s = new SquareView(40,580,380);
				BoardGameController.getPlayer();
				final KeyValue kv = new KeyValue(BoardGameController.getPlayer().xProperty(), s.getX() - b.getStart().getX());//-> don't sure what it means
				final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);// means in how much period of time the rabbit will get to the cordinates i define him
				timeline1.getKeyFrames().addAll(kf);
				
				
				//change in y
				final Timeline timeline2 = new Timeline();
				timeline2.setCycleCount(1/*Timeline.INDEFINITE*/);
				
				final KeyValue kv1 = new KeyValue(BoardGameController.getPlayer().yProperty(), b.getStart().getY() - s.getY());
				final KeyFrame kf1 = new KeyFrame(Duration.millis(1500), kv1);// means in how much period of time the rabbit will get to the cordinates i define him

				timeline2.getKeyFrames().addAll(kf1);
				
				
				SequentialTransition sequence = new SequentialTransition(timeline1, timeline2);
				sequence.play();
	}
	
	
}
