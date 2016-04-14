package JavaCode;

public class GameActions {
	CardDetails card = new CardDetails();
	DeckActions deckActions = new DeckActions();


	public int getCardCoins(String kaart){
		
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
	
		return card.coins;
	}

public String getCardName(String kaart){
		
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
	
		return card.cardName;
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

public void printCardCoins(String kaart) {
	System.out.println(getCardCoins(kaart));
}
public void printCardName(String kaart) {
	System.out.println(getCardName(kaart));
}
public void printCardType(String kaart) {
	System.out.println(getCardType(kaart));
}
}
	

	
	

	

	


	
	
	
	
	

	
	
		
			
		
	
	


