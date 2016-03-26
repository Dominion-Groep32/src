package JavaCode;



import java.util.LinkedList;

import javax.smartcardio.Card;

import org.eclipse.swt.widgets.Link;
import org.omg.CORBA.PUBLIC_MEMBER;



public class GameEngine {

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub
		
		//GUI gui = new GUI();
		//gui.GenerateCardsField();
		//gui.GenerateCardsHand();
		
		
		DeckActions action = new DeckActions();
		CardDetails card = new CardDetails();
		GameActions game = new GameActions();
		int coins = card.coins;
		int actions = card.actions;
		int buys = card.buys;
		
		
		card.startUp();
		
		System.out.println("--------------------------Standaard------------------------------------------");
		
		LinkedList<String> startDeck = action.startDeckCards();
		action.displayDeck(startDeck);

		System.out.println("-------------------------------shuffle-------------------------------x-------------");
		
		LinkedList<String> playableDeck = action.shuffle(action.startDeckCards()); 
		action.displayDeck(playableDeck);
		

		System.out.println("--------------------------------------drawHand-------------------------------------------");
		
		LinkedList<String> drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);

		System.out.println("--------------------------playableDeck------------------------------------------");
		
		playableDeck = action.decreasePlayableDeck(playableDeck,5);
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------add actioncard to discardDeck------------------------------------------");
		
		card.witch();
		LinkedList<String> startDiscardDeck = new LinkedList<String>();
		LinkedList<String> discardDeck = action.addCardToList(startDiscardDeck, card.cardName);
		action.displayDeck(discardDeck);
		
		System.out.println("--------------------add drawhand to discarddeck & show discardDeck-------------------------------------------");
		
		discardDeck = action.mergeLists(discardDeck, drawHand);
		action.displayDeck(discardDeck);
	
		System.out.println("--------------------Controle playabledeck-------------------------------------------");
		
		playableDeck=action.newPlayableDeck(playableDeck, discardDeck);
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------------------drawHand-------------------------------------------");
		
		drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);
		
		card.alchemist();
		System.out.println(card.coins);
		System.out.println(card.actions);
		System.out.println(card.buys);
		
		System.out.println(card.cardType.toLowerCase());
	
		
		
		
		
		game.loopTest(discardDeck);
		
		
	}
	
	
	

}
