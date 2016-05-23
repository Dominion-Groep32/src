package console;

import java.util.*;

import engine.*;
//test

public class ConsoleSpel {
	Scanner sc = new Scanner(System.in);
	SpelFuncties engine = new SpelFuncties();
	//private ExtraInfo extraInfoHalen;
	ExtraInfo extraInfoGeven = new ExtraInfo();
	
	

	
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
		switch (keuze) {
		case 1:
			speelActie();
			break;
		
		case 2:
			engine.geefHuidigeSpeler().vermeerderGeld(engine.geldInHand());
			engine.koopKaart(keuzeKoopKaarten(false));
			break;
			
		default:
			break;
		}
	}
	
	private Kaart speelActie() {
		List<Kaart> actieKaartenUitDrawHand = engine.neemActiekaartenUitHand();
		printFunctie("Actiekaarten");
		toonLijst(actieKaartenUitDrawHand,true);
		//vragenNaarInfoOverKaarten(actieKaartenUitDrawHand);
		Kaart gekozenKaart = kiesActiekaart(actieKaartenUitDrawHand);
		ExtraInfo kaartMetExtraInfo = engine.actieUitvoeren(gekozenKaart);
		if(kaartMetExtraInfo!= null){extraInputActiekaarten(kaartMetExtraInfo);};
		
		kiezen();
		return gekozenKaart;
	}
	
	private Kaart keuzeKoopKaarten(boolean specialeKaart) {
		Speler speler = engine.geefHuidigeSpeler();
		if(!specialeKaart){engine.brengAlleGeldkaartenUitHandNaarStapel(speler.geefSpeelGebied());}
		printhuidigeWaarden();
		printFunctie("");
		System.out.println("je kunt de volgende kaarten kopen");
		printFunctie("");
		toonLijst(engine.kaartenDieJeKuntKopen(),true);
		//vragenNaarInfoOverKaarten(engine.kaartenDieJeKuntKopen()); 
		int keuze = kaartnummerInvullen("kopen")-1;
		int gecontroleerdekeuze = controleKeuze(keuze, engine.kaartenDieJeKuntKopen().size());
		Kaart gekochteKaart = engine.kaartenDieJeKuntKopen().get(gecontroleerdekeuze);
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

	/*
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
*/

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
	/*
	private void geefInfoOverKaarten(int kaartKeuze, List<Kaart> lijstMetKaarten) {
		Kaart gekozenKaart = lijstMetKaarten.get(kaartKeuze-1);
		System.out.println(gekozenKaart.geefNaam()+" : "+gekozenKaart.geefInfo());
		vragenNaarInfoOverKaarten(lijstMetKaarten);
		
}
	*/
private List<Kaart> vragenNaarKaartenUitHand(int maxAantal,String tekst,boolean verschillendeKaarten,Speler speler){
	List<Kaart> lijstGekozenKaarten = new LinkedList<Kaart>();
	toonKaartenInHand(speler);
	int aantal = 1;
	
	if(verschillendeKaarten){
	System.out.print(tekst);
	aantal = sc.nextInt();
	controleKeuze(aantal, maxAantal);
	}
		
	for (int i = 1; i <= aantal; i++) {
		Kaart gekozenKaart = vragenNaarEenUitHand(speler);
		lijstGekozenKaarten.add(gekozenKaart);
	}
	return lijstGekozenKaarten;
}
private Kaart vragenNaarEenUitHand(Speler speler) {
	System.out.print("Geef een kaartnummer:");
	int kaartKeuze = (sc.nextInt()-1);
	int gecontroleerdeKeuze =controleKeuze(kaartKeuze, speler.geefKaartenInHand().size());
	Kaart gekozenKaart = speler.geefKaartenInHand().get(gecontroleerdeKeuze);
	return gekozenKaart;
}


private void extraInputActiekaarten(ExtraInfo actiekaart) {
		List<Speler> AndereSpelers = engine.geefLijstAndereSpelers();
		List<Kaart> gekozenKaarten = new LinkedList<Kaart>();
		
		switch (actiekaart.geefSoortActie()) {
		case "geenExtraInput":
			
		case "actieEnkeleSpeler":
			gekozenKaarten = vragenNaarKaartenUitHand(actiekaart.geefAantalKaartenUitHandNemen(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());
			extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		
		case "actieMeerdereSpelers":
			
			break;
		case "bureaucraat":			
			for (int i = 0; i < AndereSpelers.size(); i++){
				printFunctie("Nu aan de beurt: "+AndereSpelers.get(i).geefNaam());
				if(engine.controleerOpTypeKaartenInHand(AndereSpelers.get(i),"overwinningskaart")){
					gekozenKaarten = vragenNaarKaartenUitHand(actiekaart.geefAantalKaartenUitHandNemen(),actiekaart.geefBericht(),false,AndereSpelers.get(i));
					extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),i,gekozenKaarten);
				}else {
					System.out.println("Geen overwinningskaart in hand!");
				}}
			break;
		case "feest":
			//nog vragen of ze effectief een kaart willen kopen
			gekozenKaarten.add(keuzeKoopKaarten(true));
			extraInfoGeven =new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			break;
		case "militie":
			for (int i = 0; i < AndereSpelers.size(); i++){
				printFunctie("Nu aan de beurt: "+engine.geefHuidigeSpeler().geefNaam());
				while(AndereSpelers.get(i).geefKaartenInHand().size()>3) {
				gekozenKaarten= vragenNaarKaartenUitHand(actiekaart.geefAantalKaartenUitHandNemen(),actiekaart.geefBericht(),false,AndereSpelers.get(i));
				extraInfoGeven= new ExtraInfo(actiekaart.kaartNaam(), i,gekozenKaarten);
			}}
			break;
		case "geldschieter":
			if(engine.controleerOpTypeKaartenInHand(engine.geefHuidigeSpeler(), "geldkaart")){
				gekozenKaarten = vragenNaarKaartenUitHand(actiekaart.geefAantalKaartenUitHandNemen(),actiekaart.geefBericht(),true,engine.geefHuidigeSpeler());
				extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);
			}else {
				System.out.println("Geen geldkaarten in hand!");
			}
			break;
		case "troonzaal":
			if(engine.controleerOpTypeKaartenInHand(engine.geefHuidigeSpeler(), "actiekaart")){
				gekozenKaarten.add(speelActie());
				extraInfoGeven = new ExtraInfo(actiekaart.kaartNaam(),gekozenKaarten);}
			else {
				System.out.println("Geen actiekaarten in hand!");
		}
			break;
		default:
			break;
			}
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


