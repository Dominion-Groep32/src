package console;

import java.util.*;

import engine.ActieKaart;
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
				engine.maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				System.out.println("");
				huidigeSpeler.herstelWaarden();
			}		
		}
		
		
	}
	public String[] vraagSpelersNamen(){
		System.out.println("Geef de spelersnamen in  ");
		String spelers[] = new String[2];
		System.out.print("Eerste spelersnaam: ");
		spelers[1] = sc.nextLine();
		
		while (!(spelers[1] instanceof String))
		{System.out.print("geef een geldige naam in :");
		spelers[1] = sc.nextLine();}
		
	
		System.out.print("Tweede spelersnaam: ");
		spelers[0] = sc.nextLine();
		while (!(spelers[0] instanceof String))
		{System.out.print("geef een geldige naam in :");
		spelers[0] = sc.nextLine();}
		
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
		boolean tmp2 = false;
		
		if(engine.controleerActieKaarten(kaartenInHand).size()>0 & engine.geefHuidigeSpeler().geefActie()>0)
			{System.out.println("Let op: u kan optie 1 niet meer kiezen als u eerst optie 2 neemt !");
			System.out.println("1: gebruik actiekaarten");
			
			getal++;
			tmp = true;
			}
		/*
		if (engine.geefHuidigeSpeler().geefGeld() > 0)
		{	
			System.out.println(getal+": gebruik geldkaarten");
			tmp2 = true;
		}
		*/
		System.out.println(getal+": gebruik geldkaarten");
		
		System.out.println((getal+1)+": beëindig je beurt");
	
		
		System.out.print("geef een keuze in : ");
		
		
		int keuze = sc.nextInt();
		
		//oplossing zoeken
		
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
			
		default:
			break;
		}
	}
	
	private void koopActie(LinkedList<Kaart> tafelKaarten,LinkedList<Kaart> aflegStapel) {
		Speler speler = engine.geefHuidigeSpeler();
	
		printFunctie("");
		huidigeWaarden();
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, engine.geldInHand(speler.kaartenInHand()));
		toonLijst(lijstWaarvanJeKanKopen);
		printFunctie("");
		
		while(engine.geefHuidigeSpeler().geefAankoop()>0)
		{
			int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
			speler.verminderGeld(kost);
			speler.verminderAankoop(1);
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


public void huidigeWaarden() {
	System.out.println("Geld:  " + engine.geefHuidigeSpeler().geefGeld());
	System.out.println("Aankoop: "+ engine.geefHuidigeSpeler().geefAankoop());
	System.out.println("Actie: " + engine.geefHuidigeSpeler().geefActie());
	
	
}

public void tmpFunctie(){
	Speler speler = engine.geefHuidigeSpeler();
	
	printFunctie("");
	huidigeWaarden();
	printFunctie("Kaarten in uw hand");
	toonLijst(speler.kaartenInHand());
	printFunctie("");
	int keuze = geefKeuze(speler.kaartenInHand());
	keuzeSpeler(keuze, speler.kaartenInHand(),tafelKaarten,speler.aflegStapel());
}



	
}


