package JavaCode;

import java.util.*;

public class ConsoleSpel {

	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		Speler jens = new Speler("Jens");
		LinkedList<Kaart> aflegStapel = gameEngine.aflegStapel();
		LinkedList<Kaart> trekstapel = jens.trekStapel();
		
		
		gameEngine.dominionTitel();

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
		 
		
		
		
		/*
		 * BENODIGDHEDEN
		 *  kaarten kunnen trekken -> indien het gevraagde aantal niet aanwezig is de lijst samenvoegen met de lijst van reeds wegelegde kaarten
		 * de kaarten kunnen tonen
		 * nadat je ze toont de kaarten in hand kunnen weg leggen -> geimplementeerd in kaarten trekken
		 * een lijst leegmaken 
		 * 
		 * next step : 
		 * een beurt ontwikkelen
		 * wat heeft een beurt:
		 * per beurt krijg je een drawhand 
		 * de eerste stap na die drawhand is dat je kan kiezen om actiekaarten uit te voeren -> dit nog niet in detail uitwerken
		 * de 2de stap : de geldkaarten selecteren 
		 * en de 3de stap nadat je de geldkaarten geselecteerd hebt een lijst opmaken van welke kaarten je kan kopen en die kaart toevoegen aan je aflegstapel
		 * hierna de beurt beeindigen 
		 */


	}
}
