package JavaCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.swt.widgets.Link;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class DeckActions {
		public LinkedList<String> kaartenInHand = new LinkedList<String>();
		public LinkedList<String> list = new LinkedList<String>();
		public LinkedList<String> actieKaartenLijst = new LinkedList<String>();
		private String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
	            "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
	            "thief", "village", "witch", "woodcutter", "workshop" };
   
	    
	    
    public LinkedList<String> startKaarten(){
		for (int i = 0; i < 7; i++) {list.add("copper");}
		for (int j = 0; j < 3; j++) {list.add("estate");}
		Collections.shuffle(list);
		return list;
	}	
	
    
	public void printLijst(LinkedList<String> lijst){
		for(String x : lijst)
			System.out.println(x );
		}
	
	
	public LinkedList<String> kaartToevoegenBijEenLijst(LinkedList<String> lijst, String kaart){
		lijst.add(kaart);
		return list;
	}
	
	public LinkedList<String> getrokkenHand(LinkedList<String> lijst){
		kaartenInHand.clear();
		for (int i = 0; i < 5; i++) {kaartenInHand.add(lijst.get(i));}
		return kaartenInHand;
	}
	
	
	public LinkedList<String> lijstenSamenvoegen(LinkedList<String> mainList, LinkedList<String> addToAnotherList ){
		
		for (int i = 0; i < addToAnotherList.size(); i++) {
		mainList.add(addToAnotherList.get(i));}
		return mainList;
	}
	
	public LinkedList<String> lijstVerminderen(LinkedList<String> lijst,int size){
		
		for (int i = 0; i < size; i++) {
		lijst.removeFirst();}
		return list;
	}
	
	
	public LinkedList<String> nieuweLijst(LinkedList<String> playableList, LinkedList<String> discardList){
		
		if(playableList.size()<5){
			LinkedList<String> newPlayableList = lijstenSamenvoegen(playableList, discardList);
			discardList.clear();
			Collections.shuffle(newPlayableList);
			return newPlayableList;
		}
		else{return playableList;}
	}
	
	public LinkedList<String> actieKaartenGenereren(){
	    
	 	Collections.shuffle((Arrays.asList(actieKaarten)));
	   	for (int i = 0; i < actieKaarten.length; i++) {	
	   		actieKaartenLijst.add(actieKaarten[i]);}
	    	
	   	return actieKaartenLijst;
	    	
	    }
	  
	  
	
	  

}


	
	

