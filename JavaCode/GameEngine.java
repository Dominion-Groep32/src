package JavaCode;



import java.io.Console;
import java.util.LinkedList;

import javax.smartcardio.Card;

import org.eclipse.core.internal.databinding.observable.ConstantObservableValue;
import org.eclipse.swt.widgets.Link;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.omg.CORBA.PUBLIC_MEMBER;



public class GameEngine {

	public static void main(String[] args) {
			
		GUI gui = new GUI();
		DeckActions action = new DeckActions();
		CardDetails card = new CardDetails();
		GameActions game = new GameActions();
		
		gui.GenerateCardsField();
		
		gui.AddDrawHandImages(action.startDeckCards());
		
	

		int coins = card.coins;
		int actions = card.actions;
		int buys = card.buys;
		
		
		card.startUp();
		
		
		
		LinkedList<String> startDeck = action.startDeckCards();
		action.displayDeck(startDeck);
		
		game.showTypeOftest("Shuffle");
		
	
		LinkedList<String> playableDeck = action.shuffle(action.startDeckCards()); 
		action.displayDeck(playableDeck);
		
		game.showTypeOftest("DrawHand");
		
		LinkedList<String> drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);
		game.showTypeOftest("playableDeck");
		
		playableDeck = action.decreasePlayableDeck(playableDeck,5);
		action.displayDeck(playableDeck);
		game.showTypeOftest("Add ActionCard To Deck");
		
		LinkedList<String> startDiscardDeck = new LinkedList<String>();
		card.witch();
		
		LinkedList<String> discardDeck = action.addCardToList(startDiscardDeck, card.cardName);
		card.village();
		action.addCardToList(startDiscardDeck, card.cardName);
		action.displayDeck(discardDeck);
		
		game.showTypeOftest("Add DrawHand To DiscardDeck & Show DiscardDeck");
		
		discardDeck = action.mergeLists(discardDeck, drawHand);
		action.displayDeck(discardDeck);
	
		game.showTypeOftest("Controle PlayableDeck");
		
		playableDeck=action.newPlayableDeck(playableDeck, discardDeck);
		action.displayDeck(playableDeck);
		
		game.showTypeOftest("DrawHand");
				
		drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);
		
		game.showTypeOftest("Tester");
		
		action.displayDeck(drawHand);
		
		game.showTypeOftest("Function that shows the Type");
		
		game.checkType(drawHand);
		
	
		gui.getNameButton();
		gui.getNameDrawhand();
		
		
		//gui.AddDrawHandImages(discardDeck);
		
	
		//gameConsole.consoleTest();
		
		
	}
	
	
	

}
