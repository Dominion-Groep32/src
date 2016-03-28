package JavaCode;
import java.util.*;

public class ConsoleTest {

	Scanner scanner = new Scanner(System.in);
	DeckActions deckActions = new DeckActions();
	CardDetails cardDetails = new CardDetails();
	
	
	  public void consoleTest(){
		  	
	    	
	    	System.out.println("--------------------------WELCOME TO DOMINION------------------------------------------");
	    	System.out.println("ENTER YOUR USERNAME PLEASE : ");
	    	String username = "jens";//scanner.nextLine();
	    	System.out.println("your username is : "+username);
	    	System.out.println("-----------------------------------");
	    	
	    	System.out.println("ACTION CARDS ON THE BOARD  ");
	    	System.out.println("");
	    	deckActions.displayDeck(deckActions.GenerateActionCards());
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("The 5 cards in your hand are : ");
	    	System.out.println("");
	    	deckActions.displayDeck(deckActions.drawHand(deckActions.startDeckCards()));
	    	System.out.println("");
	    	System.out.println();
	    	
	    	cardDetails.resetCards();
	    	System.out.println(cardDetails.actions);
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	  
	  
}
