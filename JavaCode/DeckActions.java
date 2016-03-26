package JavaCode;

import java.util.Collections;
import java.util.LinkedList;

public class DeckActions {
	
	//public LinkedList<String> discardedCardList = new LinkedList<String>();
	public LinkedList<String> CardsInHand = new LinkedList<String>();
	
	public LinkedList<String> startDeckCards(){
		
		LinkedList<String> list = new LinkedList<String>();
	 
		for (int i = 0; i < 7; i++) {list.add("copper");}
		for (int j = 0; j < 3; j++) {list.add("estate");}
		return list;
	}	
	
	public void displayDeck(LinkedList<String> list){
	
		for(String x : list) System.out.println(x);
		}
	
	public LinkedList<String> shuffle(LinkedList<String> list){
		Collections.shuffle(list);
		return list;
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
	
	//public LinkedList<String> discardDeck(LinkedList<String> list) {
		
		//for (int i = 0; i < list.size(); i++) {discardedCardList.add(list.get(i));}
		//return discardedCardList;
	//}
	
	public LinkedList<String> mergeLists(LinkedList<String> mainList, LinkedList<String> addToAnotherList ){
		
		for (int i = 0; i < addToAnotherList.size(); i++) {mainList.add(addToAnotherList.get(i));}
		return mainList;
	}
	
	public LinkedList<String> decreasePlayableDeck(LinkedList<String> list,int size){
		
		for (int i = 0; i < size; i++) {list.removeFirst();}
		return list;
	}
	
	private int getListSize(LinkedList<String> list){
		return list.size();
	}
	
	
	public LinkedList<String> newPlayableDeck(LinkedList<String> playableList, LinkedList<String> discardList){
		
		if(getListSize(playableList)<5){
			
			LinkedList<String> newPlayableList = mergeLists(playableList, discardList);
			discardList.clear();
			return shuffle(newPlayableList);
		}
		else{return playableList;}
	}
	

}
	
	

