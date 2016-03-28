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
				
		// TODO Auto-generated method stub
		
		GUI gui = new GUI();
		DeckActions action = new DeckActions();
		CardDetails card = new CardDetails();
		GameActions game = new GameActions();
		ConsoleTest gameConsole = new ConsoleTest();
		gui.GenerateCardsField();
		
		//gui.AddDrawHandImages((action.startDeckCards()));
	

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
		LinkedList<String> startDiscardDeck = new LinkedList<String>();
		card.witch();
		
		LinkedList<String> discardDeck = action.addCardToList(startDiscardDeck, card.cardName);
		card.village();
		action.addCardToList(startDiscardDeck, card.cardName);
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
		
		System.out.println("---------------------------------tester-----------------------------------------------------");
		
		action.displayDeck(drawHand);
		
		
		System.out.println("---------------------- functie die type toont------------------------------------------");
		game.checkType(drawHand);
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		
		LinkedList<String> testlist = new LinkedList<String>();
		
		testlist.add("witch");
		testlist.add("village");
		testlist.add("copper");
		testlist.add("province");
		testlist.add("smithy");
		
		action.displayDeck(testlist);
		System.out.println("------types-------");
		game.checkType(testlist);
		
		
		System.out.println("----------------------------------------------------------------------------------------");
		gui.getNameButton();
		gui.getNameDrawhand();
		
		
		gui.AddDrawHandImages(discardDeck);
		
	
		//gameConsole.consoleTest();
		
		
	}
	
	
	

}
