package JavaCode;

public class cards {
	
	public static gameSetup setup = new gameSetup();
	public static CardDetails cardDetails = new CardDetails();
	
	public static void main(String[] args)
	{
		cardDetails.currentCardInfo();
		setup.fillTreasureCardsArray();
		setup.fillVictoryCardsArray();
		setup.fillCurseCardsArray();
	}
}
