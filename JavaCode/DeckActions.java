package JavaCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class DeckActions {
		public LinkedList<String> CardsInHand = new LinkedList<String>();
		public LinkedList<String> list = new LinkedList<String>();
		public LinkedList<String> actieKaartenList = new LinkedList<String>();
		private String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
	            "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
	            "thief", "village", "witch", "woodcutter", "workshop" };
	    
	
	    
	    
	    
    public LinkedList<String> startDeckCards(){
		
		for (int i = 0; i < 7; i++) {list.add("copper");}
		for (int j = 0; j < 3; j++) {list.add("estate");}
		Collections.shuffle(list);
		return list;
	}	
	

	
	public void displayDeck(LinkedList<String> list){
		for(String x : list)
			System.out.println(x );
		}
	
	
	public LinkedList<String> addCardToList(LinkedList<String> list, String card){
		list.add(card);
		return list;
	}
	
	public LinkedList<String> drawHand(LinkedList<String> list){
		CardsInHand.clear();
		for (int i = 0; i < 5; i++) {CardsInHand.add(list.get(i));}
		return CardsInHand;
	}
	
	
	public LinkedList<String> mergeLists(LinkedList<String> mainList, LinkedList<String> addToAnotherList ){
		
		for (int i = 0; i < addToAnotherList.size(); i++) {
		mainList.add(addToAnotherList.get(i));}
		return mainList;
	}
	
	public LinkedList<String> decreasePile(LinkedList<String> list,int size){
		
		for (int i = 0; i < size; i++) {
		list.removeFirst();}
		return list;
	}
	
	
	
	public LinkedList<String> newPlayableDeck(LinkedList<String> playableList, LinkedList<String> discardList){
		
		if(playableList.size()<5){
			LinkedList<String> newPlayableList = mergeLists(playableList, discardList);
			discardList.clear();
			Collections.shuffle(newPlayableList);
			return newPlayableList;
		}
		
		else{return playableList;}
	}
	
	public LinkedList<String> GenerateActionCards(){
	    
	 	Collections.shuffle((Arrays.asList(actieKaarten)));
	   	for (int i = 0; i < actieKaarten.length; i++) {	
	   		actieKaartenList.add(actieKaarten[i]);}
	    	
	   		return actieKaartenList;
	    	
	    }
	  
	  
	  

}


	
	

