package engine;

import java.util.*;

public class GameEngine {
	
	
	private List<Kaart> geldEnOverwinningskaarten = new LinkedList<>(Arrays.asList(new Kaart("koper","geldKaart",0,1,""),new Kaart("zilver","geldKaart",3,2,""),new Kaart("goud","geldKaart",6,3,""),
			new Kaart("landgoed","overwinningskaart",2,1,""),new Kaart("hertogdom","overwinningskaart",5,3,""),new Kaart("provincie","overwinningskaart",8,6,"")));
	private List<Kaart> actiekaarten = new LinkedList<>(Arrays.asList(new Kaart("avonturier","actiekaart",6,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."),
			new Kaart("bureaucraat","actiekaart",4,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)"), new Kaart("kelder","actiekaart",2,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart."), new Kaart("raadsheer","actiekaart",3,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen"),new Kaart("kapel","actiekaart",2,"Vernietig 4 of minder kaarten uit je hand"),new Kaart("raadszaal","actiekaart",5,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart"),new Kaart("feest","actiekaart",4,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder."),
			new Kaart("festival","actiekaart",5,"+2 acties / +1 aanschaf / +2 munten"),new Kaart("tuinen","actiekaart",4,"Elke 10 kaarten in je stapel zijn aan het einde van  het spel 1 landgoed waard (naar beneden afronden)."),new Kaart("laboratorium","actiekaart",5,"+2 kaarten / +1 actie"),new Kaart("bibliotheek","actiekaart",5,"Vul je hand aan tot 7 kaarten. Getrokken actiekaarten mag je houden of apart bewaren en vervangen door nieuwe kaarten. Als je hand is aangevuld leg je de apart bewaarde actiekaarten af."),new Kaart("markt","actiekaart",5,"+1 kaart/ +1 actie / +1 aanschaf / +1 munt"),new Kaart("militie","actiekaart",4,"+2 munten/ Iedere andere speler legt naar zijn keuze kaarten af totdat hij er 3 op handen heeft."),new Kaart("mijn","actiekaart",5,"Vernietig een geldkaart uit je hand. Neem een geldkaart die ten hoogste drie munten meer wwaard is en neem deze op handen.")
			,new Kaart("slotgracht","actiekaart",2,"+2 kaarten / Als een andere speler een aanvalskaart speelt, mag je de Slotgracht tonen. In dat geval heeft de aanval op jou geen effect."),new Kaart("geldschieter","actiekaart",4,"Vernietig een koperkaart uit je hand. Als je dat doet, heb je deze beurt met 3 munten."),new Kaart("verbouwing","actieKaart",4,"Vernietig een kaart uit je hand. Pak een kaart die ten hoogste 2 munten meer waard is dan de vernietigde kaart."),new Kaart("smidse","actiekaart",4,"+3 kaarten"),new Kaart("spion","actiekaart",4,"+1 kaart / +1 actie / Alle spelers tonen de bovenste kaart van hun trekstapel. De spion bepaalt of ze blijven liggen of worden afgelegd."),new Kaart("dief","actiekaart",4,"Iedere andere speler toont de bovenste 2 kaarten van zijn trekstapel. Als een speler geldkaarten toont, moet hij er één naar jouw keuze vernietigen. Je mag een of meer van deze vernietigde kaarten pakken en afleggen. De andere spelers leggen andere getoonde kaarten op hun aflegstapel."),new Kaart("troonzaal","actiekaart",4,"Kies een actiekaart uit je hand. Speel deze tweemaal.")
			,new Kaart("dorp","actiekaart",3,"+1 kaart / +2 acties"),new Kaart("heks","actiekaart",5,"+2 kaarten / Iedere andere speler pakt 1 vloekkaart."),new Kaart("werkplaats","actiekaart",3,"Pak een kaart die maximaal 4 munten kost."),new Kaart("houthakker","actiekaart",3,"+1 aanschaf / +2 munten")));
	private Speler[] spelersNamen = new Speler[2];
	private List<Kaart> kaartenDieTekoopZijn = new LinkedList<>();
	private Object[][] Stapels = new Object[17][2];
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;

	
	
	
	public  void maakSpelersAan(String SpelersNamen[]){

		for (int i = 0; i < SpelersNamen.length; i++) {
			spelersNamen[i] = new Speler(SpelersNamen[i]);
		}
	}
	
	public void veranderSpeler(){
		if (huidigeSpeler == spelersNamen[0])
		{huidigeSpeler = spelersNamen[1];}
		
		else {huidigeSpeler = spelersNamen[0];}

	}
	
	public void verminderStapel(String kaartnaam){
		
		for (int i = 0; i < Stapels.length; i++) {
			String Kaart = (String) Stapels[i][0];
			if (kaartnaam.equals(Kaart))
			{
				int waarde = (int) Stapels[i][1];
				Stapels[i][1] = (waarde-1);
			}
		}
	}
	
	public boolean spelNogNietBeëindigd(){
		
		for (int i = 0; i < Stapels.length; i++) {
			//if(Stapels[i][0])
		}
		return true;
	}
	
	public Speler andereSpeler(){
		Speler tmp;
		if (huidigeSpeler == spelersNamen[1])
		{tmp = spelersNamen[0];}
		
		else {tmp = spelersNamen[1];}
		
		return tmp;
	}
	
	public List<Kaart> lijstenSamenvoegenShuffle(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst) {

		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));
		}
		bijTeVoegenLijst.clear();
		Collections.shuffle(primaireLijst);
		return primaireLijst;

	}

	public List<Kaart> lijstenSamenvoegenZonderShuffle(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst) {

		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));
		}
		bijTeVoegenLijst.clear();
		return primaireLijst;

	}	

	public List<Kaart> kaartenGenereren() {

		Collections.shuffle(actiekaarten);
		for (int i = 0; i < 10; i++) {
			kaartenDieTekoopZijn.add(actiekaarten.get(i));
			Stapels[i][0] = actiekaarten.get(i).naam();
			Stapels[i][1] = 10;
		}
		
		for (int i = 10; i < geldEnOverwinningskaarten.size(); i++) {
			Stapels[i][0] = geldEnOverwinningskaarten.get(i).naam();
			Stapels[i][1] = 10;
			
		}
		return kaartenDieTekoopZijn;
	}

	public int geldInHand(List<Kaart> lijst) {
		int geld = 0;
		for (int i = 0; i < lijst.size(); i++) {
			geld += lijst.get(i).waarde();
		}
		return geld;
	}
	


	public List<Kaart> kaartenDieJeKuntKopen(List<Kaart> lijst, int coins) {
		List<Kaart> tmp = new LinkedList<Kaart>();
		for (int i = 0; i < lijst.size(); i++) {
			if (lijst.get(i).kost() <= coins) {
				tmp.add(lijst.get(i));
			}
		}
		return tmp;
	}

		
	public List<Kaart> neemActiekaartenUitHand(List<Kaart> kaartenInHand){
		List<Kaart> actiekaartenUitHand = new LinkedList<Kaart>();
		for (int i = 0; i < kaartenInHand.size(); i++) {
			if (kaartenInHand.get(i).kaartType() == "actieKaart") {
				actiekaartenUitHand.add(kaartenInHand.get(i));
			}
		}
		return actiekaartenUitHand;
	}
	

	public List<Kaart> lijstGeldEnOverwinningskaarten() {
		return this.geldEnOverwinningskaarten;
	}


	public void maakKaartInHandLeeg(List<Kaart> lijst) {
		lijst.clear();
		
	}
	
	
	public Speler geefHuidigeSpeler(){
		
		return this.huidigeSpeler;
	}
	
	public void brengKaartenInHandStapelNaarAflegstapel(List<Kaart> kaartenInHand, List<Kaart> aflegstapel){
		lijstenSamenvoegenZonderShuffle(aflegstapel, kaartenInHand);
		maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
	}
	
	public void actieUitvoeren(Kaart kaart) {
		
		
		huidigeSpeler.kaartenInHand().remove(kaart);
		switch (kaart.naam()) {
		case "avonturier":
			avonturier();
			
			break;
		case "bureaucraat":
			
			//geefHuidigeSpeler().trekStapel().//HIER VOOR ZORGEN DAT ZILVER TOEGEVOEGD WORD
			//addFirst(new GeldKaart("zilver"));
			break;
		case "kelder":
			//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
			
			geefHuidigeSpeler().vermeerderActie(1);
			break;
		case "raadsheer":
			raadsheer();
			break;
		case "kapel":
			//je kan max 4 kaarten van je hand naar de vuilbak brengen
			break;
		case "raadszaal":
			raadszaal();

			break;
		case "feest":
			feest(kaart);
			break;
		case "festival":
			festival();
			break;
		case "tuinen":
			// elke 10 kaarten op het einde van het spel zijn 1 overwinningspunt waard.
			break;
		case "laboratorium":
			laboratorium();
			break;
		case "bibliotheek":
			// Trek kaarten tot er 7 kaarten in hand zijn
			
			//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
			break;
		case "markt":
			markt();
			break;
		case "militie":
			militie();
			break;
		case "mijn":
			// Geldkaart van je hand naar vuilbak brengen
			// andere geldkaart kopen die met waarde +3 van weggebrachte kaart
			break;
		case "slotgracht":
			slotgracht();
			break;
		case "geldschieter":
			// Indien je een kooper van je hand naar de vuilbak brengt
			geefHuidigeSpeler().vermeerderGeld(3);
			break;
		case "verbouwing":
			//test
			//test
			//breng een kaart van je hand naar de vuilbank
			//kost van deze kaart +2 om andere kaart te kunnen kopen
			break;
		case "smidse":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 3);
			break;
		case "spion":
			spion();
			break;
		case "dief":
			//elke speler toont zijn twee bovenste kaarten van zijn aftrekstapel
			// als het een geldkaart is, ... (bekijk dit verder)
			break;
		case "troonzaal":
			// kies actiekaart uit hand
			// speel twee x actiekaart			
			break;
		case "dorp":
			dorp();
			break;
		case "heks":
			heks();
			break;
		case "houthakker":
			houthakker();
			break;
		case "werkplaats":
			//koop een kaart die max 4 kost
			break;
		default:
			break;
		}
		//Test
		geefHuidigeSpeler().verminderActie(1);
		
		
	}
	public void avonturier (){
		int getal = 0 ;
		int i = 0;
		while (getal <=2 ) {
			
			Kaart huidigeKaart = geefHuidigeSpeler().trekStapel().get(i);
			if(huidigeKaart.kaartType() == "GeldKaart"){
				geefHuidigeSpeler().kaartenInHand().add(huidigeKaart);
				geefHuidigeSpeler().trekStapel().remove(huidigeKaart);
				
				}
			getal ++;
			i++;
		}
	}
	
	public void raadsheer(){
		geefHuidigeSpeler().vermeerderGeld(2);
		lijstenSamenvoegenShuffle(geefHuidigeSpeler().aflegStapel(), geefHuidigeSpeler().trekStapel());
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 4);
	}
	public void raadszaal (){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 4);
		geefHuidigeSpeler().vermeerderAankoop(1);
		andereSpeler().trekKaart(geefHuidigeSpeler().trekStapel(), 1);
		
	}
	public void feest(Kaart kaart){
		geefHuidigeSpeler().verwijderKaart(kaart);
		geefHuidigeSpeler().vermeerderGeld(5);
	}
	
	public void festival (){
		geefHuidigeSpeler().vermeerderActie(2);
		geefHuidigeSpeler().vermeerderAankoop(1);
		geefHuidigeSpeler().vermeerderGeld(2);
	}
	public void laboratorium (){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
		geefHuidigeSpeler().vermeerderActie(1);
	}
	
	public void markt(){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
		geefHuidigeSpeler().vermeerderActie(1);
		geefHuidigeSpeler().vermeerderAankoop(1);
		geefHuidigeSpeler().vermeerderGeld(1);
	}
	
	public void militie() {
		geefHuidigeSpeler().vermeerderGeld(2);
		
		
		//elke ander speler moet hand verminderen tot 3 kaarten
		
	}

	public void slotgracht(){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
		// bij gebruik van een aanvalskaart kan deze kaart gebruikt worden om zich te verdedigen.
	}
	
	public void spion(){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
		geefHuidigeSpeler().vermeerderActie(1);
		//elke speler (ook huidigespeler) toont zijn bovenste kaart van zijn aftrekstapel
		//speler kiest of hij deze teruglegt of naar zijn aflegstapel verplaatst
	}
	
	public void dorp(){
		geefHuidigeSpeler().vermeerderActie(2);
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
	}
	
	public void heks(){
		huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
		
		andereSpeler().trekStapel().add(new Kaart("vloek","overwinningsKaart",0,-1,""));
	}

	public void houthakker(){
		geefHuidigeSpeler().vermeerderAankoop(1);
		geefHuidigeSpeler().vermeerderGeld(2);
	}


	
	






	

}
