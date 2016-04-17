package JavaCode;

import java.util.*;

public class ConsoleSpel {

	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		Speler jens = new Speler("Jens");
		LinkedList<Kaart> aflegStapel = gameEngine.aflegStapel();
		LinkedList<Kaart> trekstapel = jens.trekStapel();
		
		
		gameEngine.dominionTitel();

		
		gameEngine.toonLijst(trekstapel);
		System.out.println("--1ste drawhand---");
		
		LinkedList<Kaart> Spelertrekstapel = gameEngine.trekKaart(trekstapel, 5);
		
		gameEngine.toonLijst(Spelertrekstapel);
		gameEngine.maakKaartInHandLeeg(); //leegt de lijst van kaarten in de hand
		
		gameEngine.toonLijst(Spelertrekstapel);//dit gaat niets printen omdat spelertrekstapel leeg is :) 
		System.out.println("----2e drawhawd----");
		
		gameEngine.maakKaartInHandLeeg();
		gameEngine.trekKaart(trekstapel, 5);
		
		
		
		gameEngine.toonLijst(Spelertrekstapel);
		System.out.println("---aflegstapel----");
		
		gameEngine.toonLijst(aflegStapel);
		
		
		System.out.println("------HIEROP VERDER TESTEN -------");
		
		gameEngine.trekKaart(Spelertrekstapel, 5);
		gameEngine.toonLijst(Spelertrekstapel);
		
		//gameEngine.geefKeuze();
		
		// gameEngine.toonDeInfo(gameEngine.kaartInHand());

		// gameEngine.toonActieLijst(gameEngine.actieKaartenGenereren());


	}
}
