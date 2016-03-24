package JavaCode;

/*
import java.awt.Button;
import java.awt.Desktop.Action;

import javax.smartcardio.Card;

import junit.framework.Test;
*/

public class CreateGame {

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub
		/*
		GUI gui = new GUI();
		gui.GenerateCardsField();
		gui.GenerateCardsHand();
		*/
		
		GameActions action = new GameActions();
		CardDetails card = new CardDetails();
		   
		card.startUp();
		
		for (int i = 0; i < 20; i++) {
			card.coinCopper();
			card.coinGold();
		}
		
		System.out.println(card.amountCopper);
		System.out.println(card.amountGold);
		  
		System.out.println(card.coins);
	}
}
