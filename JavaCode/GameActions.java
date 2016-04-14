package JavaCode;

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
	

	
	

	

	


	
	
	
	
	

	
	
		
			
		
	
	


