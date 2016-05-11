package console;

import java.util.*;


import engine.GameEngine;
import engine.GeldKaart;
import engine.Kaart;
import engine.Speler;


public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	GameEngine engine = new GameEngine();
	private LinkedList<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.actieKaartenGenereren(), engine.getAndereKaarten());

	
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
		
		
		
		engine.maakSpelersAan(vraagSpelersNamen());
		
		while(engine.spelNogNietBeëindigd()){
			
			//deze for zorgt ervoor dat met 2 kan spelen
			for (int i = 0; i < 2; i++)
			{
				engine.veranderSpeler();
				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.geefNaam());
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().trekKaart(huidigeSpeler.trekStapel(), 5));
				printFunctie("Geef uw keuze");
				int keuze = geefKeuze(huidigeSpeler.kaartenInHand());
				while(engine.geefHuidigeSpeler().geefActie() >0){
					keuzeSpeler(keuze,huidigeSpeler.kaartenInHand(),tafelKaarten,huidigeSpeler.aflegStapel());
					engine.geefHuidigeSpeler().verminderActie(1);
					
				}
				
				//toonLijst(huidigeSpeler.kaartenInHand());
				engine.maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				System.out.println("");
				huidigeSpeler.herstelWaarden();
			}		
		}
		
		
	}
	public String[] vraagSpelersNamen(){
		System.out.println("Geef de spelersnamen in : ");
		String spelers[] = new String[2];
		System.out.print("Eerste spelersnaam: ");
		spelers[1] = sc.nextLine();
		//
		if (spelers[1] instanceof String)
	
		System.out.print("Tweede spelersnaam: ");
		spelers[0] = sc.nextLine();
		
		return spelers;
		
	}
	public void resetWaarden()
	{
		engine.geefHuidigeSpeler().vermeerderGeld(0);
		engine.geefHuidigeSpeler().vermeerderAankoop(1);
		engine.geefHuidigeSpeler().vermeerderActie(1);
	}
	
	public void printFunctie(String tekst){
			int lengte = 20 ;
			int tePrintenLijntjes = (lengte-tekst.length()/2);
			
			if (tePrintenLijntjes%2 != 0){tePrintenLijntjes++;}

			for (int i = 0; i < tePrintenLijntjes; i++) {System.out.print("-");}
			System.out.print(tekst);
			for (int i = 0; i < tePrintenLijntjes; i++) {System.out.print("-");}
			System.out.println();
		}
	
	public void toonLijst(LinkedList<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			System.out.println((i + 1) + ": " + lijst.get(i).naam());
		}
	}
	
	public int geefKeuze(LinkedList<Kaart> kaartenInHand) {
		int getal = 1;
		boolean tmp = false;
		
		if(engine.controleerActieKaarten(kaartenInHand).size()>0 & engine.geefHuidigeSpeler().geefActie()>0)
			{System.out.println("1: gebruik actiekaarten");
			System.out.println("Let op: u kan optie 1 niet meer kiezen als u eerst optie 2 neemt !");
			getal++;
			tmp = true;
			}
		
		System.out.println(getal+": gebruik geldkaarten");
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
		engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand(kaartenInHand));
		int geld = engine.geefHuidigeSpeler().geefGeld();
		
		switch (keuze) {
		case 1:
			LinkedList<Kaart> actieKaartenUitDrawHand = engine.controleerActieKaarten(kaartenInHand);
			printFunctie("Actiekaarten");
			toonLijst(actieKaartenUitDrawHand);
			Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
			
			engine.actieUitvoeren(gekozenKaart);
			tmpFunctie();
			break;
		
		case 2:
			
			koopActie(tafelKaarten, aflegStapel);
			break;
			
		case 3:
			System.out.println("De beurt is beëindigd");
			System.out.println("");
			break;

		default:
			break;
		}
	}
	
	private void koopActie(LinkedList<Kaart> tafelKaarten,LinkedList<Kaart> aflegStapel) {
		printFunctie("");
		huidigeWaarden(engine.geldInHand(engine.geefHuidigeSpeler().kaartenInHand()), engine.geefHuidigeSpeler().geefAankoop(), engine.geefHuidigeSpeler().geefActie());
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, engine.geldInHand(engine.geefHuidigeSpeler().kaartenInHand()));
		toonLijst(lijstWaarvanJeKanKopen);
		printFunctie("");
		
		while(engine.geefHuidigeSpeler().geefAankoop()>0)
		{
			int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
			engine.geefHuidigeSpeler().verminderGeld(kost);
			engine.geefHuidigeSpeler().verminderAankoop(1);
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

public Kaart kiesActiekaart(LinkedList<Kaart> lijstVanActieKaarten) {
	
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

public void tmpFunctie(){
	
	printFunctie("");
	huidigeWaarden(engine.geldInHand(engine.geefHuidigeSpeler().kaartenInHand()), engine.geefHuidigeSpeler().geefAankoop(), engine.geefHuidigeSpeler().geefActie());
	printFunctie("Kaarten in uw hand");
	toonLijst(engine.geefHuidigeSpeler().kaartenInHand());
	printFunctie("");
	int keuze = geefKeuze(engine.geefHuidigeSpeler().kaartenInHand());
	keuzeSpeler(keuze, engine.geefHuidigeSpeler().kaartenInHand(),tafelKaarten,engine.geefHuidigeSpeler().aflegStapel());
}



	
}


