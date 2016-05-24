package engine;

import java.util.*;

public class SpelFuncties {
	ExtraInfo extraInfoMeegeven = null;
	private List<Kaart> lijst10Actiekaarten = new LinkedList<>();
	private List<Kaart> kaartenVanHetSpel = new LinkedList<>();
	private List<Stapel> lijstStapel = new LinkedList<>();
	private List<Speler> lijstAlleSpelers = new LinkedList<>();
	private List<Speler> LijstAndereSpelers = new LinkedList<>();
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;
	private List<Kaart> geldkaarten = new LinkedList<>(Arrays.asList(new Kaart("koper","geldkaart",0,1,"Deze kaart is 1 munt waard"),new Kaart("zilver","geldkaart",3,2,"Deze kaart is 2 munten waard"),new Kaart("goud","geldkaart",6,3,"Deze kaart is 3 munten waard")));
	private List<Kaart> overwinningskaarten = new LinkedList<>(Arrays.asList(new Kaart("landgoed","overwinningskaart",2,1,"Is op het einde van het spel 1 punt waard"),new Kaart("hertogdom","overwinningskaart",5,3,"Is op het einde van het spel 5 punten waard"),new Kaart("provincie","overwinningskaart",8,6,"Is op het einde van het spel 8 punten waard"),new Kaart("vloek","overwinningskaart",0,-1,"Vermindert de waarde op het einde van het spel met 1 punt ")));
	private List<Kaart> actiekaarten = new LinkedList<>(Arrays.asList(new Kaart("avonturier",6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel.",false),
			new Kaart("bureaucraat",4,true,0,0,0,0,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)",false), new Kaart("kelder",2,true,0,1,0,0,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart.",false), new Kaart("raadsheer",3,true,0,0,0,2,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen",false),new Kaart("kapel",2,true,0,0,0,0,"Vernietig 4 of minder kaarten uit je hand",true),new Kaart("raadszaal",5,true,1,0,4,0,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart",false),new Kaart("feest",4,true,0,0,0,5,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder.",false),
			new Kaart("festival",5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten",false),new Kaart("tuinen",4,true,0,0,0,0,"Elke 10 kaarten in je stapel zijn aan het einde van  het spel 1 landgoed waard (naar beneden afronden).",true),new Kaart("laboratorium",5,false,0,1,2,0,"+2 kaarten / +1 actie",false),new Kaart("bibliotheek",5,true,0,0,0,0,"Vul je hand aan tot 7 kaarten. Getrokken actiekaarten mag je houden of apart bewaren en vervangen door nieuwe kaarten. Als je hand is aangevuld leg je de apart bewaarde actiekaarten af.",true),new Kaart("markt",5,false,1,1,1,1,"+1 kaart/ +1 actie / +1 aanschaf / +1 munt",false),new Kaart("militie",4,true,0,0,0,2,"+2 munten/ Iedere andere speler legt naar zijn keuze kaarten af totdat hij er 3 op handen heeft.",true),new Kaart("mijn",5,true,0,0,0,3,"Vernietig een geldkaart uit je hand. Neem een geldkaart die ten hoogste drie munten meer waard is en neem deze op handen.",true)
			,new Kaart("slotgracht",2,true,0,0,2,0,"+2 kaarten / Als een andere speler een aanvalskaart speelt, mag je de Slotgracht tonen. In dat geval heeft de aanval op jou geen effect.",false),new Kaart("geldschieter",4,true,0,0,0,0,"Vernietig een koperkaart uit je hand. Als je dat doet, heb je deze beurt met 3 munten.",true),new Kaart("verbouwing",4,true,0,0,0,2,"Vernietig een kaart uit je hand. Pak een kaart die ten hoogste 2 munten meer waard is dan de vernietigde kaart.",true),new Kaart("smidse",4,false,0,0,3,0,"+3 kaarten",false),new Kaart("spion",4,true,0,1,1,0,"+1 kaart / +1 actie / Alle spelers tonen de bovenste kaart van hun trekstapel. De spion bepaalt of ze blijven liggen of worden afgelegd.",false),new Kaart("dief",4,true,0,0,0,0,"Iedere andere speler toont de bovenste 2 kaarten van zijn trekstapel. Als een speler geldkaarten toont, moet hij er een naar jouw keuze vernietigen. Je mag een of meer van deze vernietigde kaarten pakken en afleggen. De andere spelers leggen andere getoonde kaarten op hun aflegstapel.",true),new Kaart("troonzaal",4,true,0,0,0,0,"Kies een actiekaart uit je hand. Speel deze tweemaal.",true)
			,new Kaart("dorp",3,false,0,2,1,0,"+1 kaart / +2 acties",false),new Kaart("heks",5,true,0,0,2,0,"+2 kaarten / Iedere andere speler pakt 1 vloekkaart.",true),new Kaart("werkplaats",3,true,0,0,0,4,"Pak een kaart die maximaal 4 munten kost.",true),new Kaart("houthakker",3,false,1,0,0,2,"+1 aanschaf / +2 munten",false)));
	private List <ExtraInfo> lijstExtraInfoSpecialeKaarten = new LinkedList<>(Arrays.asList(
			new ExtraInfo("bureaucraat",1,"Trek een overwinningskaart uit uw hand.","ovewinningskaart",false,LijstAndereSpelers,true),
			new ExtraInfo("kapel",4,"Hoeveel kaarten wenst u te vernietigen?:","",false,null,false),
			new ExtraInfo("militie",3,"Verminder uw kaarten in hand tot 3 kaarten!","",true,LijstAndereSpelers,false),
			new ExtraInfo("heks",LijstAndereSpelers,true),
			new ExtraInfo("raadsheer", 1,"Wenst u uw trekstapel naar uw aflegstapel te leggen? 0: Nee / 1: Ja ","",false,null,true),
			new ExtraInfo("feest",null,false),
			new ExtraInfo("mijn", 1,"Wenst u een geldkaart te vernietigen? 0: Nee / 1:Ja :","geldkaart",false,null,true),
			new ExtraInfo("geldschieter",1,"Wenst u een koperkaart te vernietigen? 0: Nee / 1:Ja : ","koper",false,null,true),
			new ExtraInfo("verbouwing",1,"Wenst u een kaart te vernietigen? 0: Nee / 1: Ja: ","",false,null,false),
			new ExtraInfo("dief", 2, "Wat kiest u?: 0: breng de twee kaarten naar de vuilbak /1: Kies een geldgeld, Hoeveel kaarten wenst u te stelen?", "geldkaart", true, LijstAndereSpelers, false),
			new ExtraInfo("troonzaal",null,false),
			new ExtraInfo("spion",1,"Wat kiest u? 0: Kaart mag blijven liggen/ 1: Kaart afleggen","",true,lijstAlleSpelers,false),
			new ExtraInfo("bibliotheek",7,"Wat kiest u? 0: Kaart afleggen / 1: Kaart naar hand brengen","actiekaart",false,null,true)));
	
	

	
	public SpelFuncties() {
		actiekaartenGenereren();
		kaartenVanHetSpel = lijstenSamenvoegenTotNieuweLijst(lijst10Actiekaarten,lijstenSamenvoegenTotNieuweLijst(geldkaarten, overwinningskaarten, false),false);
		stapelsAanmaken(kaartenVanHetSpel);
	}
		
	//SPELERS
	public  void maakSpelersAan(String SpelersNamen[]){
		for (int i = 0; i < SpelersNamen.length; i++) {
			lijstAlleSpelers.add(new Speler(SpelersNamen[i]));
		}
		huidigeSpeler = lijstAlleSpelers.get(0);
	}
	
	
	public void volgendeSpeler(){
		int plaatsInDeArray = 0;
		for (int i = 0; i < lijstAlleSpelers.size(); i++) {
			if (huidigeSpeler.geefNaam().equals(lijstAlleSpelers.get(i).geefNaam()))
			{
				plaatsInDeArray = i+1;
				break;
			}}
		
		if(plaatsInDeArray == lijstAlleSpelers.size())
		{
			plaatsInDeArray = 0;
		}
		huidigeSpeler =  lijstAlleSpelers.get(plaatsInDeArray);
		
	}
	
	public void LijstAndereSpelersMaken(Speler huidigeSpeler){
		
		for (int i = 0; i < lijstAlleSpelers.size(); i++){
			if(lijstAlleSpelers.get(i).geefNaam() != huidigeSpeler.geefNaam()){
				LijstAndereSpelers.add(lijstAlleSpelers.get(i));}}
	}
	
	//STAPELS
	private void stapelsAanmaken(List<Kaart> kaartenVanHetSpel) {
		for (int j = 0; j < kaartenVanHetSpel.size(); j++) {lijstStapel.add(new Stapel(kaartenVanHetSpel.get(j).geefNaam()));}
	}
	
	public void verminderTafelstapel(String kaartnaam){
		
		for (int i = 0; i < lijstStapel.size(); i++) {
			String Kaart = lijstStapel.get(i).geefStapelNaam();
			if (kaartnaam.equals(Kaart))
			{
				lijstStapel.get(i).verminderAantalKaarten();	
			}}
	}
	
	
	//LIJSTEN OF STAPELS AANPASSEN
	
	//kan korter!! mss samenvoegen met onderstaande functie
	public List<Kaart> lijstenSamenvoegenBijBestaandeLijst(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst,boolean shuffle,boolean verwijderBijTeVoegenLijst) {
		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));		}
		if(verwijderBijTeVoegenLijst){bijTeVoegenLijst.clear();}
		if(shuffle){Collections.shuffle(primaireLijst);}
		return primaireLijst;
	}
	
	//ZIE BOVENSTAANDE COMMENT
	private List<Kaart> lijstenSamenvoegenTotNieuweLijst(List<Kaart> primaireLijst, List<Kaart> bijTeVoegenLijst,boolean shuffle){
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
	
	public void trekKaartVanTrekStapel(Speler speler,int aantal) {
		if (speler.geefTrekStapel().size() < aantal) {
			lijstenSamenvoegenBijBestaandeLijst(speler.geefTrekStapel(), speler.geefAflegStapel(),true,true);
		}		
		for (int i = 0; i < aantal; i++) {speler.geefKaartenInHand().add(speler.geefTrekStapel().get(i));}
		for (int i = 0; i < aantal; i++) {speler.geefTrekStapel().remove(0);}
	}

	public void brengAlleKaartenNaarAflegstapel(){
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefSpeelGebied(), false,true);
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefKaartenInHand(),false,true);
		geefLijstAndereSpelers().clear();
	}
	public void brengAlleGeldkaartenUitHandNaarStapel(List<Kaart> lijst){
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {
			if(huidigeSpeler.geefKaartenInHand().get(i).geefKaartType() == "geldkaart"){
				lijst.add(huidigeSpeler.geefKaartenInHand().get(i));
				huidigeSpeler.geefKaartenInHand().remove(i);
				i--;
	}}}
	private void vermeerderAankoopGeldEnActie(int aankoop, int geld, int actie)
	{
		huidigeSpeler.vermeerderAankoop(aankoop);
		huidigeSpeler.vermeerderGeld(geld);
		huidigeSpeler.vermeerderActie(actie);
	}
	
	public void brengEenKaartVanDeEneNaarAndereStapel(List<Kaart>verwijderStapel,Kaart kaart,List<Kaart> toevoegStapel){
		boolean tmp = false;
		for (int i = 0; i < verwijderStapel.size()&& tmp == false; i++ ) {
			if(verwijderStapel.get(i).geefNaam() == kaart.geefNaam()){
				verwijderStapel.remove(i);
				toevoegStapel.add(kaart);
				tmp = true;
				}}}
	
	public void brengGekochteKaartNaarAflegstapel(Kaart kaart) {
		geefHuidigeSpeler().geefAflegStapel().add(kaart);
		verminderTafelstapel(kaart.geefNaam());
	}
	
	public List<Kaart> isTypeKaartInLijst(List<Kaart> lijst,String type){
		List<Kaart> lijstBepaaldeTypeKaarten = new LinkedList<Kaart>();
		for (int i = 0; i < lijst.size(); i++) {
			if (lijst.get(i).geefKaartType() == type){
				lijstBepaaldeTypeKaarten.add(lijst.get(i));}}
		return lijstBepaaldeTypeKaarten;
	}
	
	public boolean isKaartInHand(Speler speler, String kaart){
		boolean tmp = false;
		for (int i = 0; i < speler.geefKaartenInHand().size() && tmp == false; i++) {
			if (speler.geefKaartenInHand().get(i).geefNaam() == kaart){
				tmp = true;}}
		return tmp;
	}
	
	//LIJSTEN GEVEN
	public List<Kaart> geefLijstKaartenDieJeKuntKopen() {
		List<Kaart> lijstMetKaartenDieJeKuntKopen = new LinkedList<Kaart>();
		for (int i = 0; i < kaartenVanHetSpel.size(); i++) {
			if (kaartenVanHetSpel.get(i).geefKost() <= huidigeSpeler.geefGeld()) {lijstMetKaartenDieJeKuntKopen.add(geefLijstKaartenVanHetSpel().get(i));}
		}
		return lijstMetKaartenDieJeKuntKopen;
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
	public List<Speler> geefLijstAlleSpelers() {
		return this.lijstAlleSpelers;
	}
	public Speler geefHuidigeSpeler(){
		return this.huidigeSpeler;
	}
	public List<Speler> geefLijstAndereSpelers() {
		return this.LijstAndereSpelers;
	}
	public ExtraInfo geefExtraInfoMeegeven() {
		return this.extraInfoMeegeven;
	}
	
	//GELDKAARTEN
	public void geldOpSpeelVeld(){
		geefHuidigeSpeler().verminderGeld(geefHuidigeSpeler().geefGeld());
		for (int i = 0; i < huidigeSpeler.geefSpeelGebied().size(); i++) {
			huidigeSpeler.vermeerderGeld(huidigeSpeler.geefSpeelGebied().get(i).geefWaarde());}
			
	}	
	
	public int geldInHand() {
		int geld = 0;
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {geld += huidigeSpeler.geefKaartenInHand().get(i).geefWaarde();}
		return geld;
	}
	//ACTIEKAARTEN
	public List<Kaart> actiekaartenGenereren() {
	
		Collections.shuffle(actiekaarten);
		for (int i = 0; i < 10; i++) {this.lijst10Actiekaarten.add(actiekaarten.get(i));}
		return this.lijst10Actiekaarten;
	}
	
	public void koopKaart(Kaart gekozenKaart) {
		int kost = gekozenKaart.geefKost();			
		huidigeSpeler.verminderGeld(kost);
		huidigeSpeler.verminderAankoop(1);
		brengGekochteKaartNaarAflegstapel(gekozenKaart);
	}
	
	public ExtraInfo actieUitvoeren(Kaart kaart) {
		brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), kaart,huidigeSpeler.geefSpeelGebied());
		
		gewoneActiekaartenUitvoeren(kaart);
		if(kaart.specialeKaart()){actieFase1Uitvoeren(kaart);}	
		return extraInfoMeegeven;
	}
	
	public void gewoneActiekaartenUitvoeren(Kaart kaart){
		for(int i=0;i<lijst10Actiekaarten.size();i++){
			Kaart actiekaart = lijst10Actiekaarten.get(i);
			if(actiekaart.geefNaam().equals(kaart.geefNaam())){
				vermeerderAankoopGeldEnActie(actiekaart.geefExtraAankoop(), actiekaart.geefExtraMunten(), actiekaart.geefExtraActie());
				trekKaartVanTrekStapel(huidigeSpeler,actiekaart.geefExtraKaart());
	}}}
	
	public void infoMeegeven(Kaart kaart){
		for (int i = 0; i < lijstExtraInfoSpecialeKaarten.size(); i++) {
				if(lijstExtraInfoSpecialeKaarten.get(i).kaartNaam()==kaart.geefNaam()){
					extraInfoMeegeven = lijstExtraInfoSpecialeKaarten.get(i);
				}}
	}
	
	public ExtraInfo actieFase1Uitvoeren(Kaart kaart) {
		LijstAndereSpelersMaken(huidigeSpeler);
		if(kaart.geefInfoMeegeven()){infoMeegeven(kaart);}
		else{			
		switch (kaart.geefNaam()) {
		case "avonturier":
			avonturier();
			break;
		case "raadsheer":
			raadsheer();
			break;
		case "raadszaal":
			raadszaal();
			break;	
		case "bureaucraat":
			brengGekochteKaartNaarAflegstapel(geldkaarten.get(1));
			infoMeegeven(kaart);
			break;
		case "kelder":
			extraInfoMeegeven = new ExtraInfo("kelder",huidigeSpeler.geefKaartenInHand().size(),"Hoeveel kaarten wenst u af te leggen?:","",false,null,false);
			break;
		case "feest":
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefSpeelGebied(),kaart,huidigeSpeler.geefVuilbakStapel());
			infoMeegeven(kaart);
			break;
		default:
			break;
		}}
		return geefExtraInfoMeegeven();
	}
	
	public void actieFase2Uitvoeren(ExtraInfo kaartMetExtraInfo) {
		
		switch (kaartMetExtraInfo.kaartNaam()) {
		case "bureaucraat":
			kaartenWegLeggen(kaartMetExtraInfo);
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
			kaartenWegLeggen(kaartMetExtraInfo);
			break;
		case "mijn":
			mijn(kaartMetExtraInfo);
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
			troonzaal(kaartMetExtraInfo);
			break;
		case "heks":
			heks(kaartMetExtraInfo);
			break;
		default:
			break;
		}
		huidigeSpeler.verminderActie(1);
	}
	
	// ALLE APARTE ACTIEKAARTEN
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
		}}
	
	public void kaartenWegLeggen(ExtraInfo kaartMetExtraInfo){
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			brengEenKaartVanDeEneNaarAndereStapel(speler.geefKaartenInHand(), speler.geefLijstGekozenKaarten().get(i), speler.geefAflegStapel());
		}}
	/*
	public void bureaucraat(ExtraInfo kaartMetExtraInfo) {
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			brengEenKaartVanDeEneNaarAndereStapel(speler.geefKaartenInHand(), huidigeSpeler.geefLijstGekozenKaarten().get(i), speler.geefAflegStapel());
		}}
	*/
	public void kelder(ExtraInfo kaartMetExtraInfo) {
		
		for (int i = 0; i < huidigeSpeler.geefLijstGekozenKaarten().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), huidigeSpeler.geefLijstGekozenKaarten().get(i), huidigeSpeler.geefAflegStapel());
		}
		trekKaartVanTrekStapel(huidigeSpeler,huidigeSpeler.geefLijstGekozenKaarten().size());
	}
	
	public void raadsheer(){
		lijstenSamenvoegenBijBestaandeLijst(huidigeSpeler.geefAflegStapel(), huidigeSpeler.geefTrekStapel(),true,true);
	}
	
	public void kapel(ExtraInfo kaartMetExtraInfo) {
		for (int i = 0; i < huidigeSpeler.geefLijstGekozenKaarten().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), huidigeSpeler.geefLijstGekozenKaarten().get(i), huidigeSpeler.geefVuilbakStapel());
		}
	}
	public void raadszaal (){
		for (int i = 0; i < geefLijstAndereSpelers().size(); i++){
			trekKaartVanTrekStapel(geefLijstAndereSpelers().get(i),1);}
		}
	
	public void feest(ExtraInfo kaartMetExtraInfo){
		koopKaart(huidigeSpeler.geefLijstGekozenKaarten().get(0));
	}
	public void troonzaal(ExtraInfo kaartMetExtraInfo){
		if(!huidigeSpeler.geefLijstGekozenKaarten().isEmpty()){
			actieUitvoeren(huidigeSpeler.geefLijstGekozenKaarten().get(0));		
			}
	}
	public void bibliotheek(ExtraInfo kaartMetExtraInfo){
		// Trek kaarten tot er 7 kaarten in hand zijn
		
		//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
			}
	/*
	public void militie(ExtraInfo kaartMetExtraInfo) {
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			brengEenKaartVanDeEneNaarAndereStapel(speler.geefKaartenInHand(), huidigeSpeler.geefLijstGekozenKaarten().get(i),speler.geefAflegStapel());
		}}
	
	*/
	public void mijn(ExtraInfo kaartMetExtraInfo) {
		if(huidigeSpeler.geefLijstGekozenKaarten().size()>1){
			verminderTafelstapel(huidigeSpeler.geefLijstGekozenKaarten().get(1).geefNaam());
			geefHuidigeSpeler().geefKaartenInHand().add(huidigeSpeler.geefLijstGekozenKaarten().get(1));
		}}
	
	
	public void geldschieter(ExtraInfo kaartMetExtraInfo) {
		if(huidigeSpeler.geefLijstGekozenKaarten().isEmpty()){
			huidigeSpeler.vermeerderGeld(3);
		}}
	
	private void verbouwing(ExtraInfo kaartMetExtraInfo) {
		if(!huidigeSpeler.geefLijstGekozenKaarten().isEmpty()){
		brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefKaartenInHand(), huidigeSpeler.geefLijstGekozenKaarten().get(0), huidigeSpeler.geefVuilbakStapel());
		huidigeSpeler.vermeerderGeld(huidigeSpeler.geefLijstGekozenKaarten().get(0).geefKost());}
	}

		
	private void heks(ExtraInfo kaartMetExtraInfo){
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			System.out.println("kom ik hier eigenlijk ooit wel in ??????");
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			if(speler.geefGebruikSlotgracht()){
				System.out.println("deze kaart komt er bij "+overwinningskaarten.get(3));
				speler.geefAflegStapel().add(overwinningskaarten.get(3));
			}}}
	
	private void spion(ExtraInfo kaartMetExtraInfo){
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			if(speler.geefKeuzeSpeler()){
				brengEenKaartVanDeEneNaarAndereStapel(speler.geefAflegStapel(), speler.geefLijstGekozenKaarten().get(i), speler.geefAflegStapel());
			}}}
		
	private void dief(ExtraInfo kaartMetExtraInfo) {
		for (int i = 0; i < huidigeSpeler.geefLijstTeStelenKaarten().size(); i++) {
			brengEenKaartVanDeEneNaarAndereStapel(huidigeSpeler.geefLijstTeStelenKaarten(), huidigeSpeler.geefLijstTeStelenKaarten().get(i), huidigeSpeler.geefAflegStapel());
		}
		for (int i = 0; i < kaartMetExtraInfo.geefSpelers().size(); i++) {
			Speler speler = kaartMetExtraInfo.geefSpelers().get(i);
			brengEenKaartVanDeEneNaarAndereStapel(speler.geefLijstTeStelenKaarten(), speler.geefLijstTeStelenKaarten().get(i), speler.geefAflegStapel());
		}}
		
	//EINDE
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
				}}}
		return tmp;
	}
	
	public void berekenScoreAlleSpelers() {
		for (int i = 0; i < lijstAlleSpelers.size(); i++) {
			Speler speler = lijstAlleSpelers.get(i);
			brengAlleKaartenNaarAflegstapel();
			scorePerSpeler(speler);
			}}
	
	private void scorePerSpeler(Speler speler){
		int aantal = 0;
		for (int j = 0; j < speler.geefAflegStapel().size(); j++) {
		Kaart kaart = speler.geefAflegStapel().get(j);
			if(kaart.geefKaartType() == "overwinningskaart"){
				speler.vermeerderScore(kaart.geefWaarde());}
			if(kaart.geefNaam()=="tuinen"){aantal ++;}
		//NOG BEKIJKEN!!! mss met een functie!
		int extraPunten = ((speler.geefScore()-(speler.geefScore()%10))/10)*aantal;
		speler.vermeerderScore(extraPunten);	
	}
	}
}
