package view;



import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Bank;
import model.LuckyCard;
import model.Property;
import model.PropertyTypes;
import model.Question;
import model.QuestionCard;
import model.Subjects;
import model.SysData;

public class PlayerInGameView {
	private int playerNum;
	private SquareView currentSquare;
	private int game;
	
	public PlayerInGameView(int playerNum,SquareView currentSquare,int game) {
		this.setPlayerNum(playerNum);
		this.currentSquare= currentSquare;
		this.game =game;
	//	System.out.println(playerNum  + " " + currentSquare.getNum() +" "+ game);
	}
	public void ChangeSquareViews(SquareView s) {
	//	hundleMovingThePlayer(s);
		currentSquare = s;
	}
	
	public SquareView getCurrentSquare() {
		return currentSquare;
	}
	/**
	 * arriving to property square
	 * @param Property p
	 */
	public void propertySquare(Property p)
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
	public void luckyCardSquare(LuckyCard l)
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
	
	public void questionCardSquare(QuestionCard q)
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

	public void hundleMovingThePlayer(SquareView sqNew){
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
				
				//change in x
				final Timeline timeline1 = new Timeline();
			//	timeline1.setCycleCount(1);
				
			//	SquareView  s = sqNew;
			//	System.out.println( "Square "+s.getX() +" "+s.getY());
			//	System.out.println(currentSquare.getNum() + " " + currentSquare.getX() + " "+currentSquare.getY());
			//	System.out.println(BoardGameController.getPlayer().xProperty());
			//	final KeyValue kv = new KeyValue(BoardGameController.getPlayer().xProperty(), s.getX() - currentSquare.getX());//-> don't sure what it means
			//	final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);// means in how much period of time the rabbit will get to the cordinates i define him
			//	timeline1.getKeyFrames().addAll(kf);
				
				
				//change in y
			//	final Timeline timeline2 = new Timeline();
			//	timeline2.setCycleCount(1);
				
			//	final KeyValue kv1 = new KeyValue(BoardGameController.getPlayer().yProperty(), currentSquare.getY() - s.getY());
			//	final KeyFrame kf1 = new KeyFrame(Duration.millis(1500), kv1);// means in how much period of time the rabbit will get to the cordinates i define him

		//		timeline2.getKeyFrames().addAll(kf1);
				
				
		//		SequentialTransition sequence = new SequentialTransition(timeline1, timeline2);
		//		sequence.play();*/
	}
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	
	
	 
	

}
