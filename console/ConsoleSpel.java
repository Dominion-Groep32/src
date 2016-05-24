package console;

import java.util.*;


import engine.*;

public class ConsoleSpel {
	private Scanner sc = new Scanner(System.in);
	private SpelFuncties engine = new SpelFuncties();
	private ExtraInfo extraInfoGeven = null;
	private List<Speler> andereSpelers = engine.geefLijstAndereSpelers();
	private Speler[] alleSpelers = engine.geefLijstSpelers();
	private List<Kaart> gekozenKaarten = new LinkedList<Kaart>();
	private List<Integer> keuzesSpeler = new LinkedList<Integer>();
	private List<Speler> spelers = new LinkedList<Speler>();
	private List<Boolean> gebruikSlotgracht = new LinkedList<Boolean>();
	

	
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
				engine.trekKaartVanTrekStapel(huidigeSpeler,5);
				huidigeSpeler.herstelWaarden();
				engine.volgendeSpeler();
		}
		printFunctie("GAME OVER");
		engine.berekenScoreAlleSpelers();
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
			System.out.print((1+i)+" :");
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
	
	
	private void toonLijst(List<Kaart> lijst,boolean metInfo) {
		for (int i = 0; i < lijst.size(); i++) {
			if(metInfo){
			System.out.println((i + 1) + ": " + lijst.get(i).geefNaam()+": "+lijst.get(i).geefInfo());
		}
			else{System.out.println((i + 1) + ": " + lijst.get(i).geefNaam());}}
	}
	

	private int keuzeMenu() {
		int getal = 1;
		boolean tmp = false;
		
		if(engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(),"actiekaart").size()>0 && engine.geefHuidigeSpeler().geefActie()>0)
			{System.out.println("Let op: u kan optie 1 niet meer kiezen als u eerst optie 2 neemt !");
			System.out.println("1: gebruik actiekaarten");
			
			getal++;
			tmp = true;
			}
		if(engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), "geldkaart").size()>0){
		System.out.println(getal+": gebruik geldkaarten");}
		else{System.out.println(getal+": Koop koperkaart");}
		System.out.println((getal+1)+": beëindig je beurt");
		int keuze = printGeefKeuze();
		
		if (tmp){int gecontroleerdeKeuze = controleKeuze(keuze,3);
		return gecontroleerdeKeuze;
		}
		else {int gecontroleerdeKeuze = controleKeuze(keuze,2);
			return gecontroleerdeKeuze+1;}
	}
	
	
	
	private void keuzeSpeler(int keuze) {
		switch (keuze) {
		case 1:
			speelActie();
			break;
		
		case 2:
			engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand());
			engine.koopKaart(keuzeKoopKaarten(false,engine.geefLijstKaartenDieJeKuntKopen()));
			break;
			
		default:
			break;
		}
	}
	
	private Kaart speelActie() {
		List<Kaart> actieKaartenUitDrawHand = engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(),"actiekaart");
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand,true);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		ExtraInfo kaartMetExtraInfo = engine.actieUitvoeren(gekozenKaart);
		if(kaartMetExtraInfo!= null){extraInputActiekaarten(kaartMetExtraInfo);};
		
		kiezen();
		return gekozenKaart;
	}
	
	private Kaart keuzeKoopKaarten(boolean specialeKaart,List<Kaart> kaartenDieJeKuntKopen ) {
		Speler speler = engine.geefHuidigeSpeler();
		if(!specialeKaart){engine.brengAlleGeldkaartenUitHandNaarStapel(speler.geefSpeelGebied());}
		printhuidigeWaarden();
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		toonLijst(kaartenDieJeKuntKopen,true);
		int keuze = kaartnummerInvullen("kopen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, kaartenDieJeKuntKopen.size());
		Kaart gekochteKaart = kaartenDieJeKuntKopen.get(gecontroleerdekeuze);
		return gekochteKaart;
	}
	
	private int kaartnummerInvullen(String kopenOfWetenOfSpelen) {
	printFunctie("");
	System.out.print("vul het nummer in van de kaart die je wilt "+kopenOfWetenOfSpelen+" : "); 
	return sc.nextInt();
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
		toonLijst(engine.geefHuidigeSpeler().geefSpeelGebied(),false);}
		
}


	private void toonKaartenInHand(Speler speler){
		
		printhuidigeWaarden();
		printFunctie("Kaarten in uw hand");
		toonLijst(speler.geefKaartenInHand(),false);
		printFunctie("");
		
		
}
	private void kiezen(){
	
	while(engine.geefHuidigeSpeler().geefActie() >0 && engine.geefHuidigeSpeler().geefAankoop()>0)
	{
	toonKaartenInHand(engine.geefHuidigeSpeler());
	int keuze = keuzeMenu();	
	keuzeSpeler(keuze);
	engine.geefHuidigeSpeler().verminderActie(1);
	}}

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

private void vragenNaarKaartenUitHand(int maxAantal,String tekst,boolean verschillendeKaarten,Speler speler){

	toonKaartenInHand(speler);
	int aantal = maxAantal;
	
	if(verschillendeKaarten){
	System.out.print(tekst);	
	aantal = sc.nextInt();
	controleKeuze(aantal, maxAantal);
	}
	else{System.out.println(tekst);}
	for (int i = 0; i < aantal; i++) {
		Kaart gekozenKaart = vragenNaarEenUitHand(speler);
		gekozenKaarten.add(gekozenKaart);
		spelers.add(speler);
	}}

private Kaart vragenNaarEenUitHand(Speler speler) {
	System.out.print("Geef een kaartnummer:");
	int kaartKeuze = (sc.nextInt()-1);
	int gecontroleerdeKeuze =controleKeuze(kaartKeuze, speler.geefKaartenInHand().size());
	Kaart gekozenKaart = speler.geefKaartenInHand().get(gecontroleerdeKeuze);
	return gekozenKaart;
}

private boolean ControleOpSlotgracht(Speler speler){
	boolean gebruikVanSlotgracht = false;
	if(engine.isKaartInHand(speler, "slotgracht")){
		toonKaartenInHand(speler);
		System.out.print("Wenst u uw Slotgracht te gebruiken? (0: Nee / 1: Ja)");
		int keuze = sc.nextInt();
		if(keuze==1);{
			gebruikVanSlotgracht = true;
		}}
	return gebruikVanSlotgracht;

}
private void extraInputActiekaarten(ExtraInfo actiekaart) {
		
		switch (actiekaart.geefSoortActie()) {
	
		case "actieEnkeleSpeler":
			vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "actieMeerdereSpelers":
			break;
		case "bureaucraat":			
			for (int i = 0; i < andereSpelers.size(); i++){
				printFunctie("Nu aan de beurt: "+andereSpelers.get(i).geefNaam());
				gebruikSlotgracht.add(ControleOpSlotgracht(andereSpelers.get(i)));
				if(!engine.isTypeKaartInLijst(andereSpelers.get(i).geefKaartenInHand(),"overwinningskaart").isEmpty()&&gebruikSlotgracht.get(i)==false){
					vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),false,andereSpelers.get(i));}
				else {System.out.println("Geen overwinningskaart in hand!");}
				}
				extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),spelers,gekozenKaarten,keuzesSpeler,gebruikSlotgracht);
				printFunctie("Nu terug de beurt aan: "+engine.geefHuidigeSpeler().geefNaam());
			break;
		case "feest":
			//nog vragen of ze effectief een kaart willen kopen
			gekozenKaarten.add(keuzeKoopKaarten(true,engine.geefLijstKaartenDieJeKuntKopen()));
			extraInfoGeven =new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "militie":
			for (int i = 0; i < andereSpelers.size(); i++){
				printFunctie("Nu aan de beurt: "+andereSpelers.get(i).geefNaam());
				gebruikSlotgracht.add(ControleOpSlotgracht(andereSpelers.get(i)));
				if(!gebruikSlotgracht.get(i)){
				vragenNaarKaartenUitHand((andereSpelers.get(i).geefKaartenInHand().size()-actiekaart.geefMaxAantalKaarten()),actiekaart.geefBericht(),false,andereSpelers.get(i));
				}else {System.out.println("Gebruik van Slotgracht!");}}

			extraInfoGeven= new ExtraInfo(actiekaart.kaartNaam(), spelers,gekozenKaarten,keuzesSpeler,gebruikSlotgracht);	
			printFunctie("Nu terug de beurt aan: "+engine.geefHuidigeSpeler().geefNaam());
			break;
		case "geldschieter":
			if(engine.isKaartInHand(engine.geefHuidigeSpeler(), "koper")){
				vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());}
			else {System.out.println("Geen geldkaarten in hand!");}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "mijn":
			//kan properder
			if(!engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), "geldkaart").isEmpty()){
				vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());
				if(gekozenKaarten.size()==1){
					engine.geefHuidigeSpeler().vermeerderGeld(3);
					Kaart gekozenKaart = keuzeKoopKaarten(true, engine.isTypeKaartInLijst(engine.geefLijstKaartenDieJeKuntKopen(),"geldkaart") );
					engine.geefHuidigeSpeler().verminderGeld(3);
					gekozenKaarten.add(gekozenKaart);
				}}
			else {	System.out.println("Geen geldkaarten in hand!");}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "troonzaal":
			if(engine.isKaartInHand(engine.geefHuidigeSpeler(), "actiekaart")){
				gekozenKaarten.add(speelActie());}
			else {System.out.println("Geen actiekaarten in hand!");}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "heks":
			for (int i = 0; i < andereSpelers.size(); i++){
				spelers.add(andereSpelers.get(i));
				printFunctie("Nu aan de beurt: "+andereSpelers.get(i).geefNaam());
				gebruikSlotgracht.add(ControleOpSlotgracht(andereSpelers.get(i)));
			}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),spelers, gekozenKaarten, keuzesSpeler, gebruikSlotgracht);
			printFunctie("Nu terug de beurt aan: "+engine.geefHuidigeSpeler().geefNaam());
			break;
		case "spion":
			for (int i = 0; i < alleSpelers.length; i++){
				printFunctie("Nu aan de beurt: "+alleSpelers[i].geefNaam());
				gebruikSlotgracht.add(ControleOpSlotgracht(alleSpelers[i]));
				if(!engine.isKaartInHand(alleSpelers[i], "slotgracht")){
					printFunctie("Kaarten van: "+alleSpelers[i].geefNaam());
					Kaart kaart = alleSpelers[i].geefTrekStapel().get(0);
					gekozenKaarten.add(kaart);
					toonLijst(gekozenKaarten, false);
					System.out.println(actiekaart.geefBericht());
					int kaartKeuze = sc.nextInt();
					int gecontroleerdeKeuze =controleKeuze(kaartKeuze, actiekaart.geefMaxAantalKaarten());
					keuzesSpeler.add(gecontroleerdeKeuze);
					
					gekozenKaarten.clear();
			}}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),spelers,gekozenKaarten,keuzesSpeler,gebruikSlotgracht);
			break;
		case "dief":
			for (int i = 0; i < alleSpelers.length; i++){
				printFunctie("Kaarten van: "+alleSpelers[i].geefNaam());
				Kaart kaart = alleSpelers[i].geefTrekStapel().get(0);
				System.out.println(kaart.geefNaam());
				System.out.println(actiekaart.geefBericht());
				int kaartKeuze = sc.nextInt();
				int gecontroleerdeKeuze =controleKeuze(kaartKeuze, actiekaart.geefMaxAantalKaarten());
				gekozenKaarten.add(kaart);
				spelers.add(andereSpelers.get(i));
				keuzesSpeler.add(gecontroleerdeKeuze);
			}
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),spelers,gekozenKaarten,keuzesSpeler,gebruikSlotgracht);
			
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


