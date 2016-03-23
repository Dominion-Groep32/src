package JavaCode;

public class cards {
	
	public static GameSetup setup = new GameSetup();
	public static CardDetails cardDetails = new CardDetails();
	public static void main(String[] args)
	{
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
