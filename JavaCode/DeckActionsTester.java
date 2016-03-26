package JavaCode;

import java.util.LinkedList;
import org.junit.*;
import static org.junit.Assert.*;

public class DeckActionsTester {
		
	DeckActions action = new DeckActions();
	CardDetails card = new CardDetails();
	
	int startDeckSize = action.startDeckCards().size(); //10
	LinkedList<String> startDeckList= action.startDeckCards(); //10 cards (3 estate + 7 coppers)
	
	@Test
	public void testStartDeckCards() {
		
		if (action.startDeckCards().size()!= 10)
			System.out.println("startDeck Fails");
	}

	@Test
	public void testAddCardToList(){
		card.witch();
		int deckWithAddedCard = action.addCardToList(action.startDeckCards(), card.cardName).size();
		assertEquals((startDeckSize+1),deckWithAddedCard,0.01);
	}
	
	@Test
	public void testDrawHand(){
		int drawHand = action.drawHand(action.startDeckCards()).size();
		if(drawHand!=5)
				System.err.println("drawHand Fails");
	}
	
	@Test
	public void testMergeLists(){
		
		LinkedList<String> newList = new LinkedList<String>();
		newList = action.mergeLists(startDeckList, newList);
		
		if(startDeckSize != newList.size())
			System.err.println("mergeLists Fails");
	}
	
	@Test
	public void testDecreasePlayableDeck(){
		
		int decreasedList = action.decreasePlayableDeck(startDeckList, 3).size();
		if(decreasedList!=7)
			System.err.println("decreasedPlayableDeck Fails");
	}
	@Test
	public void testNewPlayableDeck(){
		LinkedList<String> playableList = new LinkedList<String>();
		for (int i = 0; i < 3; i++) {playableList.add("Value"+i);};
		
		int newPlayableListSize= action.newPlayableDeck(playableList, startDeckList).size();
		if(newPlayableListSize != 13)
			System.err.println("newPlayableDeck Fails");
	}
}
