package console;

import java.util.*;
import engine.*;



public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	SpelFuncties engine = new SpelFuncties();
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


		engine.maakSpelersAan(vraagSpelersNamen(vraagAantalSpelers()));
	
		while(engine.spelNogNietBeëindigd()){
			
				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.geefNaam());
				toonKaartenInHand(engine.trekKaart(huidigeSpeler.trekStapel(), 5));
				engine.brengKaartenInHandNaarAflegstapel(huidigeSpeler.kaartenInHand(), huidigeSpeler.aflegStapel());
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				System.out.println("");
				huidigeSpeler.herstelWaarden();
				engine.volgendeSpeler();
		}
		
		
	}
	public int vraagAantalSpelers()
	{
		System.out.print("Met hoeveel spelers wilt u spelen? ");
		int keuze = sc.nextInt();
		while(keuze <0)
		{
			System.out.println("geef een geldige keuze in");
			keuze = sc.nextInt();
		}
		sc.nextLine();
		System.out.println("");
		return keuze;
	}
	public String[] vraagSpelersNamen(int aantalSpelers){
		String spelers[] = new String[aantalSpelers];
		System.out.println("Geef de spelersnamen in  ");
		
		for (int i = 0; i < aantalSpelers; i++) {
			System.out.print(i+" :");
			spelers[i] = sc.nextLine();
		
		}

		return spelers;
		
	}
	
	private void printFunctie(String tekst){
		int lengte = 20 ;
		int tePrintenLijntjes = (lengte-tekst.length()/2);
		if (tePrintenLijntjes%2 != 0){tePrintenLijntjes++;}

		for (int i = 0; i < tePrintenLijntjes; i++) {System.out.print("-");}
		System.out.print(tekst);
		for (int i = 0; i < tePrintenLijntjes; i++) {System.out.print("-");}
		System.out.println();
		}
	
	private void toonLijst(List<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			System.out.println((i + 1) + ": " + lijst.get(i).naam());
		}
	}
	

	private int geefKeuze(List<Kaart> kaartenInHand) {
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
	
	
	
	private void keuzeSpeler(int keuze, List<Kaart> kaartenInHand, List<Kaart> tafelKaarten, List<Kaart> aflegStapel) {
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
		int kost = koopKaart(lijstWaarvanJeKanKopen,aflegStapel).kost();
		speler.verminderGeld(kost);
		speler.verminderAankoop(1);
		
	}
	
	private int kaartnummerInvullen(String kopenOfWetenOfSpelen) {
	printFunctie("");
	System.out.print("vul het nummer in van de kaart die je wilt "+kopenOfWetenOfSpelen+" : "); 
	return sc.nextInt();
}

	private Kaart koopKaart(List<Kaart> lijstWaarvanJeKanKopen,List<Kaart> aflegStapel) {
	
		int keuze = kaartnummerInvullen("kopen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, lijstWaarvanJeKanKopen.size());
		aflegStapel.add(lijstWaarvanJeKanKopen.get(gecontroleerdekeuze));
		engine.verminderStapel(lijstWaarvanJeKanKopen.get(gecontroleerdekeuze).naam());
		return lijstWaarvanJeKanKopen.get(gecontroleerdekeuze);

	}

	private Kaart kiesActiekaart(List<Kaart> lijstVanActieKaarten) {
	
		int keuze = kaartnummerInvullen("spelen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, lijstVanActieKaarten.size());
		return lijstVanActieKaarten.get(gecontroleerdekeuze);
}


	private void huidigeWaarden() {
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

		if (gecontroleerdeKeuze==1 && lijstMetKaarten.size()>1){

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


