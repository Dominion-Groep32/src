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
		LinkedList<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.actieKaartenGenereren(), engine.getAndereKaarten());
		
		while(engine.spelNogNietBe�indigd()){
			System.out.println("");
			layout("Nieuwe beurt");
			layout("Kaarten in uw hand");
			toonLijst(speler.trekKaart(speler.trekStapel(), 5));
			layout("Geef uw keuze");
			int keuze = geefKeuze(speler.kaartenInHand());
			keuzeSpeler(keuze, speler.kaartenInHand(),tafelKaarten,speler.aflegStapel());
			engine.maakKaartInHandLeeg(speler.kaartenInHand());
			layout("de beurt is be�indigd");
			System.out.println("");
			
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
		int getal = 1;
		boolean tmp = false;
		
		if(engine.controleerActieKaarten(kaartenInHand).size()>0)
			{System.out.println("1: gebruik actie Kaarten");
			getal++;
			tmp = true;
			}
		
		System.out.println(getal+": gebruik geld kaarten");
		System.out.println((getal+1)+": be�indig je beurt");
		System.out.print("geef een keuze in : ");
		
		int keuze = sc.nextInt();
		
		while (keuze < 0 || keuze > 3) {
			System.out.println("geef een correcte waarde in ");
			System.out.print("geef een keuze in : ");
			keuze = sc.nextInt();
		}
		if (tmp){return keuze;}
		else return keuze+1;
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
			koopActie(tafelKaarten, geld, aflegStapel);
			break;
			
		case 3:
			System.out.println("De beurt is be�indigd");
			System.out.println("");
			break;

		default:
			break;
		}
	}
	
	private void koopActie(LinkedList<Kaart> tafelKaarten, int geld, LinkedList<Kaart> aflegStapel) {
		layout("");
		System.out.println("Geld:  " + geld);
		layout("");
		System.out.println("je kunt de volgende kaarten kopen");
		layout("");
		LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, geld);
		toonLijst(lijstWaarvanJeKanKopen);
		layout("");
		for (int i = 0; i < 1; i++) {
			
			koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
		}
	}
	
public LinkedList<Kaart> koopKaart(LinkedList<Kaart> lijst,LinkedList<Kaart> aflegStapel) {
		
		System.out.print("vul het nummer in van de kaart die je wilt kopen : ");
		int keuze = (sc.nextInt() - 1);
		
		while (keuze < 0 || keuze > lijst.size()) {
			System.out.println("Sorry geef een geldig getal in ");
			keuze = (sc.nextInt() - 1);
		}
		
		aflegStapel.add(lijst.get(keuze));
		
		
		return aflegStapel;
	
	}


	
}
