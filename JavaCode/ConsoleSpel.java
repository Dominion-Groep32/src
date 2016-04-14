package JavaCode;

import java.util.LinkedList;
import java.util.Scanner;

import sun.awt.image.ImageWatched.Link;

public class ConsoleSpel {
	

	public static void main(String[] args) {
		Speler speler1 = new Speler("Jens");
		GameEngine gameEngine = new GameEngine();
		gameEngine.dominionTitel();
		
		LinkedList<Kaart> startStapel = speler1.startKaarten();
		LinkedList<Kaart> aflegStapel = speler1.aflegStapel();
		
		speler1.trekHand(startStapel, 5);
		System.out.println("---------");
		speler1.toonLijst(speler1.aflegStapel());
		System.out.println("---------");
		speler1.maakHandLeeg();
		
		speler1.toonLijst(speler1.trekHand(speler1.startKaarten(), 6));
		
	
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		//TESTING AREA //
		/*
		speler1.GeefTypes(actieKaart);
		speler1.GeefTypes(geldKaart);
		
		*/
		
		
	}
}


