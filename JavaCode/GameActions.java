package JavaCode;

public class GameActions {
	
	private int coins;
	private int buys;
	private int actions;
	
	
	public void basicTurn(){
		coins = 0;
		buys = 1;
		actions = 1;
	}
	
	public int getCoins(){
		return this.coins;
	}
	
	public int getAction(){
		return actions;
	}
	
	public int getBuys(){
		return buys;
	}
	
	public void copperAction(){
		coins ++;
	}
	
	
	
	
	
	
	

}
