package console;

import java.util.*;
import engine.*;

public class ConsoleSpel {
	private Scanner sc = new Scanner(System.in);
	private SpelEngine engine = new SpelEngine();
	private ExtraInfo extraInfoGeven = null;
	
	public static void main(String[] args) {
		ConsoleSpel console = new ConsoleSpel();
		
		
	}
	
	public ConsoleSpel(){
		System.out.println("----------------------------------WELKOM BIJ DOMINION------------------------------------");
		spel();
	}
	
		
	public void spel(){

		
		engine.maakSpelersAan(vraagSpelersNamen(vraagAantalSpelers()));
	
		while(engine.spelNogNietBe�indigd()){

				Speler huidigeSpeler = engine.geefHuidigeSpeler();
				System.out.println("");
				printFunctie("Nu aan de beurt: "+huidigeSpeler.geefNaam());
				kiezen();
				engine.brengAlleKaartenNaarAflegstapel();
				printFunctie("de beurt van "+engine.geefHuidigeSpeler().geefNaam()+" is be�indigd");
				engine.trekKaartVanTrekStapel(huidigeSpeler,5);
				huidigeSpeler.herstelWaarden();
				engine.volgendeSpeler();
		}
		printFunctie("GAME OVER");
		engine.berekenScoreAlleSpelers();
		printUitslag();
		
	}
	
	//SPELERS
	public int vraagAantalSpelers()
	{
		System.out.print("Met hoeveel spelers wilt u spelen? (max. 4 pers): ");
		int keuze = sc.nextInt();
		while(keuze <2 || keuze>4)
		{
			System.out.print("geef een geldige keuze in! (min 2) : ");
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
	
	//PRINT FUNCTIES
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
	private void printhuidigeWaarden(Speler speler) {
		printFunctie("huidige waarden");
		System.out.println("Geld:  " + speler.geefGeld());
		System.out.println("Aankoop: "+ speler.geefAankoop());
		System.out.println("Actie: " + speler.geefActie());
		if(!speler.geefSpeelGebied().isEmpty()){
		printFunctie("Kaarten in Speelveld");
		toonLijst(speler.geefSpeelGebied(),false);}
		
}
	private void toonKaartenInHand(Speler speler){
		
		printhuidigeWaarden(speler);
		printFunctie("Kaarten in uw hand");
		toonLijst(speler.geefKaartenInHand(),false);
		printFunctie("");	
}
	
	//KEUZE
	
	
	private void kiezen(){
		while(engine.geefHuidigeSpeler().geefActie()>0 && engine.geefHuidigeSpeler().geefAankoop()>0  || engine.geefHuidigeSpeler().geefAankoop()>0 && !engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), "actiekaart").isEmpty()){
			toonKaartenInHand(engine.geefHuidigeSpeler());
			int keuze = keuzeMenu();
			keuzeSpeler(keuze);
	}}
	
	private int keuzeMenu() {
		int getal = 1;
		boolean tmp = false;
		
		if(!engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(),"actiekaart").isEmpty() && engine.geefHuidigeSpeler().geefActie()>0){
			tmp = true;
			{System.out.println("Let op: u kan optie 1 niet meer kiezen als u eerst optie 2 neemt !");
			System.out.println("1: gebruik actiekaarten");
			getal++;
			}}
		
		if(!engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), "geldkaart").isEmpty()&& engine.geefHuidigeSpeler().geefAankoop()>0){
			System.out.println(getal+": gebruik geldkaarten");}
		else{System.out.println(getal+": Koop koperkaart");}
			System.out.println((getal+1)+": be�indig je beurt");
		int keuze = printGeefKeuze();
		
		if (tmp){int gecontroleerdeKeuze = controleKeuze(keuze,3);
			return gecontroleerdeKeuze;}
		else {int gecontroleerdeKeuze = controleKeuze(keuze,2);
			return gecontroleerdeKeuze+1;}
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
	private int vragenNaarKeuzeUitLijst(String tekst, List<Kaart> lijst ){
		printFunctie("");
		System.out.print(tekst);
		int keuze = (sc.nextInt()-1);
		int gecontroleerdeKeuze =controleKeuze(keuze, lijst.size());
		return gecontroleerdeKeuze;
	}
	private int vragenNaarKeuzeNietUitLijst(String tekst, int maxAantal){
		System.out.print(tekst);
		int keuze = (sc.nextInt());
		int gecontroleerdeKeuze =controleKeuze(keuze, maxAantal);
		return gecontroleerdeKeuze;
	}
	
	// UITVOEREN KEUZE
	private void keuzeSpeler(int keuze) {
		switch (keuze) {
		case 1:
			speelActie();
			break;
		
		case 2:
			engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand());
			engine.koopKaart(keuzeKoopKaarten(false,engine.geefLijstKaartenDieJeKuntKopen()));
			break;
		case 3:
			engine.geefHuidigeSpeler().verminderAankoop(1);
			engine.geefHuidigeSpeler().verminderActie(1);
		default:
			break;
		}
	}
	// SPEEL ACTIE
	private Kaart speelActie() {
		List<Kaart> actieKaartenUitDrawHand = engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(),"actiekaart");
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand,true);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		ExtraInfo kaartMetExtraInfo = engine.actieUitvoeren(gekozenKaart);
		if(kaartMetExtraInfo!= null){extraInputVragenActiekaart(kaartMetExtraInfo);};
		kiezen();
		return gekozenKaart;
	}
	
	private Kaart kiesActiekaart(List<Kaart> lijstVanActieKaarten) {
		int keuze = vragenNaarKeuzeUitLijst("vul het nummer in van de kaart die u wilt spelen : ", lijstVanActieKaarten);
		return lijstVanActieKaarten.get(keuze);
	}	
	

	
	// KOOP KAARTEN
	private Kaart keuzeKoopKaarten(boolean specialeKaart,List<Kaart> kaartenDieJeKuntKopen ) {
		Speler speler = engine.geefHuidigeSpeler();
		
		if(!specialeKaart){engine.brengAlleGeldkaartenUitHandNaarStapel(speler.geefSpeelGebied());}
		
		printhuidigeWaarden(speler);
		printFunctie("");
		System.out.println("u kunt de volgende kaarten kopen");
		printFunctie("");
		toonLijst(kaartenDieJeKuntKopen,true);
		
		int keuze = vragenNaarKeuzeUitLijst("vul het nummer in van de kaart die u wilt kopen : ", kaartenDieJeKuntKopen);
		return kaartenDieJeKuntKopen.get(keuze);
	}
	
	// ACTIEKAARTEN UITVOEREN


private void extraInputVragenActiekaart(ExtraInfo actiekaart) {
	if(actiekaart.geefSpelers()==null){
		if(actiekaart.geefSpecialeUitwerking()){
			aparteSwitchEnkeleSpeler(actiekaart);}
		else {vragenNaarKaartenUitHand(actiekaart,actiekaart.geefMaxAantalKaarten(),engine.geefHuidigeSpeler());}}

	else{
		for (int i = 0; i < actiekaart.geefSpelers().size(); i++){
			Speler speler = actiekaart.geefSpelers().get(i);
			if(actiekaart.geefAanval()){ControleOpSlotgracht(speler);}
			aparteSwitchMeerderSpelers(actiekaart,speler,i);}
			printFunctie("Nu terug de beurt aan: "+engine.geefHuidigeSpeler().geefNaam());}		
	
	extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),actiekaart.geefSpelers());
	engine.actieFase2Uitvoeren(extraInfoGeven);
}

private void aparteSwitchEnkeleSpeler (ExtraInfo actiekaart) {
	
switch (actiekaart.kaartNaam()) {
	
	case "raadsheer":
		jaNeeKeuzeMaken(engine.geefHuidigeSpeler(),actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht()+actiekaart.geefExtraVraag());
		break;
	case "feest":
		engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(keuzeKoopKaarten(true,engine.geefLijstKaartenDieJeKuntKopen()));
		break;
	case "geldschieter":
		if(engine.isKaartInHand(engine.geefHuidigeSpeler(), actiekaart.geefKaartSpecificaties())){
			vragenNaarKaartenUitHand(actiekaart,actiekaart.geefMaxAantalKaarten(),engine.geefHuidigeSpeler());}
		else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "troonzaal":
		if(engine.isKaartInHand(engine.geefHuidigeSpeler(), actiekaart.geefKaartSpecificaties())){
			engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(speelActie());}
		else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "bibliotheek":
		int plaats = 0;
		while(engine.geefHuidigeSpeler().geefKaartenInHand().size()<actiekaart.geefMaxAantalKaarten()){
			Kaart kaart = engine.geefHuidigeSpeler().geefTrekStapel().get(plaats);
			if(kaart.geefKaartType() == actiekaart.geefKaartSpecificaties()){
				jaNeeKeuzeMaken(engine.geefHuidigeSpeler(), actiekaart.geefMaxAantalKaarten(),actiekaart.geefExtraVraag());}}
			//else(engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(kaart));}
			
		break;
	case "mijn":
		List<Kaart> tijdelijkeLijst = new LinkedList<>();
		tijdelijkeLijst = engine.isTypeKaartInLijst(engine.geefHuidigeSpeler().geefKaartenInHand(), actiekaart.geefKaartSpecificaties());
		if(!tijdelijkeLijst.isEmpty()){
			jaNeeKeuzeMaken(engine.geefHuidigeSpeler(), actiekaart.geefMaxAantalKaarten(),actiekaart.geefBericht()+actiekaart.geefExtraVraag());
			if(engine.geefHuidigeSpeler().geefKeuzeSpeler()){
				vragenNaarKaartenUitHand(actiekaart, actiekaart.geefMaxAantalKaarten(), engine.geefHuidigeSpeler());				
				engine.geefHuidigeSpeler().vermeerderGeld(3+engine.geefHuidigeSpeler().geefLijstGekozenKaarten().get(0).geefKost());
				Kaart gekozenKaart = keuzeKoopKaarten(true, engine.isTypeKaartInLijst(engine.geefLijstKaartenDieJeKuntKopen(),actiekaart.geefKaartSpecificaties()));
				engine.geefHuidigeSpeler().verminderGeld(3);
				engine.geefHuidigeSpeler().geefLijstGekozenKaarten().add(gekozenKaart);
			}}
		else {	System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
		break;
	case "dief":
		String[] berichten = actiekaart.geefExtraVraag().split(",");
		for (int i = 0; i < engine.geefLijstAndereSpelers().size(); i++){
			Speler speler = engine.geefLijstAlleSpelers().get(i);
			ControleOpSlotgracht(speler);
			if(!speler.geefGebruikSlotgracht()){
				printFunctie("Kaarten van: "+speler.geefNaam());
				List<Kaart> lijstKaarten = new LinkedList<>();
				lijstKaarten.add(speler.geefTrekStapel().get(0));
				lijstKaarten.add(speler.geefTrekStapel().get(1));
				toonLijst(lijstKaarten, false);
				for (int j = 0; j < lijstKaarten.size(); j++) {
					if(lijstKaarten.get(i).geefKaartType()==actiekaart.geefKaartSpecificaties()){
						
						jaNeeKeuzeMaken(speler, actiekaart.geefMaxAantalKaarten(),berichten[0]);
						if(speler.geefKeuzeSpeler()){speler.geefLijstTeStelenKaarten().add(lijstKaarten.get(i));}
						else {engine.brengEenKaartVanDeEneNaarAndereStapel(speler.geefVuilbakStapel(), lijstKaarten.get(i), speler.geefAflegStapel());
						}}}}}
		for (int i = 0; i < actiekaart.geefSpelers().size(); i++){
			Speler speler = actiekaart.geefSpelers().get(i);
			for (int j = 0; j < speler.geefLijstTeStelenKaarten().size(); j++) {
					jaNeeKeuzeMaken(speler, actiekaart.geefMaxAantalKaarten(),berichten[1]);
					if(speler.geefKeuzeSpeler()){
						engine.geefHuidigeSpeler().geefLijstTeStelenKaarten().add(speler.geefLijstTeStelenKaarten().get(i));
						speler.geefLijstGekozenKaarten().remove(i);
		}}}		
		break;
	default:
		break;
	}}

private void aparteSwitchMeerderSpelers (ExtraInfo actiekaart,Speler speler,int i) {
	if(!speler.geefGebruikSlotgracht()){
		switch (actiekaart.kaartNaam()) {
			case "bureaucraat":
				printFunctie("Nu de beurt aan "+speler.geefNaam());
				if(!engine.isTypeKaartInLijst(speler.geefKaartenInHand(),actiekaart.geefKaartSpecificaties()).isEmpty()){
					vragenNaarKaartenUitHand(actiekaart,actiekaart.geefMaxAantalKaarten(),speler);}
				else {System.out.println("Geen "+actiekaart.geefKaartSpecificaties()+" in hand!");}
				break;
			case "militie":
				printFunctie("Nu de beurt aan "+speler.geefNaam());
				vragenNaarKaartenUitHand(actiekaart,(speler.geefKaartenInHand().size()-actiekaart.geefMaxAantalKaarten()),speler);
				break;
			case "spion":
				printFunctie("Kaarten van: "+speler.geefNaam());
				System.out.println(speler.geefTrekStapel().get(0).geefNaam());
				jaNeeKeuzeMaken(speler, actiekaart.geefMaxAantalKaarten(),actiekaart.geefExtraVraag());
				break;
			default:
				break;}}
	else {System.out.println("Gebruik van Slotgracht!");}
}


private void vragenNaarKaartenUitHand(ExtraInfo actiekaart,int maxAantal,Speler speler){

	toonKaartenInHand(speler);
	int aantal = maxAantal;
	System.out.println(actiekaart.geefBericht());
	if(actiekaart.geefExtraVraag()!=null){
		aantal = vragenNaarKeuzeNietUitLijst(actiekaart.geefExtraVraag(), maxAantal);}
	
	for (int i = 0; i < aantal; i++) {
		int keuze =vragenNaarKeuzeUitLijst("Geef een kaartnummer: ", speler.geefKaartenInHand());
		Kaart kaart = speler.geefKaartenInHand().get(keuze);
		speler.geefLijstGekozenKaarten().add(kaart);
	}}


private void ControleOpSlotgracht(Speler speler){
	if(engine.isKaartInHand(speler, "slotgracht")){
		printFunctie("Nu aan de beurt: "+speler.geefNaam());
		toonKaartenInHand(speler);
		int keuze = vragenNaarKeuzeNietUitLijst("Wenst u uw Slotgracht te gebruiken? (0 = Nee / 1 = Ja) : ", 1);
		if(keuze==1){speler.zetGebruikSlotgracht(true);}
	}}

private void jaNeeKeuzeMaken(Speler speler, int maxAantal,String tekst) {
	int keuze = vragenNaarKeuzeNietUitLijst(tekst,maxAantal );
	if(keuze==1){ speler.zetKeuzeSpeler(true);}
}



//EINDEEE
private void printUitslag() {
	printFunctie("Uitlag");
	List<Speler> spelers = engine.geefLijstAlleSpelers();
	for (int i = 0; i < spelers.size(); i++) {
		System.out.println(i+":"+spelers.get(i).geefNaam()+" -- score: "+spelers.get(i).geefScore());
	}}
}


