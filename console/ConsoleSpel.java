package console;

import java.util.*;

import engine.GameEngine;
import engine.Kaart;
import engine.Speler;


public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	GameEngine engine = new GameEngine();
	

	public static void main(String[] args) {
		
		ConsoleSpel console = new ConsoleSpel();
		console.run();
		
		
		
	
	}
	public ConsoleSpel(){
	}
	
		public void run() {
			System.out.println("----------------------------------WELKOM BIJ DOMINION------------------------------------");
			//aantal spelers?
			//Speler speler = new Speler("jos");
			
			spel();
			
			
					
		}
	public void spel(){
		
		//stap 1: wie is er aan de beurt?
		Speler speler = new Speler("jos");
		//stap 2: welke kaarten heb je in je hand?
		LinkedList<Kaart> trekstapelPerSpeler = speler.trekStapel();
		LinkedList<Kaart> aflegstapelPerSpeler = speler.aflegStapel();
		LinkedList<Kaart> kaartenInHandPerSpeler = speler.kaartenInHand();
		LinkedList<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.actieKaartenGenereren(), engine.getAndereKaarten());
		
		while(true){
			
			layout("Kaarten in uw hand");
			kaartenInHandPerSpeler = speler.trekKaart(trekstapelPerSpeler, 5);
			toonLijst(kaartenInHandPerSpeler);
			layout("Geef uw keuze");
			int keuze = geefKeuze(kaartenInHandPerSpeler);
			keuzeSpeler(keuze, kaartenInHandPerSpeler,tafelKaarten,aflegstapelPerSpeler);
			engine.maakKaartInHandLeeg(kaartenInHandPerSpeler);
			layout("de beurt is beëindigd");
			
		}
		
		
	}
		
	public void layout(String tekst){
			System.out.println("--------"+tekst+"-----------");
		}
	public void toonLijst(LinkedList<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			System.out.println((i + 1) + ": " + lijst.get(i).naam());
		}
	}
	public int geefKeuze(LinkedList<Kaart> kaartenInHand) {
		System.out.println("1: gebruik actie Kaarten");
		System.out.println("2: gebruik geld kaarten");
		System.out.println("3: beëindig je beurt");
		System.out.print("geef een keuze in : ");

		int keuze = sc.nextInt();

		while (keuze < 0 || keuze > 3) {
			System.out.println("geef een correcte waarde in ");
			System.out.print("geef een keuze in : ");
			keuze = sc.nextInt();
		
		}
		
		return keuze;
	}
	
	public void keuzeSpeler(int keuze, LinkedList<Kaart> kaartenInHand, LinkedList<Kaart> tafelKaarten,LinkedList<Kaart> aflegStapel) {
		int geld = engine.geldInHand(kaartenInHand);
		switch (keuze) {
		case 1:
			LinkedList<Kaart> actieKaartenUitDrawHand = engine.controleerActieKaarten(kaartenInHand);
			layout("Actiekaarten");
			toonLijst(actieKaartenUitDrawHand);
			break;
		
		case 2:
			
			layout("");
			System.out.println("Geld:  " + geld);
			layout("");
			System.out.println("je kunt de volgende kaarten kopen");
			layout("");
			LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, geld);
			toonLijst(lijstWaarvanJeKanKopen);
			layout("");
			for (int i = 0; i < 1; i++) {
				
				engine.koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
			}
			break;
			
		case 3:
			System.out.println("De beurt is beëindigd");
			break;

		default:
			break;
		
			
		}
	}


	
}
