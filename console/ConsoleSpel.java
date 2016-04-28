package console;

import java.util.*;

import engine.ActieKaart;
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
			spel();
		}
		
	public void spel(){
		
		LinkedList<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.actieKaartenGenereren(), engine.getAndereKaarten());
		
		engine.maakSpelersAan(vraagSpelersNamen());
		
		while(engine.spelNogNietBeëindigd()){
			
			//deze for zorgt ervoor dat met 2 kan spelen
			for (int i = 0; i < 2; i++)
			{
				engine.veranderSpeler();
				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.Naam());
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().trekKaart(huidigeSpeler.trekStapel(), 5));
				printFunctie("Geef uw keuze");
				int keuze = geefKeuze(huidigeSpeler.kaartenInHand());
				keuzeSpeler(keuze,huidigeSpeler.kaartenInHand(),tafelKaarten,huidigeSpeler.aflegStapel());
				engine.maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
				printFunctie("de beurt is beëindigd");
				
				System.out.println("");
				
			}
					
			
		}
		
		
	}
	public String[] vraagSpelersNamen(){
		System.out.println("Geef de spelersnamen in : ");
		String spelers[] = new String[2];
		System.out.print("Eerste spelersnaam: ");
		spelers[1] = sc.nextLine();
		System.out.print("Tweede spelersnaam: ");
		spelers[0] = sc.nextLine();
		
		return spelers;
		
	}
		
	public void printFunctie(String tekst){
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
		System.out.println((getal+1)+": beëindig je beurt");
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
		int aankoop = 1;
		int actie = 1;
		
		switch (keuze) {
		case 1:
			LinkedList<Kaart> actieKaartenUitDrawHand = engine.controleerActieKaarten(kaartenInHand);
			printFunctie("Actiekaarten");
			toonLijst(actieKaartenUitDrawHand);
			Kaart gekozenKaart = voerActieKaartUit(actieKaartenUitDrawHand);
			
			ActieKaart actiekaart = (ActieKaart) gekozenKaart;
			actiekaart.actieUitvoeren(gekozenKaart, engine.geefHuidigeSpeler());
			
			
			
			
			
			break;
		
		case 2:
		
			koopActie(tafelKaarten, geld, aankoop, actie, aflegStapel);
			break;
			
		case 3:
			System.out.println("De beurt is beëindigd");
			System.out.println("");
			break;

		default:
			break;
		}
	}
	
	private void koopActie(LinkedList<Kaart> tafelKaarten, int geld, int aankoop, int actie, LinkedList<Kaart> aflegStapel) {
		printFunctie("");
		huidigeWaarden(geld, aankoop, actie);
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, geld);
		toonLijst(lijstWaarvanJeKanKopen);
		printFunctie("");
		while (geld >0){
			int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
			geld = geld - kost;
		}
		
		
		
	}
	
public int koopKaart(LinkedList<Kaart> lijstWaarvanJeKanKopen,LinkedList<Kaart> aflegStapel) {
	
		System.out.print("vul het nummer in van de kaart die je wilt kopen : ");
		int keuze = (sc.nextInt() - 1);
		
		while (keuze < 0 || keuze > lijstWaarvanJeKanKopen.size()) {
			System.out.println("Sorry geef een geldig getal in ");
			keuze = (sc.nextInt() - 1);
		}
		
		aflegStapel.add(lijstWaarvanJeKanKopen.get(keuze));	
		return lijstWaarvanJeKanKopen.get(keuze).kost();

	}

public Kaart voerActieKaartUit(LinkedList<Kaart> lijstVanActieKaarten) {
	
	System.out.print("vul het nummer in van de kaart die je wilt uitvoeren : ");
	int keuze = (sc.nextInt() - 1);
	while (keuze < 0 || keuze > lijstVanActieKaarten.size()) {
		System.out.println("Sorry geef een geldig getal in ");
		keuze = (sc.nextInt() - 1);
	}
	
	return lijstVanActieKaarten.get(keuze);
	

}


public void huidigeWaarden(int geld, int aankoop, int actie) {
	System.out.println("Geld:  " + geld);
	System.out.println("Aankoop: "+ aankoop);
	System.out.println("Actie: " + actie);
}


	
}
