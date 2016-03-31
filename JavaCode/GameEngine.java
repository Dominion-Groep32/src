package JavaCode;



import java.io.Console;
import java.util.LinkedList;

import javax.smartcardio.Card;
/*
import org.eclipse.core.internal.databinding.observable.ConstantObservableValue;
import org.eclipse.swt.widgets.Link;
import org.junit.experimental.theories.suppliers.TestedOn;
*/
import org.omg.CORBA.PUBLIC_MEMBER;



public class GameEngine {

	public static void main(String[] args) {
			
		GUI gui = new GUI();
		DeckActions action = new DeckActions();
		CardDetails card = new CardDetails();
		GameActions game = new GameActions();
		card.startTurn();
		
		System.out.println("Actions : "+card.actions);
		System.out.println("Buys : "+card.buys);
		
		
		gui.GenerateCardsField();
		
		card.startUp();
		
		
		
		LinkedList<String> startDeck = action.startDeckCards();
		
		
		
		//game.showTypeOfPRINT("Shuffle");
		
	
		LinkedList<String> playablePile = action.shuffle(action.startDeckCards()); 
		//action.displayDeck(playablePile);
		
		//game.showTypeOfPRINT("DrawHand");
		
		LinkedList<String> drawHand = action.drawHand(playablePile);
		//action.displayDeck(drawHand);
		
		//game.showTypeOfPRINT("playableDeck");
		
		playablePile = action.decreasePile(playablePile,5);
		//action.displayDeck(playablePile);
		
		//game.showTypeOfPRINT("Add ActionCard To Deck");
		
		LinkedList<String> startDiscardDeck = new LinkedList<String>();
		card.witch();
		
		LinkedList<String> discardDeck = action.addCardToList(startDiscardDeck, card.cardName);
		card.village();
		action.addCardToList(startDiscardDeck, card.cardName);
		//action.displayDeck(discardDeck);
		
		//game.showTypeOfPRINT("Add DrawHand To DiscardDeck & Show DiscardDeck");
		
		discardDeck = action.mergeLists(discardDeck, drawHand);
		//action.displayDeck(discardDeck);
	
		//game.showTypeOfPRINT("Controle PlayableDeck");
		
		playablePile=action.newPlayableDeck(playablePile, discardDeck);
		//action.displayDeck(playablePile);
		
		//game.showTypeOfPRINT("DrawHand");
				
		drawHand = action.drawHand(playablePile);
		//action.displayDeck(drawHand);
		
		//game.showTypeOfPRINT("Tester");
		
		//action.displayDeck(drawHand);
		
		//game.showTypeOfPRINT("Function that shows the Type");
		
		//game.checkType(drawHand);
		
	
		gui.getNameButton();
		
		gui.getNameDrawhand();
		
		
		//gui.AddDrawHandImages(discardDeck);
		//gameConsole.consoleTest();
		
		
		
		
	}
	
	
	

}
