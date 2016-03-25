package JavaCode;

import java.util.LinkedList;

import org.eclipse.swt.widgets.Link;

import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;

import sun.security.timestamp.Timestamper;

public class GameActions {
	CardDetails card = new CardDetails();
	LinkedList<String> ActionCards = new LinkedList<String>();
	
	public LinkedList<String> checkActionType(LinkedList<String> Drawhand){
		
		
		for (int i = 0; i < Drawhand.size(); i++) {
			
			if(card.cardType.toLowerCase() == "action" )
				ActionCards.add(card.cardName.toLowerCase());
			}
		
		return ActionCards;
			
	
	}
	
	public void loopTest(LinkedList<String> list){
		
		for (int i = 0; i < list.size(); i++) {
			
			
			System.out.println(list.get(i));
			
		}
	}
	
	
		
			
		
	
	

}
