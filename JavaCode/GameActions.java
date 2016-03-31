package JavaCode;

import java.util.Arrays;
import java.util.LinkedList;

//import org.eclipse.swt.widgets.Link;

//import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

import sun.security.timestamp.Timestamper;
import java.util.*;

public class GameActions {
	CardDetails card = new CardDetails();
	DeckActions deckActions = new DeckActions();

	private LinkedList<String> ActionCards = new LinkedList<String>();
	
	public String[] actionCards = {"cellar","chapel","moat","chancellor","village","woodcutter","workshop","bureaucrat","feast","militia","moneylender","remodel","smithy","spy","thief","throne room","council room","festival","laboratory","library"};
	public String[] groundCards = {"estate","duchy","province"};
	public String[] moneyCards = {"copper","gold","silver"};
	

	
	public String checkType(String naam){
		
		for (int j = 0; j < 30; j++) {
			
			if(Arrays.asList(actionCards).contains(naam))
			{
				return "action";	
			}
		
			else if (Arrays.asList(groundCards).contains(naam)) {
				return "victory";	
			}
			else {return "treasure";}
			
			}
		return "fail";
	}
	
	
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
			

		default:
			card.resetCards();
			break;
		}
		
		return card.cardType;
		
		
	}
	
	
	public void showTypeOfPRINT(String string){
		System.out.println("-----------------------------"+ string +"--------------------------------------------");
	}
}
	

	
	

	

	


	
	
	
	
	

	
	
		
			
		
	
	


