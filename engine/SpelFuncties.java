package engine;

import java.util.*;

public class SpelFuncties {
	
//test
	
	
	
	private List<Kaart> geldkaarten = new LinkedList<>(Arrays.asList(new Kaart("koper","geldkaart",0,1,"Deze kaart is 1 munt waard"),new Kaart("zilver","geldkaart",3,2,"Deze kaart is 2 munten waard"),new Kaart("goud","geldkaart",6,3,"Deze kaart is 3 munten waard")));
	private List<Kaart> overwinningskaarten = new LinkedList<>(Arrays.asList(new Kaart("landgoed","overwinningskaart",2,1,"Is op het einde van het spel 1 punt waard"),new Kaart("hertogdom","overwinningskaart",5,3,"Is op het einde van het spel 5 punten waard"),new Kaart("provincie","overwinningskaart",8,6,"Is op het einde van het spel 8 punten waard")));
	private List<Kaart> actiekaarten = new LinkedList<>(Arrays.asList(new Kaart("avonturier",false,6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."),
			new Kaart("bureaucraat",true,4,true,0,0,0,0,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)"), new Kaart("kelder",false,2,true,0,1,0,0,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart."), new Kaart("raadsheer",false,3,true,0,0,0,2,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen"),new Kaart("kapel",false,2,true,0,0,0,0,"Vernietig 4 of minder kaarten uit je hand"),new Kaart("raadszaal",false,5,true,1,0,4,0,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart"),new Kaart("feest",false,4,true,0,0,0,5,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder."),
			new Kaart("festival",false,5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten"),new Kaart("tuinen",false,4,true,0,0,0,0,"Elke 10 kaarten in je stapel zijn aan het einde van  het spel 1 landgoed waard (naar beneden afronden)."),new Kaart("laboratorium",false,5,false,0,1,2,0,"+2 kaarten / +1 actie"),new Kaart("bibliotheek",false,5,true,0,0,0,0,"Vul je hand aan tot 7 kaarten. Getrokken actiekaarten mag je houden of apart bewaren en vervangen door nieuwe kaarten. Als je hand is aangevuld leg je de apart bewaarde actiekaarten af."),new Kaart("markt",false,5,false,1,1,1,1,"+1 kaart/ +1 actie / +1 aanschaf / +1 munt"),new Kaart("militie",true,4,true,0,0,0,2,"+2 munten/ Iedere andere speler legt naar zijn keuze kaarten af totdat hij er 3 op handen heeft."),new Kaart("mijn",false,5,true,0,0,0,3,"Vernietig een geldkaart uit je hand. Neem een geldkaart die ten hoogste drie munten meer waard is en neem deze op handen.")
			,new Kaart("slotgracht",false,2,true,0,0,2,0,"+2 kaarten / Als een andere speler een aanvalskaart speelt, mag je de Slotgracht tonen. In dat geval heeft de aanval op jou geen effect."),new Kaart("geldschieter",false,4,true,0,0,0,0,"Vernietig een koperkaart uit je hand. Als je dat doet, heb je deze beurt met 3 munten."),new Kaart("verbouwing",false,4,true,0,0,0,2,"Vernietig een kaart uit je hand. Pak een kaart die ten hoogste 2 munten meer waard is dan de vernietigde kaart."),new Kaart("smidse",false,4,false,0,0,3,0,"+3 kaarten"),new Kaart("spion",true,4,true,0,1,1,0,"+1 kaart / +1 actie / Alle spelers tonen de bovenste kaart van hun trekstapel. De spion bepaalt of ze blijven liggen of worden afgelegd."),new Kaart("dief",true,4,true,0,0,0,0,"Iedere andere speler toont de bovenste 2 kaarten van zijn trekstapel. Als een speler geldkaarten toont, moet hij er één naar jouw keuze vernietigen. Je mag een of meer van deze vernietigde kaarten pakken en afleggen. De andere spelers leggen andere getoonde kaarten op hun aflegstapel."),new Kaart("troonzaal",false,4,true,0,0,0,0,"Kies een actiekaart uit je hand. Speel deze tweemaal.")
			,new Kaart("dorp",false,3,false,0,2,1,0,"+1 kaart / +2 acties"),new Kaart("heks",true,5,true,0,0,2,0,"+2 kaarten / Iedere andere speler pakt 1 vloekkaart."),new Kaart("werkplaats",false,3,true,0,0,0,4,"Pak een kaart die maximaal 4 munten kost."),new Kaart("houthakker",false,3,false,1,0,0,2,"+1 aanschaf / +2 munten")));
	private Speler[] spelers;
	ExtraInfo extraInfoGeven = null;
	private List<Kaart> lijst10Actiekaarten = new LinkedList<>();
	private List<Kaart> kaartenVanHetSpel = new LinkedList<>();
	private List<Stapel> lijstStapel = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;
	private ExtraInfo extraInfoHalen;
	
	
	
	public SpelFuncties() {

		actiekaartenGenereren();
		kaartenVanHetSpel = lijstenSamenvoegenTotNieuweLijst(lijst10Actiekaarten,lijstenSamenvoegenTotNieuweLijst(geldkaarten, overwinningskaarten, false),false);
		stapelsAanmaken(kaartenVanHetSpel);
		
	}
		
	
	public  void maakSpelersAan(String SpelersNamen[]){
		 spelers = new Speler[SpelersNamen.length];
		for (int i = 0; i < SpelersNamen.length; i++) {
			spelers[i] = new Speler(SpelersNamen[i]);
		}
		huidigeSpeler = spelers[0];
	}
	
	
	public void volgendeSpeler(){
		int plaatsInDeArray = 0;
		for (int i = 0; i < spelers.length; i++) {
			if (huidigeSpeler.geefNaam().equals(spelers[i].geefNaam()))
			{
				plaatsInDeArray = i+1;
				break;
			}
		}
		if(plaatsInDeArray == spelers.length)
		{
			plaatsInDeArray = 0;
		}
		huidigeSpeler =  spelers[plaatsInDeArray];
		
	}
	
	public void AndereSpelers(int index){
		Speler andereSpeler = spelers[index];
		huidigeSpeler = andereSpeler;
	}
	
	

	public void verminderTafelstapel(String kaartnaam){
		
		for (int i = 0; i < lijstStapel.size(); i++) {
			String Kaart = lijstStapel.get(i).geefStapelNaam();
			if (kaartnaam.equals(Kaart))
			{
				lijstStapel.get(i).verminderAantalKaarten();	
			}
		}
	}
	
	public boolean spelNogNietBeëindigd(){
		int Legestapels = 0;
		Boolean tmp = true;
		
		for (int i = 0; i < lijstStapel.size(); i++) 
		{
			if(lijstStapel.get(i).geefAatalResterendeKaartenInDeStapel() <= 0)
			{
				Legestapels = Legestapels+1;
				String lijstNaam = lijstStapel.get(i).geefStapelNaam();
				if (lijstNaam.equals("provincie") || Legestapels >=3)
				{
					tmp = false;
				}
			}
		}
		return tmp;
		
	}
	
	
	
	public List<Kaart> lijstenSamenvoegenBijBestaandeLijst(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst,boolean shuffle,boolean verwijderBijTeVoegenLijst) {
		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));		}
		if(verwijderBijTeVoegenLijst){bijTeVoegenLijst.clear();}
		if(shuffle){Collections.shuffle(primaireLijst);}
		return primaireLijst;

	}
	public List<Kaart> lijstenSamenvoegenTotNieuweLijst(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst,boolean shuffle){
		List<Kaart> nieuweLijst = new LinkedList<Kaart>();
		for (int i = 0; i < primaireLijst.size(); i++) {
			nieuweLijst.add(primaireLijst.get(i));
		}
		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			nieuweLijst.add(bijTeVoegenLijst.get(i));
		}
		if(shuffle){Collections.shuffle(nieuweLijst);}
		return nieuweLijst;

	}

	public List<Kaart> actiekaartenGenereren() {
	
		Collections.shuffle(actiekaarten);
		for (int i = 0; i < 10; i++) {this.lijst10Actiekaarten.add(actiekaarten.get(i));}
		return this.lijst10Actiekaarten;
	}
	
	public void stapelsAanmaken(List<Kaart> kaartenVanHetSpel) {

		for (int j = 0; j < kaartenVanHetSpel.size(); j++) {lijstStapel.add(new Stapel(kaartenVanHetSpel.get(j).geefNaam()));}
		
	}
	
	public void trekKaartVanTrekStapel(int aantal) {
		if (huidigeSpeler.geefTrekStapel().size() < aantal) {
			lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefTrekStapel(), huidigeSpeler.geefAflegStapel(),true,true);
		}		
		for (int i = 0; i < aantal; i++) {huidigeSpeler.geefKaartenInHand().add(huidigeSpeler.geefTrekStapel().get(i));}
		for (int i = 0; i < aantal; i++) {huidigeSpeler.geefTrekStapel().remove(0);}
	}


	public List<Kaart> kaartenDieJeKuntKopen() {
		List<Kaart> lijstMetKaartenDieJeKuntKopen = new LinkedList<Kaart>();
		for (int i = 0; i < geefLijstKaartenVanHetSpel().size(); i++) {
			if (geefLijstKaartenVanHetSpel().get(i).geefKost() <= huidigeSpeler.geefGeld()) {lijstMetKaartenDieJeKuntKopen.add(geefLijstKaartenVanHetSpel().get(i));}
		}
		return lijstMetKaartenDieJeKuntKopen;
	}
	
	public int geldInHand() {
		int geld = 0;
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {geld += huidigeSpeler.geefKaartenInHand().get(i).geefWaarde();}
		return geld;
	}

		
	public List<Kaart> neemActiekaartenUitHand(){
		List<Kaart> actiekaartenUitHand = new LinkedList<Kaart>();
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {
			if (huidigeSpeler.geefKaartenInHand().get(i).geefKaartType() == "actiekaart") {actiekaartenUitHand.add(huidigeSpeler.geefKaartenInHand().get(i));}
		}
		return actiekaartenUitHand;
	}
	

	public List<Kaart> geefLijstGeldkaarten() {
		return this.geldkaarten;
	}
	public List<Kaart> geefLijstOverwinningskaarten() {
		return this.overwinningskaarten;	
	}
	public List<Kaart> geefLijstAlleActiekaarten() {
		return this.actiekaarten;
	}
	public List<Kaart> geefLijstKaartenVanHetSpel() {
		return this.kaartenVanHetSpel;
	}
	public List<Stapel> geefLijstStapels() {
		return this.lijstStapel;
	}
	public List<Kaart> geefLijst10GekozenActiekaarten() {
		return this.lijst10Actiekaarten;
	}
	public Speler[] geefLijstSpelers() {
		return this.spelers;
	}
public Speler geefHuidigeSpeler(){
		
		return this.huidigeSpeler;
	}
public void zetHuidigeSpeler(Speler speler) {
	for (int i = 0; i < spelers.length; i++) {
		if (speler.geefNaam().equals(spelers[i].geefNaam())){
			huidigeSpeler = spelers[i];}
	}
}

	public void maakKaartInHandLeeg(List<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			huidigeSpeler.geefVuilbakStapel().add(lijst.get(i));
		}
		
		lijst.clear();
		
	}
		
	
	
	public void brengAlleKaartenNaarAflegstapel(){
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefSpeelGebied(), false,true);
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefKaartenInHand(),false,true);
	}
	

	public ExtraInfo actieUitvoeren(Kaart kaart) {
		brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), kaart,huidigeSpeler.geefSpeelGebied());
		
		gewoneActiekaartenUitvoeren(kaart);
		if(kaart.specialeKaart()){actieFase1Uitvoeren(kaart);}	
		return extraInfoGeven;
	}
	
	public void gewoneActiekaartenUitvoeren(Kaart kaart){
		for(int i=0;i<lijst10Actiekaarten.size();i++){
			Kaart actiekaart = lijst10Actiekaarten.get(i);
			if(actiekaart.geefNaam().equals(kaart.geefNaam())){
				vermeerderAankoopGeldEnActie(actiekaart.geefExtraAankoop(), actiekaart.geefExtraMunten(), actiekaart.geefExtraActie());
				trekKaartVanTrekStapel(actiekaart.geefExtraKaart());
	}}}
	
	public ExtraInfo actieFase1Uitvoeren(Kaart kaart) {
		
		switch (kaart.geefNaam()) {
		case "avonturier":
			//OK
			avonturier();
			break;
		case "bureaucraat":
			brengGekochteKaartNaarAflegstapel(geldkaarten.get(1));
			break;
		case "kelder":
			extraInfoGeven = new ExtraInfo(kaart,4);
			//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
			
			break;
		case "raadsheer":
			//OK
			raadsheer();
			break;
		case "kapel":
			
			
			break;
		case "raadszaal":
			//OK
			raadszaal();
			break;
		case "feest":
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefVuilbakStapel(), kaart,huidigeSpeler.geefKaartenInHand());
		
			break;
		case "bibliotheek":
			bibliotheek();
			break;
		case "militie":
			
			break;
		case "mijn":
			brengAlleGeldkaartenUitHandNaarStapel(huidigeSpeler.geefVuilbakStapel());
			
			break;
		case "slotgracht":
			slotgracht();
			break;
		case "geldschieter":
			
			break;
		case "verbouwing":
			
			break;
		case "spion":
			spion();
			break;
		case "dief":
			break;
		case "troonzaal":
				
			break;
		case "heks":
			heks();
			break;
		default:
			break;
		}
		
		return extraInfoGeven;
		
	}
	
	public void actieFase2Uitvoeren(List<ExtraInfo> kaartMetExtraInfo) {
		switch (kaartMetExtraInfo.get(0).geefActiekaart().geefNaam()) {
		
		case "bureaucraat":
			bureaucraat(kaartMetExtraInfo);
			break;
		case "kelder":
			kelder(kaartMetExtraInfo);
			break;
		case "kapel":
			kapel();
			break;
		case "feest":
			feest();
			break;
		case "bibliotheek":
			bibliotheek();
			break;
		case "militie":
			militie();
			break;
		case "mijn":
			break;
		case "slotgracht":
			slotgracht();
			break;
		case "geldschieter":
			geldschieter();
			break;
		case "verbouwing":
			verbouwing();
			break;
		case "spion":
			spion();
			break;
		case "dief":
			break;
		case "troonzaal":
			actieUitvoeren(kaartMetExtraInfo.get(0).geefGekozenKaart());		
			break;
		case "heks":
			heks();
			break;
		default:
			break;
		}
		huidigeSpeler.verminderActie(1);
	}
	
	public void avonturier (){
		int getal = 0 ;
		int i = 0;
		while (getal < 2 ) {
			Kaart huidigeKaart = huidigeSpeler.geefTrekStapel().get(i);
			if(huidigeKaart.geefKaartType() == "geldkaart")
			{
				huidigeSpeler.geefKaartenInHand().add(huidigeKaart);
				huidigeSpeler.geefTrekStapel().remove(i);
				getal ++;
			}
			i++;
		}
		
	}
	public void bureaucraat(List<ExtraInfo> kaartMetExtraInfo) {
		
		//andere spelers leggen een overwinningskaart uit zijn hand op zijn trekstapel
		Speler huidigeSpeler = this.huidigeSpeler;
		for (int i = 0; i < kaartMetExtraInfo.size(); i++) {
			AndereSpelers(kaartMetExtraInfo.get(i).geefPlaatsSpeler());
			brengEenKaartVanDeEneNaarAndereStapel(geefHuidigeSpeler().geefKaartenInHand(), geefHuidigeSpeler().geefKaartenInHand().get(kaartMetExtraInfo.get(i).geefKaartKeuze()), geefHuidigeSpeler().geefAflegStapel());
		}
		this.huidigeSpeler = huidigeSpeler;

	}
	public void kelder(List<ExtraInfo> kaart) {
		//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
		int aantal = 0;
		for (int i = 0; i < kaart.size(); i++) {
			huidigeSpeler.geefAflegStapel().add(huidigeSpeler.geefKaartenInHand().get(kaart.get(i).geefKaartKeuze()));
			huidigeSpeler.geefKaartenInHand().remove(kaart.get(0).geefKaartKeuze());
			aantal ++;
		}
		trekKaartVanTrekStapel(aantal);
		
	}
	public void raadsheer(){
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefTrekStapel(),true,true);
	}
	
	public void kapel() {
		//je kan max 4 kaarten van je hand naar de vuilbak brengen
	}
	public void raadszaal (){
		Speler huidigeSpeler = this.huidigeSpeler;
		for (int i = 0; i < spelers.length; i++){
			if(spelers[i].geefNaam() != huidigeSpeler.geefNaam()){
				AndereSpelers(i);
				trekKaartVanTrekStapel(1);}}
		this.huidigeSpeler = huidigeSpeler;
	}
	public void feest(){
		Kaart gekochteKaart =kaartenDieJeKuntKopen().get(extraInfoHalen.geefKaartKeuze());
		brengGekochteKaartNaarAflegstapel(gekochteKaart);
		int kost = gekochteKaart.geefKost();
		geefHuidigeSpeler().verminderGeld(kost);
		geefHuidigeSpeler().verminderAankoop(1);
	}
	
	public void bibliotheek(){
		// Trek kaarten tot er 7 kaarten in hand zijn
		if(huidigeSpeler.geefKaartenInHand().size()<7){	trekKaartVanTrekStapel(1);}
		//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
		
	}
	
	public void militie() {
		//elke ander speler moet hand verminderen tot 3 kaarten
	}

	public void mijn() {
		
			
		// andere geldkaart kopen die met waarde +3 van weggebrachte kaart
	}
	public void slotgracht(){
		// bij gebruik van een aanvalskaart kan deze kaart gebruikt worden om zich te verdedigen.
	}
	public void geldschieter() {
		// Indien je een kooper van je hand naar de vuilbak brengt
	}
	public void verbouwing() {
		//breng een kaart van je hand naar de vuilbank
		//kost van deze kaart +2 om andere kaart te kunnen kopen
	}
	public void spion(){
		
		//elke speler (ook huidigespeler) toont zijn bovenste kaart van zijn aftrekstapel
		//speler kiest of hij deze teruglegt of naar zijn aflegstapel verplaatst
	}
	public void dief() {
		//elke speler toont zijn twee bovenste kaarten van zijn aftrekstapel
		// als het een geldkaart is, ... (bekijk dit verder)
	}
	public void troonzaal() {
		// kies actiekaart uit hand
		// speel twee x actiekaart
	}
	
	public void heks(){
		Speler huidigeSpeler = this.huidigeSpeler;
		for (int i = 0; i < spelers.length; i++){
			if(spelers[i].geefNaam() != huidigeSpeler.geefNaam()){
				AndereSpelers(i);
				geefHuidigeSpeler().geefAflegStapel().add(new Kaart("vloek","overwinningskaart",0,-1,"Vermindert de waarde op het einde van het spel met 1 punt "));}}
				
		this.huidigeSpeler = huidigeSpeler;
	}
	
	public void vermeerderAankoopGeldEnActie(int aankoop, int geld, int actie)
	{
		huidigeSpeler.vermeerderAankoop(aankoop);
		huidigeSpeler.vermeerderGeld(geld);
		huidigeSpeler.vermeerderActie(actie);
	}
	

	public void brengAlleGeldkaartenUitHandNaarStapel(List<Kaart> lijst){
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {
			if(huidigeSpeler.geefKaartenInHand().get(i).geefKaartType() == "geldkaart"){
				lijst.add(huidigeSpeler.geefKaartenInHand().get(i));
				huidigeSpeler.geefKaartenInHand().remove(i);
				i--;
			}}
		}
			
		
	public void brengEenKaartVanDeEneNaarAndereStapel(List<Kaart>verwijderStapel,Kaart kaart,List<Kaart> toevoegStapel){
		boolean tmp = false;
		for (int i = 0; i < verwijderStapel.size()&& tmp == false; i++ ) {
			if(verwijderStapel.get(i).geefNaam() == kaart.geefNaam()){
				verwijderStapel.remove(i);
				toevoegStapel.add(kaart);
				tmp = true;
				
			}
		}
	}
	public void brengGekochteKaartNaarAflegstapel(Kaart kaart) {
		geefHuidigeSpeler().geefAflegStapel().add(kaart);
		verminderTafelstapel(kaart.geefNaam());
		
	}

	public void berekenScoreSpelers() {
		int aantal = 0;
		for (int i = 0; i < spelers.length; i++) {
			Speler speler = spelers[i];
			brengAlleKaartenNaarAflegstapel();
			for (int j = 0; j < speler.geefAflegStapel().size(); j++) {
				Kaart kaart = speler.geefAflegStapel().get(j);
				if(kaart.geefKaartType() == "overwinningskaart"){
					speler.vermeerderScore(kaart.geefWaarde());
				}
				if(kaart.geefNaam()=="tuinen"){
					aantal ++;
				}
			}
			//NOG BEKIJKEN!!! mss met een functie!
			int extraPunten = ((speler.geefScore()-(speler.geefScore()%10))/10)*aantal;
			speler.vermeerderScore(extraPunten);
		
		}
		
	}
}
