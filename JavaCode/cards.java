package JavaCode;

public class cards {
	
	
	
	public static void main(String[] args)
	{
		GameSetup setup = new GameSetup();
		CardDetails cardDetails = new CardDetails();
		
		cardDetails.currentCardInfo();
		cardDetails.smithy();
		cardDetails.currentCardInfo();
		
		setup.fillTreasureCardsArray();
		setup.fillVictoryCardsArray();
		setup.fillCurseCardsArray();
		
		cardDetails.ambassador();
		cardDetails.currentCardInfo();
		System.out.println(cardDetails.cardCost);
		
	}
}
