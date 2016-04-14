package JavaCode;

import java.util.Arrays;
import java.util.LinkedList;

//import com.sun.java.util.jar.pack.Package.Class.Method;

//import org.eclipse.swt.widgets.Link;

//import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.org.apache.xpath.internal.functions.Function;

import sun.security.timestamp.Timestamper;
import java.util.*;

public class GameActions {
	CardDetails card = new CardDetails();
	DeckActions deckActions = new DeckActions();


	public String getCardDetails(String kaart){
		
		switch (kaart) {
		case "witch":
			 card.witch();
			break;
		case "copper":
			card.coinCopper();
			break;
		case "silver":
			card.coinSilver();	
			break;
		case "gold":
			card.coinGold();
			break;
		case "estate":
			card.estate();
			break;
		case "adventurer":
			card.adventurer();
			break;
		case "ambassador":
			card.ambassador();
			break;
				
		default:
			card.resetCards();
			break;
		}
	
		return card.cardType;
	
		
	}

}
	

	
	

	

	


	
	
	
	
	

	
	
		
			
		
	
	


