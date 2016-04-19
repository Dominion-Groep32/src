package JavaCode;

import java.util.*;

public class ConsoleSpel {

	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		Speler jens = new Speler("Jens");
	
		LinkedList<Kaart> trekstapel = jens.trekStapel();
		LinkedList<Kaart> kaartenDieTekoopZijn = gameEngine.lijstenSamenvoegen(gameEngine.actieKaartenGenereren(), gameEngine.getAndereKaarten());
			
		
		
		gameEngine.dominionTitel();

		gameEngine.beurt(trekstapel,kaartenDieTekoopZijn);
		gameEngine.beurt(trekstapel,kaartenDieTekoopZijn);
		gameEngine.beurt(trekstapel,kaartenDieTekoopZijn);
		

		
		
		
	
		/*
		gameEngine.toonLijst(trekstapel);
		System.out.println("--1ste drawhand---");
		
		LinkedList<Kaart> kaartenInHand = gameEngine.trekKaart(trekstapel, 5);
		
		gameEngine.toonLijst(kaartenInHand);
		gameEngine.maakKaartInHandLeeg(); //leegt de lijst van kaarten in de hand
		
		System.out.println("----2e drawhawd----");
		
		gameEngine.maakKaartInHandLeeg();
		gameEngine.trekKaart(trekstapel, 5);

		gameEngine.toonLijst(kaartenInHand);
		gameEngine.maakKaartInHandLeeg();
		System.out.println("---aflegstapel----");
		
		gameEngine.toonLijst(aflegStapel);
		
		
		System.out.println("-----AUTOMERGE TESTEN -------");
		gameEngine.toonLijst(trekstapel);//trekstapel is leeg 
		gameEngine.trekKaart(trekstapel, 5);//hier zie je omdat de lijst leeg is dat hij ze automatisch samenvoegt :)
		gameEngine.toonLijst(kaartenInHand);
		
		
		
		*/
		 
		
		
		
	


	}
}
