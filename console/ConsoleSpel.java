package console;

import java.util.*;

<<<<<<< HEAD

import engine.GameEngine;

=======
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.PrecedingIterator;

import engine.ActieKaart;
import engine.GameEngine;
>>>>>>> origin/master
import engine.Kaart;
import engine.Speler;


public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	GameEngine engine = new GameEngine();
	private LinkedList<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.actieKaartenGenereren(), engine.getAndereKaarten());
	private int aankoop = 1;
	private int actie = 1;
	private int geld = 0;
	
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
				printFunctie("Nu aan de beurt: "+huidigeSpeler.getNaam());
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().trekKaart(huidigeSpeler.trekStapel(), 5));
				printFunctie("Geef uw keuze");
				int keuze = geefKeuze(huidigeSpeler.kaartenInHand());
				while(this.actie >0){
					keuzeSpeler(keuze,huidigeSpeler.kaartenInHand(),tafelKaarten,huidigeSpeler.aflegStapel());
					this.actie--;
				}
				
				
				
				//toonLijst(huidigeSpeler.kaartenInHand());
				engine.maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
				printFunctie("de beurt is beëindigd");
				System.out.println("");
				resetWaarden();
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
		this.geld =0;
		this.actie = 1;
		this.aankoop = 1;
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
		
		if(engine.controleerActieKaarten(kaartenInHand).size()>0 & actie>0)
			{System.out.println("1: gebruik actiekaarten");
			getal++;
			tmp = true;
			}
		
<<<<<<< HEAD
		/*
		if (engine.geefHuidigeSpeler().geefGeld() > 0)
		{	
			System.out.println(getal+": gebruik geldkaarten");
			tmp2 = true;
		}
		*/
		
=======
>>>>>>> origin/master
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
		int geld = engine.geldInHand(kaartenInHand);
		
		
		switch (keuze) {
		case 1:
			LinkedList<Kaart> actieKaartenUitDrawHand = engine.controleerActieKaarten(kaartenInHand);
			printFunctie("Actiekaarten");
			toonLijst(actieKaartenUitDrawHand);
			Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
			actieUitvoeren(gekozenKaart, engine.geefHuidigeSpeler());
			
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
		huidigeWaarden(engine.geldInHand(engine.geefHuidigeSpeler().kaartenInHand()), aankoop, actie);
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		LinkedList<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, engine.geldInHand(engine.geefHuidigeSpeler().kaartenInHand()));
		toonLijst(lijstWaarvanJeKanKopen);
		printFunctie("");
		
		while(this.aankoop>0)
		{
			int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel);
			this.geld = this.geld - kost;
			this.aankoop--;
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

public void actieUitvoeren(Kaart kaart , Speler speler) {
	this.actie--;
	speler.kaartenInHand().remove(kaart);
	switch (kaart.naam()) {
	
	case "smidse":
		
		speler.trekKaart(speler.trekStapel(), 3);
		break;
		
	case "troonzaal":
		speler.trekKaart(speler.trekStapel(), 4);
		aankoop++;
		break;
		
	case "festival":
		actie =+ 2;
		aankoop++;
		geld =+2;
		break;
	
	case "laboratorium":
		speler.trekKaart(speler.trekStapel(), 2);
		actie++;
		break;
		
	case "markt":
		speler.trekKaart(speler.trekStapel(), 1);
		actie++;
		aankoop++;
		geld++;
		break;

	default:
		break;
		
	}
	huidigeWaarden(geld, aankoop, actie);
	printFunctie("");
	printFunctie("Kaarten in uw hand");
	toonLijst(speler.kaartenInHand());
	printFunctie("");
	int keuze = geefKeuze(speler.kaartenInHand());
	keuzeSpeler(keuze, speler.kaartenInHand(),tafelKaarten,speler.aflegStapel());
	
}
	
}
