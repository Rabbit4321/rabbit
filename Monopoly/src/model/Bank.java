package model;

public class Bank {
	
	private static final int StartAmountForPlayer=500000;
	private double Money = 10000000;

	public static int getStartAmountForPlayer() {
		return StartAmountForPlayer;
	}
	/**
	 * give money to player
	 * @param player, amount of money to transfer
	 * @return if bank has money - true, else false*/
	
	public boolean GiveMoneyToPlayer(Player p,double amount) {
		return false;
	}
	/**
	 * charging money from player and put the money in the bank
	 * @param player to charge, amount of money to take
	 * @return if player has money - true, else false*/
	
	public boolean ChargeMoneyFromPlayer(Player p,double amount) {
		return false;
	}

}
