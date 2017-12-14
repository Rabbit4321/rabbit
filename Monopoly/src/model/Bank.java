package model;

public class Bank {
	
	private static final int StartAmountForPlayer=500000;
	private static double Money= 10000000;

	public static int getStartAmountForPlayer() {
		return StartAmountForPlayer;
	}
	/**
	 * give money to player
	 * @param player, amount of money to transfer
	 * @return if bank has money - true, else false*/
	
	public static void GiveMoneyToPlayer(PlayerInGame p,double amount) {
			p.receivingMoney(amount);
			Money = Money - amount;
		if (Money <= 0)// don't sure about this check - because we dont know what happend when there is no money in the bank
			Money = 1000000;
	}
	/**
	 * charging money from player and put the money in the bank
	 * @param player to charge, amount of money to take
	 * @return if player has money - true, else false*/
	
	public static boolean ChargeMoneyFromPlayer(PlayerInGame p,double amount) {
		if((p.getCurrentMoney()-amount) > -100000) {
			p.payToPlayerAndBank(amount);
			Money += amount;
			return true;
		}
		return false;
	}

}
