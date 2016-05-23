package engine;

import java.util.*;
//test
//test
//test

public class SpelFuncties {
	

	
	private List<Kaart> geldkaarten = new LinkedList<>(Arrays.asList(new Kaart("koper","geldkaart",0,1,"Deze kaart is 1 munt waard"),new Kaart("zilver","geldkaart",3,2,"Deze kaart is 2 munten waard"),new Kaart("goud","geldkaart",6,3,"Deze kaart is 3 munten waard")));
	private List<Kaart> overwinningskaarten = new LinkedList<>(Arrays.asList(new Kaart("landgoed","overwinningskaart",2,1,"Is op het einde van het spel 1 punt waard"),new Kaart("hertogdom","overwinningskaart",5,3,"Is op het einde van het spel 5 punten waard"),new Kaart("provincie","overwinningskaart",8,6,"Is op het einde van het spel 8 punten waard"),new Kaart("vloek","overwinningskaart",0,-1,"Vermindert de waarde op het einde van het spel met 1 punt ")));
	private List<Kaart> actiekaarten = new LinkedList<>(Arrays.asList(new Kaart("avonturier",false,6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."),
			new Kaart("bureaucraat",true,4,true,0,0,0,0,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)"), new Kaart("kelder",false,2,true,0,1,0,0,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart."), new Kaart("raadsheer",false,3,true,0,0,0,2,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen"),new Kaart("kapel",false,2,true,0,0,0,0,"Vernietig 4 of minder kaarten uit je hand"),new Kaart("raadszaal",false,5,true,1,0,4,0,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart"),new Kaart("feest",false,4,true,0,0,0,5,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder."),
			new Kaart("festival",false,5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten"),new Kaart("tuinen",false,4,true,0,0,0,0,"Elke 10 kaarten in je stapel zijn aan het einde van  het spel 1 landgoed waard (naar beneden afronden)."),new Kaart("laboratorium",false,5,false,0,1,2,0,"+2 kaarten / +1 actie"),new Kaart("bibliotheek",false,5,true,0,0,0,0,"Vul je hand aan tot 7 kaarten. Getrokken actiekaarten mag je houden of apart bewaren en vervangen door nieuwe kaarten. Als je hand is aangevuld leg je de apart bewaarde actiekaarten af."),new Kaart("markt",false,5,false,1,1,1,1,"+1 kaart/ +1 actie / +1 aanschaf / +1 munt"),new Kaart("militie",true,4,true,0,0,0,2,"+2 munten/ Iedere andere speler legt naar zijn keuze kaarten af totdat hij er 3 op handen heeft."),new Kaart("mijn",false,5,true,0,0,0,3,"Vernietig een geldkaart uit je hand. Neem een geldkaart die ten hoogste drie munten meer waard is en neem deze op handen.")
			,new Kaart("slotgracht",false,2,true,0,0,2,0,"+2 kaarten / Als een andere speler een aanvalskaart speelt, mag je de Slotgracht tonen. In dat geval heeft de aanval op jou geen effect."),new Kaart("geldschieter",false,4,true,0,0,0,0,"Vernietig een koperkaart uit je hand. Als je dat doet, heb je deze beurt met 3 munten."),new Kaart("verbouwing",false,4,true,0,0,0,2,"Vernietig een kaart uit je hand. Pak een kaart die ten hoogste 2 munten meer waard is dan de vernietigde kaart."),new Kaart("smidse",false,4,false,0,0,3,0,"+3 kaarten"),new Kaart("spion",true,4,true,0,1,1,0,"+1 kaart / +1 actie / Alle spelers tonen de bovenste kaart van hun trekstapel. De spion bepaalt of ze blijven liggen of worden afgelegd."),new Kaart("dief",true,4,true,0,0,0,0,"Iedere andere speler toont de bovenste 2 kaarten van zijn trekstapel. Als een speler geldkaarten toont, moet hij er ��n naar jouw keuze vernietigen. Je mag een of meer van deze vernietigde kaarten pakken en afleggen. De andere spelers leggen andere getoonde kaarten op hun aflegstapel."),new Kaart("troonzaal",false,4,true,0,0,0,0,"Kies een actiekaart uit je hand. Speel deze tweemaal.")
			,new Kaart("dorp",false,3,false,0,2,1,0,"+1 kaart / +2 acties"),new Kaart("heks",true,5,true,0,0,2,0,"+2 kaarten / Iedere andere speler pakt 1 vloekkaart."),new Kaart("werkplaats",false,3,true,0,0,0,4,"Pak een kaart die maximaal 4 munten kost."),new Kaart("houthakker",false,3,false,1,0,0,2,"+1 aanschaf / +2 munten")));
	private Speler[] spelers;
	ExtraInfo extraInfoGeven = null;
	private List<Kaart> lijst10Actiekaarten = new LinkedList<>();
	private List<Kaart> kaartenVanHetSpel = new LinkedList<>();
	private List<Stapel> lijstStapel = new LinkedList<>();
	private List<Speler>LijstAndereSpelers = new LinkedList<Speler>();
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;

	
	
	
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
	
	public void LijstAndereSpelers(Speler huidigeSpeler){
		
		for (int i = 0; i < spelers.length; i++){
			if(spelers[i].geefNaam() != huidigeSpeler.geefNaam()){
				LijstAndereSpelers.add(spelers[i]);}}
		
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
	
	public boolean spelNogNietBe�indigd(){
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
	
	public void geldOpSpeelVeld() {
		geefHuidigeSpeler().verminderGeld(geefHuidigeSpeler().geefGeld());
		for (int i = 0; i < huidigeSpeler.geefSpeelGebied().size(); i++) {
			huidigeSpeler.vermeerderGeld(huidigeSpeler.geefSpeelGebied().get(i).geefWaarde());}
			
	}
	public List<Kaart> actiekaartenGenereren() {
	
		Collections.shuffle(actiekaarten);
		for (int i = 0; i < 10; i++) {this.lijst10Actiekaarten.add(actiekaarten.get(i));}
		return this.lijst10Actiekaarten;
	}
	
	public void stapelsAanmaken(List<Kaart> kaartenVanHetSpel) {

		for (int j = 0; j < kaartenVanHetSpel.size(); j++) {lijstStapel.add(new Stapel(kaartenVanHetSpel.get(j).geefNaam()));}
		
	}
	
	public void trekKaartVanTrekStapel(Speler speler,int aantal) {
		if (speler.geefTrekStapel().size() < aantal) {
			lijstenSamenvoegenBijBestaandeLijst(speler.geefTrekStapel(), speler.geefAflegStapel(),true,true);
		}		
		for (int i = 0; i < aantal; i++) {speler.geefKaartenInHand().add(speler.geefTrekStapel().get(i));}
		for (int i = 0; i < aantal; i++) {speler.geefTrekStapel().remove(0);}
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
	
	public boolean controleerOpTypeKaartenInHand(Speler speler, String type){
		boolean tmp = false;
		for (int i = 0; i < speler.geefKaartenInHand().size(); i++) {
			if(speler.geefKaartenInHand().get(i).geefKaartType() == type){
				tmp = true;
			}
		}
		return tmp;
	}

	public void koopKaart(Kaart gekozenKaart) {
		int kost = gekozenKaart.geefKost();			
		huidigeSpeler.verminderGeld(kost);
		huidigeSpeler.verminderAankoop(1);
		brengGekochteKaartNaarAflegstapel(gekozenKaart);
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
	public List<Speler> geefLijstAndereSpelers() {
		return this.LijstAndereSpelers;
		
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
		geefLijstAndereSpelers().clear();
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
				trekKaartVanTrekStapel(huidigeSpeler,actiekaart.geefExtraKaart());
	}}}
	
	public ExtraInfo actieFase1Uitvoeren(Kaart kaart) {
		extraInfoGeven= new ExtraInfo(kaart, 0,"","");
		LijstAndereSpelers(huidigeSpeler);
		switch (kaart.geefNaam()) {
		case "avonturier":
			//OK
			avonturier();
			break;
		case "raadsheer":
			//OK
			raadsheer();
			break;
		case "raadszaal":
			//OK
			raadszaal();
			break;	
		case "bureaucraat":
			brengGekochteKaartNaarAflegstapel(geldkaarten.get(1));
			extraInfoGeven = new ExtraInfo(kaart,1,"Trek een overwinningskaart uit uw hand.",kaart.geefNaam());			
			break;
		case "kelder":
			extraInfoGeven = new ExtraInfo(kaart,huidigeSpeler.geefKaartenInHand().size(),"Hoeveel kaarten wenst u af te leggen?:","actieEnkeleSpeler");
			break;
		case "kapel":
			extraInfoGeven = new ExtraInfo(kaart,4,"Hoeveel kaarten wenst u te vernietigen?:","actieEnkeleSpeler");
			break;
		case "feest":
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefVuilbakStapel(), kaart,huidigeSpeler.geefSpeelGebied());
			extraInfoGeven= new ExtraInfo(kaart, 0,"","");
			break;
		case "bibliotheek":
			break;
		case "militie":
			extraInfoGeven = new ExtraInfo(kaart, 1,"Verminder uw kaarten in hand tot 3 kaarten!",kaart.geefNaam());
			break;
		case "mijn":
			brengAlleGeldkaartenUitHandNaarStapel(huidigeSpeler.geefVuilbakStapel());
			extraInfoGeven= new ExtraInfo(kaart, 0,"","");
			break;
		case "slotgracht":
			extraInfoGeven= new ExtraInfo(kaart, 0,"","");
			break;
		case "geldschieter":
			extraInfoGeven = new ExtraInfo(kaart,1,"Hoeveel koperkaarten wenst u te vernietigen?(geef een keuze tussen 0 en 1):",kaart.geefNaam());
			break;
		case "verbouwing":
			extraInfoGeven = new ExtraInfo(kaart,1,"Hoeveel kaarten wenst u te vernietigen?: (geef een keuze tussen 0 en 1)","actieEnkeleSpeler");
			break;
		case "spion":
			extraInfoGeven= new ExtraInfo(kaart, 0,"","");
			break;
		case "dief":
			extraInfoGeven= new ExtraInfo(kaart, 0,"","");
			break;
		case "troonzaal":
			extraInfoGeven= new ExtraInfo(kaart, 0,"",kaart.geefNaam());
			break;
		case "heks":
			heks();
			break;
		default:
			break;
		}
		
		return extraInfoGeven;
		
	}
	
	public void actieFase2Uitvoeren(ExtraInfo kaartMetExtraInfo) {
		
		switch (kaartMetExtraInfo.geefActiekaart().geefNaam()) {
		case "bureaucraat":
			bureaucraat(kaartMetExtraInfo);
			break;
		case "kelder":
			kelder(kaartMetExtraInfo);
			break;
		case "kapel":
			kapel(kaartMetExtraInfo);
			break;
		case "feest":
			feest(kaartMetExtraInfo);
			break;
		case "bibliotheek":
			bibliotheek(kaartMetExtraInfo);
			break;
		case "militie":
			militie(kaartMetExtraInfo);
			break;
		case "mijn":
			mijn(kaartMetExtraInfo);
			break;
		case "slotgracht":
			slotgracht(kaartMetExtraInfo);
			break;
		case "geldschieter":
			geldschieter(kaartMetExtraInfo);
			break;
		case "verbouwing":
			verbouwing(kaartMetExtraInfo);
			break;
		case "spion":
			spion(kaartMetExtraInfo);
			break;
		case "dief":
			dief(kaartMetExtraInfo);
			break;
		case "troonzaal":
			actieUitvoeren(kaartMetExtraInfo.geefGekozenKaart().get(0));		
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
		// nog eens bekijken! nog niet inorde!!
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
	public void bureaucraat(ExtraInfo kaartMetExtraInfo) {
		//andere spelers leggen een overwinningskaart uit zijn hand op zijn trekstapel
		for (int i = 0; i < kaartMetExtraInfo.geefGekozenKaart().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(geefLijstAndereSpelers().get(kaartMetExtraInfo.geefSpelersIndex()).geefKaartenInHand(), kaartMetExtraInfo.geefGekozenKaart().get(i), geefHuidigeSpeler().geefAflegStapel());
		}

	}
	public void kelder(ExtraInfo kaartMetExtraInfo) {
		//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
		int aantal = 0;
		for (int i = 0; i < kaartMetExtraInfo.geefGekozenKaart().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), kaartMetExtraInfo.geefGekozenKaart().get(i), huidigeSpeler.geefAflegStapel());
			aantal++;
		}
		trekKaartVanTrekStapel(huidigeSpeler,aantal);
		
	}
	public void raadsheer(){
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefTrekStapel(),true,true);
	}
	
	public void kapel(ExtraInfo kaartMetExtraInfo) {
		//je kan max 4 kaarten van je hand naar de vuilbak brengen

		for (int i = 0; i < kaartMetExtraInfo.geefGekozenKaart().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), kaartMetExtraInfo.geefGekozenKaart().get(i), huidigeSpeler.geefVuilbakStapel());
		}
	}
	public void raadszaal (){
		for (int i = 0; i < geefLijstAndereSpelers().size(); i++){
			trekKaartVanTrekStapel(geefLijstAndereSpelers().get(i),1);}
		}
	
	public void feest(ExtraInfo kaartMetExtraInfo){
		brengGekochteKaartNaarAflegstapel(kaartMetExtraInfo.geefGekozenKaart().get(0));
		int kost = kaartMetExtraInfo.geefGekozenKaart().get(0).geefKost();
		huidigeSpeler.verminderGeld(kost);
		huidigeSpeler.verminderAankoop(1);
	}
	
	public void bibliotheek(ExtraInfo kaartMetExtraInfo){
		// Trek kaarten tot er 7 kaarten in hand zijn
		if(huidigeSpeler.geefKaartenInHand().size()<7){	trekKaartVanTrekStapel(huidigeSpeler,1);}
		//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
			}
	
	public void militie(ExtraInfo kaartMetExtraInfo) {
		//elke ander speler moet hand verminderen tot 3 kaarten
		for (int i = 0; i < kaartMetExtraInfo.geefGekozenKaart().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(geefLijstAndereSpelers().get(kaartMetExtraInfo.geefSpelersIndex()).geefKaartenInHand(), kaartMetExtraInfo.geefGekozenKaart().get(i), geefHuidigeSpeler().geefAflegStapel());
		}		
	}

	public void mijn(ExtraInfo kaartMetExtraInfo) {
		// andere geldkaart kopen die met waarde +3 van weggebrachte kaart
	}
	public void slotgracht(ExtraInfo kaartMetExtraInfo){
		// bij gebruik van een aanvalskaart kan deze kaart gebruikt worden om zich te verdedigen.
	}
	public void geldschieter(ExtraInfo kaartMetExtraInfo) {
		// Indien je een kooper van je hand naar de vuilbak brengt
		if(!kaartMetExtraInfo.geefGekozenKaart().isEmpty()){
			huidigeSpeler.vermeerderGeld(3);
		}
	}
	public void verbouwing(ExtraInfo kaartMetExtraInfo) {
		//breng een kaart van je hand naar de vuilbank
		if(kaartMetExtraInfo.geefGekozenKaart().size()>0){
		brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), kaartMetExtraInfo.geefGekozenKaart().get(0), huidigeSpeler.geefVuilbakStapel());
		//kost van deze kaart +2 om andere kaart te kunnen kopen
		huidigeSpeler.vermeerderGeld(kaartMetExtraInfo.geefGekozenKaart().get(0).geefKost());}
	}
	public void spion(ExtraInfo kaartMetExtraInfo){
		
		//elke speler (ook huidigespeler) toont zijn bovenste kaart van zijn aftrekstapel
		//speler kiest of hij deze teruglegt of naar zijn aflegstapel verplaatst
	}
	public void dief(ExtraInfo kaartMetExtraInfo) {
		//elke speler toont zijn twee bovenste kaarten van zijn aftrekstapel
		// als het een geldkaart is, ... (bekijk dit verder)
	}
		
	public void heks(){
		
		for (int i = 0; i < geefLijstAndereSpelers().size(); i++){
			geefLijstAndereSpelers().get(i).geefAflegStapel().add(overwinningskaarten.get(3));
		}
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
