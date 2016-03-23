package JavaCode;

public class GameActions {
	
	CardDetails card = new CardDetails();
	
	private int coins;
	private int buys;
	private int actions;
		
	public void getValues() {
		coins = card.cardValue;
		buys = card.cardBuys;
		actions = card.cardActions;
	}
	
	
	public void basicTurn(){
		coins = 0;
		buys = 1;
		actions = 1;
	}
	
	public int getCoins()
	{
		return this.coins;
	}
	
	public int getAction()
	{
		return actions;
	}
	
	public int getBuys()
	{
		return buys;
	}
	
	public void copperAction()
	{
		coins ++;
	}
	
	public void buyCopper()
	{
		card.amountCopper -= 1;
	}
	
	public void buySilver()
	{
		card.amountSilver -= 1;
	}
	
	public void buyGold()
	{
		card.amountGold -= 1;
	}
}
	