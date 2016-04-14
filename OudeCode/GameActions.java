package OudeCode;

import JavaCode.DeckActions;

public class GameActions {
	CardDetails card = new CardDetails();
	DeckActions deckActions = new DeckActions();


	public int getCardCoins(String kaart){
		
		switch (kaart) {
		case "witch":
			 card.witch();
		
		case "copper":
			card.coinCopper();
			System.out.println("tester van de switch geef aan " + card.coins);
		
		case "silver":
			card.coinSilver();	
		
		case "gold":
			card.coinGold();
		
		case "estate":
			card.estate();
		
		case "adventurer":
			card.adventurer();
		
		case "ambassador":
			card.ambassador();
		
				
		default:
			card.resetCards();
		
		}
	
		return card.coins;
	}



public String getCardType(String kaart){
	
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
	
