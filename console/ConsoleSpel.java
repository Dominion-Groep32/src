package console;

import java.util.*;



import engine.*;



//test
public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	SpelFuncties engine = new SpelFuncties();
	private ExtraInfo extraInfoHalen;
	List<ExtraInfo> extraInfoGeven = new LinkedList<ExtraInfo>();
	
	

	
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
				kiezen();
				engine.brengAlleKaartenNaarAflegstapel();
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is beëindigd");
				engine.trekKaartVanTrekStapel(5);
				huidigeSpeler.herstelWaarden();
				engine.volgendeSpeler();
		}
		printFunctie("GAME OVER");
		engine.berekenScoreSpelers();
		printUitslag();
		
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
	

	private int keuzeMenu() {
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
	
	private Kaart speelActie() {
		List<Kaart> actieKaartenUitDrawHand = engine.neemActiekaartenUitHand();
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand);
		vragenNaarInfoOverKaarten(actieKaartenUitDrawHand);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		ExtraInfo kaartMetExtraInfo = engine.actieUitvoeren(gekozenKaart);
		if(kaartMetExtraInfo!= null){extraInputActiekaarten(kaartMetExtraInfo);};
		kiezen();
		return gekozenKaart;
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
		
		printhuidigeWaarden();
		printFunctie("Kaarten in uw hand");
		toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
		printFunctie("");
		
		
}
	private void kiezen(){
	
	while(engine.geefHuidigeSpeler().geefActie() >0 || engine.geefHuidigeSpeler().geefAankoop()>0)
	{
	toonKaartenInHand();
	int keuze = keuzeMenu();	
	keuzeSpeler(keuze);
	engine.geefHuidigeSpeler().verminderActie(1);
	}}

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
	
private List<ExtraInfo> vragenNaarVerschillendeKaartenUitHand(Kaart actiekaart,int maxAantal,String tekst){
	
	printFunctie("Kaarten in uw hand");
	toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
	printFunctie("");
	System.out.print(tekst);
	int aantal = sc.nextInt();
	controleKeuze(aantal, maxAantal);
	for (int i = 1; i < aantal; i++) {
		printFunctie("Kaarten in uw hand");
		toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
		System.out.print("Geef het kaartnummer:");
		int keuze = (sc.nextInt()-1);
		extraInfoGeven.add(new ExtraInfo(actiekaart, keuze, aantal));	
	}
	return extraInfoGeven;
}
private List<ExtraInfo> extraInputActiekaarten(ExtraInfo actiekaart) {
		
		switch (actiekaart.geefActiekaart().geefNaam()) {
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
					System.out.println("Trek een overwinningskaart uit uw hand.");
					int keuze = printGeefKeuze();
					extraInfoGeven.add(new ExtraInfo(actiekaart.geefActiekaart(),i, keuze));
					engine.brengEenKaartVanDeEneNaarAndereStapel(engine.geefHuidigeSpeler().geefKaartenInHand(), engine.geefHuidigeSpeler().geefKaartenInHand().get(keuze), engine.geefHuidigeSpeler().geefAflegStapel());};}
			engine.zetHuidigeSpeler(huidigeSpeler);
			printFunctie("Nu aan de beurt: "+engine.geefHuidigeSpeler().geefNaam());
			break;
		case "kelder":
			vragenNaarVerschillendeKaartenUitHand(actiekaart.geefActiekaart(),actiekaart.geefAantalKaartenUitHandNemen(),extraInfoHalen.geefBericht());
			break;
		case "kapel":
			vragenNaarVerschillendeKaartenUitHand(actiekaart.geefActiekaart(),actiekaart.geefAantalKaartenUitHandNemen(),"Hoeveel kaarten wenst u te vernietigen?:");
			break;
		case "feest":
			printhuidigeWaarden();
			printFunctie("");
			System.out.println("je kunt de volgende kaarten kopen");
			printFunctie("");
			toonLijst(engine.kaartenDieJeKuntKopen());
			vragenNaarInfoOverKaarten(engine.kaartenDieJeKuntKopen());
			int keuze = kaartnummerInvullen("kopen")-1;
			int gecontroleerdekeuze = controleKeuze(keuze, engine.kaartenDieJeKuntKopen().size());
			ExtraInfo info = new ExtraInfo(actiekaart.geefActiekaart(),gecontroleerdekeuze);
			break;
		case "militie":
			printFunctie("Kaarten in uw hand");
			toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
			printFunctie("");
			System.out.print("Verminder uw kaarten in hand tot 3 kaarten!");
			while(engine.geefHuidigeSpeler().geefKaartenInHand().size()>3) {
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
				System.out.print("Geef het kaartnummer:");
				int keuze = (sc.nextInt()-1);
				engine.geefHuidigeSpeler().geefAflegStapel().add(engine.geefHuidigeSpeler().geefKaartenInHand().get(keuze));
				engine.geefHuidigeSpeler().geefKaartenInHand().remove(keuze);
			}
			break;
		case "geldschieter":
			//als er geldkaarten in hand zijn
			int aantalVernietigdeKaarten = vragenNaarKaartenUitHand(1,"Hoeveel koperkaarten wenst u te vernietigen?(max 1):", engine.geefHuidigeSpeler().geefVuilbakStapel());
			if( aantalVernietigdeKaarten ==1){engine.geefHuidigeSpeler().vermeerderGeld(3);}
			break;
		
		case "verbouwing":
			//int aantalVernietigdeKaarten = vragenNaarKaartenUitHand(1, "Hoeveel kaarten wenst u te vernietigen?: (max 1)", engine.geefHuidigeSpeler().geefVuilbakStapel());
			//mss met een obj werken die in bovenstaande functie aantal + kaart weergeeft
			//if(aantalVernietigdeKaarten == 1){engine.geefHuidigeSpeler().vermeerderGeld(kaart);
			printFunctie("Kaarten in uw hand");
			toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
			printFunctie("");
			System.out.print("Hoeveel kaarten wenst u te vernietigen?: (max 1)");
			int keuze = sc.nextInt();
			controleKeuze(keuze, 1);
			if(keuze==1){			
				printFunctie("Kaarten in uw hand");
				toonLijst(engine.geefHuidigeSpeler().geefKaartenInHand());
				System.out.print("Geef het kaartnummer:");
				int keuzeKaart = (sc.nextInt()-1);
				Kaart kaart = engine.geefHuidigeSpeler().geefKaartenInHand().get(keuzeKaart);
				engine.geefHuidigeSpeler().geefVuilbakStapel().add(kaart);
				engine.geefHuidigeSpeler().geefKaartenInHand().remove(keuze);
				engine.geefHuidigeSpeler().vermeerderGeld(kaart.geefKost());
			}			
			break;
		case "troonzaal":
			Kaart gekozenkaart = speelActie();
			ExtraInfo info = new ExtraInfo(actiekaart,gekozenkaart);
			break;
				
		default:
			break;}
		
		engine.actieFase2Uitvoeren(extraInfoGeven);
	}
private void printUitslag() {
	printFunctie("Uitlag");
	Speler[] spelers = engine.geefLijstSpelers();
	for (int i = 0; i < spelers.length; i++) {
		
		System.out.println(i+":"+spelers[i].geefNaam()+" -- score: "+spelers[i].geefScore());
	}
}
}


