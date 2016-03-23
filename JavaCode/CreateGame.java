package JavaCode;

public class CreateGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// GUI gui = new GUI();
		// gui.GenerateCardsField();
		  // gui.GenerateCardsHand();
		  
		  GameActions test = new GameActions();
		  test.basicTurn();
		  test.copperAction();
		  test.copperAction();
		  
		  
		  System.out.println("aantal coins is "+test.getCoins());
		  
		  
	}

}
