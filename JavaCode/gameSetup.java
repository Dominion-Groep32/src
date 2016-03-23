package JavaCode;

public class GameSetup {
	
	public static int[][] treasureCardsArray = new int[3][2];
	public static int[][] victoryCardsArray = new int[3][2];
	public static int[][] curseCardsArray = new int[1][2];
	public static int[][] randomizeCardsArray = new int[0][0];
	public int trashCard = 1;
	
	public void fillTreasureCardsArray() {
		treasureCardsArray[0][0] = 1;
		treasureCardsArray[0][1] = 60;
		
		treasureCardsArray[1][0] = 2;
		treasureCardsArray[1][1] = 40;
		
		treasureCardsArray[2][0] = 3;
		treasureCardsArray[2][1] = 30;
	}
	
	public void fillVictoryCardsArray() {
		victoryCardsArray[0][0] = 1;
		victoryCardsArray[0][1] = 24;
		
		victoryCardsArray[1][0] = 3;
		victoryCardsArray[1][1] = 12;
		
		victoryCardsArray[2][0] = 6;
		victoryCardsArray[2][1] = 12;
	}
	
	public void fillCurseCardsArray() {
		curseCardsArray[0][0] = -1;
		curseCardsArray[0][1] = 30;
	}
	
	public void fillRandomizeCardsArray() {
		randomizeCardsArray[0][0] = 32;
	}
	
}
