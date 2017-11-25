package model;

public class Bank {
	
	private static final int StartAmountForPlayer=500000;
	private double Money= 10000000;

	public static int getStartAmountForPlayer() {
		return StartAmountForPlayer;
	}
	
	public boolean GiveMoneyToPlayer(Player p,double amount) {
		return false;
	}
	public boolean ChargeMoneyFromPlayer(Player p,double amount) {
		return false;
	}

}
