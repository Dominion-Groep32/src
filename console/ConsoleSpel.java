package console;

import java.util.*;
import engine.*;



public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	GameEngine engine = new GameEngine();
	private List<Kaart> tafelKaarten = engine.lijstenSamenvoegenZonderShuffle(engine.kaartenInitialiseren(), engine.lijstGeldEnOverwinningskaarten());
	

	
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
			
				
				engine.veranderSpeler();
				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.geefNaam());
				toonKaartenInHand(engine.geefHuidigeSpeler().trekKaart(huidigeSpeler.trekStapel(), 5));
				engine.brengKaartenInHandNaarAflegstapel(huidigeSpeler.kaartenInHand(), huidigeSpeler.aflegStapel());
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				System.out.println("");
				huidigeSpeler.herstelWaarden();	
		}
		
		
	}
	public String[] vraagSpelersNamen(){
		System.out.println("Geef de spelersnamen in  ");
		String spelers[] = new String[2];
		System.out.print("Eerste spelersnaam: ");
		spelers[0] = sc.nextLine();
	
		System.out.print("Tweede spelersnaam: ");
		spelers[1] = sc.nextLine();
		
		
		return spelers;
		
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
	
	public void toonLijst(List<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			System.out.println((i + 1) + ": " + lijst.get(i).naam());
		}
	}
	

	public int geefKeuze(List<Kaart> kaartenInHand) {
		int getal = 1;
		boolean tmp = false;
		
		if(engine.neemActiekaartenUitHand(kaartenInHand).size()>0 && engine.geefHuidigeSpeler().geefActie()>0)
			{System.out.println("Let op: u kan optie 1 niet meer kiezen als u eerst optie 2 neemt !");
			System.out.println("1: gebruik actiekaarten");
			
			getal++;
			tmp = true;
			}
		
		System.out.println(getal+": gebruik geldkaarten");
		System.out.println((getal+1)+": beëindig je beurt");
		int keuze = printGeefKeuze();
		
		if (tmp){int gecontroleerdeKeuze = controleKeuze(keuze,3);
		return gecontroleerdeKeuze;
		}
		else {int gecontroleerdeKeuze = controleKeuze(keuze,2);
			return gecontroleerdeKeuze+1;}
	}
	
	
	
	public void keuzeSpeler(int keuze, List<Kaart> kaartenInHand, List<Kaart> tafelKaarten, List<Kaart> aflegStapel) {
		engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand(kaartenInHand));
		
		switch (keuze) {
		case 1:
			speelActie(kaartenInHand);
			break;
		
		case 2:
			koopActie(tafelKaarten, aflegStapel);
			break;
			
		default:
			break;
		}
	}
	private void speelActie(List<Kaart>kaartenInHand) {
		List<Kaart> actieKaartenUitDrawHand = engine.neemActiekaartenUitHand(kaartenInHand);
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand);
		vragenNaarInfoOverKaarten(actieKaartenUitDrawHand);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		engine.actieUitvoeren(gekozenKaart);
		toonKaartenInHand(engine.geefHuidigeSpeler().kaartenInHand());
	}
	
	private void koopActie(List<Kaart> tafelKaarten,List<Kaart> aflegStapel) {
		Speler speler = engine.geefHuidigeSpeler();
	
		printFunctie("");
		huidigeWaarden();
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		List<Kaart> lijstWaarvanJeKanKopen = engine.kaartenDieJeKuntKopen(tafelKaarten, engine.geldInHand(speler.kaartenInHand()));
		toonLijst(lijstWaarvanJeKanKopen);
		vragenNaarInfoOverKaarten(lijstWaarvanJeKanKopen);
		while(speler.geefAankoop()>0)
		{
			int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel).kost();
			speler.verminderGeld(kost);
			speler.verminderAankoop(1);
		}
	}
	
private int kaartnummerInvullen(String kopenOfWetenOfSpelen) {
	printFunctie("");
	System.out.print("vul het nummer in van de kaart die je wilt "+kopenOfWetenOfSpelen+" : "); 
	return sc.nextInt();
}

public Kaart koopKaart(List<Kaart> lijstWaarvanJeKanKopen,List<Kaart> aflegStapel) {
	
		int keuze = kaartnummerInvullen("kopen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, lijstWaarvanJeKanKopen.size());
		aflegStapel.add(lijstWaarvanJeKanKopen.get(gecontroleerdekeuze));
		engine.verminderStapel(lijstWaarvanJeKanKopen.get(gecontroleerdekeuze).naam());
		return lijstWaarvanJeKanKopen.get(gecontroleerdekeuze);

	}

public Kaart kiesActiekaart(List<Kaart> lijstVanActieKaarten) {
	
	int keuze = kaartnummerInvullen("spelen")-1;
	int gecontroleerdekeuze = controleKeuze(keuze, lijstVanActieKaarten.size());
	return lijstVanActieKaarten.get(gecontroleerdekeuze);
}


public void huidigeWaarden() {
	System.out.println("Geld:  " + engine.geefHuidigeSpeler().geefGeld());
	System.out.println("Aankoop: "+ engine.geefHuidigeSpeler().geefAankoop());
	System.out.println("Actie: " + engine.geefHuidigeSpeler().geefActie());
}


private void toonKaartenInHand(List<Kaart> kaartenInHand){
	Speler huidigeSpeler = engine.geefHuidigeSpeler();
	huidigeWaarden();
	printFunctie("Kaarten in uw hand");
	toonLijst(kaartenInHand);
	printFunctie("");
	int keuze = geefKeuze(huidigeSpeler.kaartenInHand());
	while(engine.geefHuidigeSpeler().geefActie() >0)
	{
		keuzeSpeler(keuze,huidigeSpeler.kaartenInHand(),tafelKaarten,huidigeSpeler.aflegStapel());
		huidigeSpeler.verminderActie(1);
	}
}


private void vragenNaarInfoOverKaarten(List<Kaart>lijstMetKaarten) {
	printFunctie("");
	System.out.println("Wenst u informatie over bepaalde actiekaarten?");
	System.out.println("1: Ja");
	System.out.println("2: Nee");
	int keuze = printGeefKeuze();
	int gecontroleerdeKeuze = controleKeuze(keuze, 2);
<<<<<<< HEAD
	if (gecontroleerdeKeuze==1 && lijstMetKaarten.size()>1){
=======
	if (gecontroleerdeKeuze==1 && lijstMetKaarten.size()>0){
>>>>>>> 29d5d733b6fc822189949c24c9fcc3f28909e866
		int kaartKeuze = kaartnummerInvullen("weten");
		int gecontroleerdeKaartKeuze = controleKeuze(kaartKeuze, lijstMetKaarten.size());
		geefInfoOverKaarten(gecontroleerdeKaartKeuze,lijstMetKaarten);
	}
	if(gecontroleerdeKeuze == 1 && lijstMetKaarten.size()==1){
		geefInfoOverKaarten(1, lijstMetKaarten);
	}
	
}


private int controleKeuze(int keuze, int max) {
	while (keuze < 0 || keuze > max) {
		System.out.println("geef een waarde in tussen 1 en " + max +" :");
		keuze = sc.nextInt();
	}
	return keuze;
}

private int printGeefKeuze() {
	System.out.print("geef een keuze in : ");
	 return sc.nextInt();
}
private void geefInfoOverKaarten(int kaartKeuze, List<Kaart> lijstMetKaarten) {
	Kaart gekozenKaart = lijstMetKaarten.get(kaartKeuze-1);
	System.out.println(gekozenKaart.naam()+" : "+gekozenKaart.info());
	vragenNaarInfoOverKaarten(lijstMetKaarten);
}
}


