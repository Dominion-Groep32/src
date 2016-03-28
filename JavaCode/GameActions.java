package JavaCode;

import java.util.Arrays;
import java.util.LinkedList;

import org.eclipse.swt.widgets.Link;

import com.mysql.fabric.xmlrpc.base.Array;
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
	

	
	public void checkType(LinkedList<String> list){
		
		for (int j = 0; j < list.size(); j++) {
			
			if(Arrays.asList(actionCards).contains(list.get(j)))
			{
				
				System.out.println("action");
				
			}
		
			else if (Arrays.asList(groundCards).contains(list.get(j))) {
				System.out.println("ground");
			}
			else {System.out.println("money");}
			
			}

	}
}
	
	
	

	

	


	
	
	
	
	

	
	
		
			
		
	
	


