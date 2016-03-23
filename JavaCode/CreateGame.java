package JavaCode;

import java.awt.Desktop.Action;

import javax.smartcardio.Card;

public class CreateGame {

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub

		//GUI gui = new GUI();
		//gui.GenerateCardsField();
		//gui.GenerateCardsHand();
		  
		  GameActions action = new GameActions();
		  CardDetails card = new CardDetails();
		   
		  card.startUp();
		  card.coinGold();
		  card.coinGold();
		  card.coinGold();
		  
		  System.out.println(card.coins);
		  
	}
}
