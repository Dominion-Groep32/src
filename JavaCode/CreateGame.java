package JavaCode;

/*
import java.awt.Button;
import java.awt.Desktop.Action;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

import javax.smartcardio.Card;
import javax.swing.ImageIcon;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import junit.framework.Test;
*/


public class CreateGame {

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub
		/*
		GUI gui = new GUI();
		gui.GenerateCardsField();
		gui.GenerateCardsHand();
<<<<<<< HEAD
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
=======
		  GameActions action = new GameActions();
		  CardDetails card = new CardDetails();
		   
		  card.startUp();
		  card.coinCopper();
		  card.coinGold();
		  
		 
		  

		  
>>>>>>> d54ebdeca103cd44f3412a8c7f12f5c85cb83fd4
		  
		System.out.println(card.coins);
	}
}
