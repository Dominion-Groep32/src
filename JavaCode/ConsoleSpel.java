package JavaCode;
import java.io.InputStream;
import java.util.*;


public class ConsoleSpel {
	

	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		Speler jens = new Speler("Jens");
		

		gameEngine.dominionTitel();

	
		//gameEngine.toonLijst(jens.trekStapel()); // Dit toont de startstapel van een speler
		System.out.println("De kaarten in drawhand zijn:");
		gameEngine.toonLijst(gameEngine.trekKaart(jens.trekStapel(), 5)); // dit toont de drawhand
		System.out.println("------");
		
		gameEngine.geefKeuze();
		
		
		
		
		//gameEngine.toonDeInfo(gameEngine.kaartInHand());
		
		
		//gameEngine.toonActieLijst(gameEngine.actieKaartenGenereren());
		
	
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		//TESTING AREA //
		
		
		
	}
}


