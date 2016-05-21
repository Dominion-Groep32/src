package console;

import java.util.*;
import engine.*;


//test
public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	SpelFuncties engine = new SpelFuncties();
	
	

	
	public static void main(String[] args) {
		ConsoleSpel console = new ConsoleSpel();
		
	}
	
	public ConsoleSpel(){
		System.out.println("----------------------------------WELKOM BIJ DOMINION------------------------------------");
		spel();
	}
	
		
	public void spel(){

		
		engine.maakSpelersAan(vraagSpelersNamen(vraagAantalSpelers()));
	
		while(engine.spelNogNietBeëindigd()){
			
				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.geefNaam());
				toonKaartenInHand();
				engine.brengAlleKaartenNaarAflegstapel();
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				engine.trekKaartVanTrekStapel(5);
				huidigeSpeler.herstelWaarden();
				engine.volgendeSpeler();
		}
		printFunctie("GAME OVER");
		//TO DO: scores geven
		
	}
	public int vraagAantalSpelers()
	{
		System.out.print("Met hoeveel spelers wilt u spelen? ");
		int keuze = sc.nextInt();
		while(keuze <0 || keuze>4)
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
			System.out.println((i + 1) + ": " + lijst.get(i).geefNaam());
		}
	}
	

	private int geefKeuze() {
		int getal = 1;
		boolean tmp = false;
		
		if(engine.neemActiekaartenUitHand().size()>0 && engine.geefHuidigeSpeler().geefActie()>0)
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
	
	
	
	private void keuzeSpeler(int keuze) {
		engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand());
		
		switch (keuze) {
		case 1:
			speelActie();
			break;
		
		case 2:
			koopActie();
			break;
			
		default:
			break;
		}
	}
	
	private void speelActie() {
		List<Kaart> actieKaartenUitDrawHand = engine.neemActiekaartenUitHand();
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand);
		vragenNaarInfoOverKaarten(actieKaartenUitDrawHand);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		if(engine.actieUitvoeren(gekozenKaart)){extraInputActiekaarten(gekozenKaart);};
		toonKaartenInHand();
	}
	
	private void koopActie() {
		Speler speler = engine.geefHuidigeSpeler();
		engine.brengAlleGeldkaartenUitHandNaarStapel(speler.geefSpeelGebied());
		printhuidigeWaarden();
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		toonLijst(engine.kaartenDieJeKuntKopen());
		vragenNaarInfoOverKaarten(engine.kaartenDieJeKuntKopen());
		int kost = koopKaart().geefKost();
		speler.verminderGeld(kost);
		speler.verminderAankoop(1);
		
	}
	
	private int kaartnummerInvullen(String kopenOfWetenOfSpelen) {
	printFunctie("");
	System.out.print("vul het nummer in van de kaart die je wilt "+kopenOfWetenOfSpelen+" : "); 
	return sc.nextInt();
}

	private Kaart koopKaart() {
	
		int keuze = kaartnummerInvullen("kopen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, engine.kaartenDieJeKuntKopen().size());
		engine.brengGekochteKaartNaarAflegstapel(engine.kaartenDieJeKuntKopen().get(gecontroleerdekeuze));
		
		return engine.kaartenDieJeKuntKopen().get(gecontroleerdekeuze);

	}

	private Kaart kiesActiekaart(List<Kaart> lijstVanActieKaarten) {
	
		int keuze = kaartnummerInvullen("spelen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, lijstVanActieKaarten.size());
		engine.brengEenKaartVanDeEneNaarAndereStapel(engine.geefHuidigeSpeler().geefKaartenInHand(), lijstVanActieKaarten.get(gecontroleerdekeuze),engine.geefHuidigeSpeler().geefSpeelGebied() );
		return lijstVanActieKaarten.get(gecontroleerdekeuze);
}


	private void printhuidigeWaarden() {
		printFunctie("huidige waarden");
		System.out.println("Geld:  " + engine.geefHuidigeSpeler().geefGeld());
		System.out.println("Aankoop: "+ engine.geefHuidigeSpeler().geefAankoop());
		System.out.println("Actie: " + engine.geefHuidigeSpeler().geefActie());
		if(engine.geefHuidigeSpeler().geefSpeelGebied().size()>0){
		printFunctie("Kaarten in Speelveld");
		toonLijst(engine.geefHuidigeSpeler().geefSpeelGebied());}
		
}


	private void toonKaartenInHand(){
		Speler huidigeSpeler = engine.geefHuidigeSpeler();
		printhuidigeWaarden();
		printFunctie("Kaarten in uw hand");
		toonLijst(huidigeSpeler.geefKaartenInHand());
		printFunctie("");
		int keuze = geefKeuze();
		while(engine.geefHuidigeSpeler().geefActie() >0&&engine.geefHuidigeSpeler().geefAankoop()>0)
		{
		keuzeSpeler(keuze);
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
		System.out.println(gekozenKaart.geefNaam()+" : "+gekozenKaart.geefInfo());
		vragenNaarInfoOverKaarten(lijstMetKaarten);
}
private void extraInputActiekaarten(Kaart actiekaart) {
		switch (actiekaart.geefNaam()) {
		case "bureaucraat":
			//nog controleren op overwinningskaarten in hand zo niet stap overslaan
			// zo ja, als er een keuze gemaakt wordt, kijken of dit het type overwinningskaart heeft
			Speler huidigeSpeler = engine.geefHuidigeSpeler();
			Speler[] spelers = engine.geefLijstSpelers();
			for (int i = 0; i < engine.geefLijstSpelers().length; i++){
				if(spelers[i].geefNaam() != huidigeSpeler.geefNaam()){
					engine.AndereSpelers(i);
					printFunctie("Nu aan de beurt: "+engine.geefHuidigeSpeler().geefNaam());
					printFunctie("Kaarten in uw hand");
					toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
					System.out.println("trek een overwinningskaart uit uw hand en leg deze op de aftrekstapel.");
					
					int keuze = printGeefKeuze();
					engine.brengEenKaartVanDeEneNaarAndereStapel(engine.geefHuidigeSpeler().geefKaartenInHand(), engine.geefHuidigeSpeler().geefKaartenInHand().get(keuze), engine.geefHuidigeSpeler().geefAflegStapel());};}
			engine.zetHuidigeSpeler(huidigeSpeler);
			printFunctie("Nu aan de beurt: "+engine.geefHuidigeSpeler().geefNaam());
			break;
		case "kelder":
			printFunctie("Kaarten in uw hand");
			toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
			printFunctie("");
			System.out.println("Hoeveel kaarten wenst u af te leggen?:");
			int aantal = sc.nextInt();
			for (int i = 0; i < aantal; i++) {
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
				System.out.println("Geef de kaartnummer:");
				int keuze = sc.nextInt();
				engine.geefHuidigeSpeler().geefAflegStapel().add(engine.geefHuidigeSpeler().geefKaartenInHand().get(keuze));
				engine.geefHuidigeSpeler().geefKaartenInHand().remove(keuze);
			}
			engine.trekKaartVanTrekStapel(aantal);
		case "":
		default:
			break;
		}
		engine.actieFase2Uitvoeren(actiekaart);
	}
}


