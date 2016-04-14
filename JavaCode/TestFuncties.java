/*package JavaCode;

import java.util.LinkedList;
import org.junit.*;

import OudeCode.CardDetails;
import OudeCode.DeckActions;

import static org.junit.Assert.*;

public class TestFuncties {
	public LinkedList<String> newList = new LinkedList<String>();
	public LinkedList<String> playableList = new LinkedList<String>();
	DeckActions action = new DeckActions();
	CardDetails card = new CardDetails();
	int startDeckSize = action.startKaarten().size(); 
	LinkedList<String> startDeckList= action.startKaarten(); 
	
	
	@Test
	public void testStartDeckCards() {
		
		if (action.startKaarten().size()!= 10)
			System.out.println("startDeck Fails");
	}

	@Test
	public void testAddCardToList(){
		card.witch();
		int deckWithAddedCard = action.kaartToevoegenBijEenLijst(action.startKaarten(), card.cardName).size();
		assertEquals((startDeckSize+1),deckWithAddedCard,0.01);
	}
	
	
	@Test
	public void testDrawHand(){
		int drawHand = action.getrokkenHand(action.startKaarten()).size();
		if(drawHand!=5)
				System.err.println("drawHand Fails");
	}
	
	@Test
	public void testMergeLists(){
		
		
		newList = action.lijstenSamenvoegen(startDeckList, newList);
		if(startDeckSize != newList.size())
			System.err.println("mergeLists Fails");
	}
	
	@Test
	public void testDecreasePlayableDeck(){
		
		
		int decreasedList = action.lijstVerminderen(startDeckList, 3).size();
		if(decreasedList!=7)
			System.err.println("decreasedPlayableDeck Fails");
	}
	@Test
	public void testNewPlayableDeck(){
		
		for (int i = 0; i < 3; i++) {playableList.add("Value"+i);};
		
		int newPlayableListSize= action.nieuweLijst(playableList, startDeckList).size();
		
		if(newPlayableListSize != 13)
			System.err.println("newPlayableDeck Fails");
	}
}
*/