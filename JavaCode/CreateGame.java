package JavaCode;


import java.awt.Button;
import java.awt.Desktop.Action;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

import javax.smartcardio.Card;
import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.scenario.effect.DisplacementMap;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class CreateGame {

	public static void main(String[] args) {
				
		// TODO Auto-generated method stub
		
		//GUI gui = new GUI();
		//gui.GenerateCardsField();
		//gui.GenerateCardsHand();
		
		
		GameActions action = new GameActions();
		CardDetails card = new CardDetails();
		
		
		 
		System.out.println("--------------------------Standaard------------------------------------------");
		
		card.startUp();
		LinkedList<String> startDeck = action.startDeckCards();
		action.displayDeck(startDeck);

		System.out.println("-------------------------------shuffle--------------------------------------------");
		
		LinkedList<String> playableDeck = action.shuffle(action.startDeckCards()); 
		action.displayDeck(playableDeck);
		

		System.out.println("--------------------------------------deck 5-------------------------------------------");
		
		LinkedList<String> drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);

		System.out.println("--------------------------playable -5------------------------------------------");
		
		playableDeck = action.decreasePlayAbleDeck(playableDeck);
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------add witch print discardDeck------------------------------------------");
		
		card.witch();
		LinkedList<String> startDiscardDeck = new LinkedList<String>();
		LinkedList<String> discardDeck = action.addCardToList(startDiscardDeck, card.cardName);
		action.displayDeck(discardDeck);
		
		System.out.println("--------------------add drawhand to discarddeck & show discardDeck-------------------------------------------");
		
		discardDeck = action.mergeLists(discardDeck, drawHand);
		action.displayDeck(discardDeck);
	
		System.out.println("--------------------nieuwe playabledeck-------------------------------------------");
		
		playableDeck=action.newPlayableDeck(playableDeck, discardDeck);
		action.displayDeck(playableDeck);
		
		System.out.println("-------------------------------shuffle--------------------------------------------");
		
		playableDeck = action.shuffle(playableDeck); 
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------------------deck 5-------------------------------------------");
		
		drawHand = action.drawHand(playableDeck);
		action.displayDeck(drawHand);
		
		System.out.println("--------------------------playableDeck------------------------------------------");
		
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------playable -5------------------------------------------");
		
		playableDeck = action.decreasePlayAbleDeck(playableDeck);
		action.displayDeck(playableDeck);
		
		System.out.println("--------------------------add adventure print discardDeck------------------------------------------");
		
		card.adventurer();
		discardDeck = action.addCardToList(discardDeck, card.cardName);
		action.displayDeck(discardDeck);
		
	}
}
