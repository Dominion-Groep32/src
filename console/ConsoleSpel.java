package console;

import java.util.*;

import com.sun.accessibility.internal.resources.accessibility_zh_HK;

import engine.*;

public class ConsoleSpel {
	private Scanner sc = new Scanner(System.in);
	private SpelFuncties engine = new SpelFuncties();
	private ExtraInfo extraInfoGeven = null;
	private List<Speler> spelers = new LinkedList<Speler>();
	

	
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
	
	while(engine.geefHuidigeSpeler().geefActie() >0 || engine.geefHuidigeSpeler().geefAankoop()>0)
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
		speler.geefLijstGekozenKaarten().add(gekozenKaart);
		spelers.add(speler);
	}}

private Kaart vragenNaarEenUitHand(Speler speler) {
	System.out.print("Geef een kaartnummer:");
	int kaartKeuze = (sc.nextInt()-1);
	int gecontroleerdeKeuze =controleKeuze(kaartKeuze, speler.geefKaartenInHand().size());
	Kaart gekozenKaart = speler.geefKaartenInHand().get(gecontroleerdeKeuze);
	return gekozenKaart;
}

private void ControleOpSlotgracht(Speler speler){

	if(engine.isKaartInHand(speler, "slotgracht")){
		printFunctie("Nu aan de beurt: "+speler.geefNaam());
		toonKaartenInHand(speler);
		System.out.print("Wenst u uw Slotgracht te gebruiken? (0: Nee / 1: Ja)");
		int keuze = sc.nextInt();
		if(keuze==1);{
			speler.zetGebruikSlotgrachtopTrue();;
		}}

}

private void jaNeeKeuzeMaken(Speler speler,ExtraInfo actiekaart) {
	System.out.print(actiekaart.geefBericht());
	int keuze = (sc.nextInt());
	int gecontroleerdeKeuze =controleKeuze(keuze, actiekaart.geefMaxAantalKaarten());
	if(gecontroleerdeKeuze==1){ speler.zetKeuzeSpelerOpTrue();}
}

private void extraInputActiekaarten(ExtraInfo actiekaart) {
	
	if(actiekaart.geefSpelers()==null){
		if(actiekaart.geefSpecialeUitwerking()){
			aparteSwitchEnkeleSpeler(actiekaart);}
		else {vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());}}

	else{
		for (int i = 0; i < actiekaart.geefSpelers().size(); i++){
			Speler speler = actiekaart.geefSpelers().get(i);
			
			if(actiekaart.geefAanval()){ControleOpSlotgracht(speler);}
		
			aparteSwitchMeerderSpelers(actiekaart,speler,i);}
			printFunctie("Nu terug de beurt aan: "+engine.geefHuidigeSpeler().geefNaam());		
	}
	extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),spelers);
	engine.actieFase2Uitvoeren(extraInfoGeven);
}

private void aparteSwitchEnkeleSpeler (ExtraInfo actiekaart) {
switch (actiekaart.kaartNaam()) {
	case "raadsheer":
		jaNeeKeuzeMaken(engine.geefHuidigeSpeler(),actiekaart);
	case "mijn":
		//kan properder
		if(!engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), actiekaart.geefKaartSpecificaties()).isEmpty()){
			vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());
			if(engine.geefHuidigeSpeler().geefLijstGekozenKaarten().size()==1){
				engine.geefHuidigeSpeler().vermeerderGeld(3);
				Kaart gekozenKaart = keuzeKoopKaarten(true, engine.isTypeKaartInLijst(engine.geefLijstKaartenDieJeKuntKopen(),"geldkaart") );
				engine.geefHuidigeSpeler().verminderGeld(3);
				engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(gekozenKaart);
			}}
		else {	System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "feest":
		//nog vragen of ze effectief een kaart willen kopen
		engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(keuzeKoopKaarten(true,engine.geefLijstKaartenDieJeKuntKopen()));
		break;
	case "geldschieter":
		if(engine.isKaartInHand(engine.geefHuidigeSpeler(), actiekaart.geefKaartSpecificaties())){
			vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());}
		else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "troonzaal":
		if(engine.isKaartInHand(engine.geefHuidigeSpeler(), actiekaart.geefKaartSpecificaties())){
			engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(speelActie());}
		else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "bibliotheek":
		while(engine.geefHuidigeSpeler().geefKaartenInHand().size()<actiekaart.geefMaxAantalKaarten()){
			Kaart kaart = engine.geefHuidigeSpeler().geefTrekStapel().get(0);
			if(kaart.geefKaartType() == actiekaart.geefKaartSpecificaties()){
				jaNeeKeuzeMaken(engine.geefHuidigeSpeler(), actiekaart);
			}
			else {
				engine.trekKaartVanTrekStapel(engine.geefHuidigeSpeler(), 1);
			}
		}
		break;
	default:
		break;
	}}

private void aparteSwitchMeerderSpelers (ExtraInfo actiekaart,Speler speler,int i) {
	switch (actiekaart.kaartNaam()) {
		case "buraucraat":
			if(!speler.geefGebruikSlotgracht()){
				if(!engine.isTypeKaartInLijst(speler.geefKaartenInHand(),actiekaart.geefKaartSpecificaties()).isEmpty()){
				vragenNaarKaartenUitHand(actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht(),false,speler);}
				else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}}
			else {System.out.println("Gebruik van Slotgracht!");}
			break;
		case "militie":
			if(!speler.geefGebruikSlotgracht()){
				vragenNaarKaartenUitHand((speler.geefKaartenInHand().size()-actiekaart.geefMaxAantalKaarten()),actiekaart.geefBericht(),false,speler);}
			else {System.out.println("Gebruik van Slotgracht!");}
			break;
		case "spion":
			printFunctie("Kaarten van: "+speler.geefNaam());
			System.out.println(speler.geefTrekStapel().get(0));
			System.out.println(actiekaart.geefBericht());
			int keuze = sc.nextInt();
			int gecontroleerdeKeuze =controleKeuze(keuze, actiekaart.geefMaxAantalKaarten());
			if(gecontroleerdeKeuze == 1){
				speler.zetKeuzeSpelerOpTrue();
			}
			break;
		/*	
		case "dief":
			printFunctie("Kaarten van: "+speler.geefNaam());
			Kaart kaart = speler.geefTrekStapel().get(0);
			System.out.println(kaart.geefNaam());
			System.out.println(actiekaart.geefBericht());
			int kaartKeuze = sc.nextInt();
			int gecontroleerdeKeuze =controleKeuze(kaartKeuze, actiekaart.geefMaxAantalKaarten());
			gekozenKaarten.add(kaart);
			spelers.add(andereSpelers.get(i));
			keuzesSpeler.add(gecontroleerdeKeuze);
			break;
			*/
		default:
			break;}
		
	}
private void printUitslag() {
	printFunctie("Uitlag");
	List<Speler> spelers = engine.geefLijstAlleSpelers();
	for (int i = 0; i < spelers.size(); i++) {
		System.out.println(i+":"+spelers.get(i).geefNaam()+" -- score: "+spelers.get(i).geefScore());
	}
}
}


