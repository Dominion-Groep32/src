package engine;

import java.util.*;

import com.sun.prism.shader.Texture_LinearGradient_PAD_AlphaTest_Loader;


public class SpelFuncties {
	
	

	private List<Kaart> geldEnOverwinningskaarten = new LinkedList<>(Arrays.asList(new Kaart("koper","geldkaart",0,1),new Kaart("zilver","geldkaart",3,2),new Kaart("goud","geldkaart",6,3),
			new Kaart("landgoed","overwinningskaart",2,1),new Kaart("hertogdom","overwinningskaart",5,3),new Kaart("provincie","overwinningskaart",8,6)));
	private List<Kaart> actiekaarten = new LinkedList<>(Arrays.asList(new Kaart("avonturier",6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."),
			new Kaart("bureaucraat",4,true,0,0,0,0,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)"), new Kaart("kelder",2,true,0,1,0,0,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart."), new Kaart("raadsheer",3,true,0,0,0,2,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen"),new Kaart("kapel",2,true,0,0,0,0,"Vernietig 4 of minder kaarten uit je hand"),new Kaart("raadszaal",5,true,1,0,4,0,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart"),new Kaart("feest",4,true,0,0,0,5,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder."),
			new Kaart("festival",5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten"),new Kaart("tuinen",4,true,0,0,0,0,"Elke 10 kaarten in je stapel zijn aan het einde van  het spel 1 landgoed waard (naar beneden afronden)."),new Kaart("laboratorium",5,false,0,1,2,0,"+2 kaarten / +1 actie"),new Kaart("bibliotheek",5,true,0,0,0,0,"Vul je hand aan tot 7 kaarten. Getrokken actiekaarten mag je houden of apart bewaren en vervangen door nieuwe kaarten. Als je hand is aangevuld leg je de apart bewaarde actiekaarten af."),new Kaart("markt",5,false,1,1,1,1,"+1 kaart/ +1 actie / +1 aanschaf / +1 munt"),new Kaart("militie",4,true,0,0,0,2,"+2 munten/ Iedere andere speler legt naar zijn keuze kaarten af totdat hij er 3 op handen heeft."),new Kaart("mijn",5,true,0,0,0,3,"Vernietig een geldkaart uit je hand. Neem een geldkaart die ten hoogste drie munten meer wwaard is en neem deze op handen.")
			,new Kaart("slotgracht",2,true,0,0,2,0,"+2 kaarten / Als een andere speler een aanvalskaart speelt, mag je de Slotgracht tonen. In dat geval heeft de aanval op jou geen effect."),new Kaart("geldschieter",4,true,0,0,0,3,"Vernietig een koperkaart uit je hand. Als je dat doet, heb je deze beurt met 3 munten."),new Kaart("verbouwing",4,true,0,0,0,2,"Vernietig een kaart uit je hand. Pak een kaart die ten hoogste 2 munten meer waard is dan de vernietigde kaart."),new Kaart("smidse",4,false,0,0,3,0,"+3 kaarten"),new Kaart("spion",4,true,0,1,1,0,"+1 kaart / +1 actie / Alle spelers tonen de bovenste kaart van hun trekstapel. De spion bepaalt of ze blijven liggen of worden afgelegd."),new Kaart("dief",4,true,0,0,0,0,"Iedere andere speler toont de bovenste 2 kaarten van zijn trekstapel. Als een speler geldkaarten toont, moet hij er één naar jouw keuze vernietigen. Je mag een of meer van deze vernietigde kaarten pakken en afleggen. De andere spelers leggen andere getoonde kaarten op hun aflegstapel."),new Kaart("troonzaal",4,true,0,0,0,0,"Kies een actiekaart uit je hand. Speel deze tweemaal.")
			,new Kaart("dorp",3,false,0,2,1,0,"+1 kaart / +2 acties"),new Kaart("heks",5,true,0,0,2,0,"+2 kaarten / Iedere andere speler pakt 1 vloekkaart."),new Kaart("werkplaats",3,true,0,0,0,4,"Pak een kaart die maximaal 4 munten kost."),new Kaart("houthakker",3,false,1,0,0,2,"+1 aanschaf / +2 munten")));
	private Speler[] spelers;

	private List<Kaart> kaartenDieTekoopZijn = new LinkedList<>();
	private List<Kaart> testLijst = new LinkedList<>();
	private Object[][] Stapels = new Object[16][2];
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;
	
	


	
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
			if (geefHuidigeSpeler().geefNaam().equals(spelers[i].geefNaam()))
			{
				plaatsInDeArray = i+1;
			}
		}
		if(plaatsInDeArray == spelers.length)
		{
			plaatsInDeArray = 0;
		}
		huidigeSpeler = spelers[plaatsInDeArray];
		
		
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
		int Legestapels = 0;
		Boolean tmp = true;
		
		for (int i = 0; i < Stapels.length; i++) 
		{
			if((int)Stapels[i][1] <= 0)
			{
				Legestapels = Legestapels+1;
				String lijstNaam = Stapels[i][0].toString();
				
				if (lijstNaam.equals("provincie") || Legestapels >=3)
				{
					tmp = false;
				}
			}
		}
		return tmp;
		
	}
	
	
	public Speler andereSpeler(){
		Speler andereSpeler;
		if (huidigeSpeler == spelers[1])
		{andereSpeler = spelers[0];}
		else {andereSpeler = spelers[1];}
		return andereSpeler;
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

	public List<Kaart> kaartenInitialiseren() {

		Collections.shuffle(actiekaarten);
		for (int i = 0; i < 10; i++) 
		{
			kaartenDieTekoopZijn.add(actiekaarten.get(i));
		}
		testLijst = lijstenSamenvoegenZonderShuffle(kaartenDieTekoopZijn, geldEnOverwinningskaarten);
		for (int j = 0; j < testLijst.size(); j++) {
			Stapels[j][0] = testLijst.get(j).naam();
			Stapels[j][1] = 10;
		}
		
		return kaartenDieTekoopZijn;
	}
	
	public List<Kaart> trekKaart(List<Kaart> lijst, int aantal) {
		if (lijst.size() < aantal) {
			lijst = lijstenSamenvoegenShuffle(huidigeSpeler.trekStapel(), huidigeSpeler.aflegStapel());
		}
		for (int i = 0; i < aantal; i++) {
			huidigeSpeler.kaartenInHand().add(lijst.get(i));
		}
		for (int i = 0; i < aantal; i++) {
			lijst.remove(0);
		}
		
		return huidigeSpeler.kaartenInHand();
	}


	public int geldInHand(List<Kaart> lijst) {
		int geld = 0;
		for (int i = 0; i < lijst.size(); i++) {
			geld += lijst.get(i).waarde();
		}
		return geld;
	}
	


	public List<Kaart> kaartenDieJeKuntKopen(List<Kaart> lijst, int coins) {
		List<Kaart> lijstMetKaartenDieJeKuntKopen = new LinkedList<Kaart>();
		for (int i = 0; i < lijst.size(); i++) {
			if (lijst.get(i).kost() <= coins) {
				lijstMetKaartenDieJeKuntKopen.add(lijst.get(i));
			}
		}
		return lijstMetKaartenDieJeKuntKopen;
	}

		
	public List<Kaart> neemActiekaartenUitHand(List<Kaart> kaartenInHand){
		List<Kaart> actiekaartenUitHand = new LinkedList<Kaart>();
		for (int i = 0; i < kaartenInHand.size(); i++) {
			if (kaartenInHand.get(i).kaartType() == "actiekaart") {
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
	
	public void brengKaartenInHandNaarAflegstapel(List<Kaart> kaartenInHand, List<Kaart> aflegstapel){
		lijstenSamenvoegenZonderShuffle(aflegstapel, kaartenInHand);
		maakKaartInHandLeeg(huidigeSpeler.kaartenInHand());
	}
	

	public void actieUitvoeren(Kaart kaart) {
		huidigeSpeler.kaartenInHand().remove(kaart);
		for(int i=0;actiekaarten.size()<0;i++){
			if(actiekaarten.get(i).naam().equals(kaart.naam())){
				Kaart actiekaart = actiekaarten.get(i);
				vermeerderAankoopGeldEnActie(actiekaart.extraAankoop(), actiekaart.extraMunten(), actiekaart.extraActie());
				trekKaart(geefHuidigeSpeler().trekStapel(), actiekaart.extraKaart());
				if(actiekaarten.get(i).specialeKaart()){
				}
			}
			
		}
	}
	public void SpecialeActiesUitvoeren(Kaart kaart) {
		switch (kaart.naam()) {
		case "avonturier":
			//OK
			avonturier();
			break;
		case "bureaucraat":
			break;
		case "kelder":
			kelder();
			break;
		case "raadsheer":
			raadsheer();
			break;
		case "kapel":
			kapel();
			break;
		case "raadszaal":
			raadszaal();
			break;
		case "feest":
			feest(kaart);
			break;
		case "tuinen":
			tuinen();
			break;
		case "bibliotheek":
			bibliotheek();
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

			break;
		case "verbouwing":
			//test
			//test
			//breng een kaart van je hand naar de vuilbank
			//kost van deze kaart +2 om andere kaart te kunnen kopen
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
		
		case "heks":
			heks();
			break;
		case "werkplaats":
			//koop een kaart die max 4 kost
			break;
		case "gethub":
			//dskqf
		default:
			break;
		}
		
		geefHuidigeSpeler().verminderActie(1);
		
		
	}
	
	public void avonturier (){
		int getal = 0 ;
		int i = 0;
		while (getal <=2 ) {
			Kaart huidigeKaart = geefHuidigeSpeler().trekStapel().get(i);
			if(huidigeKaart.kaartType() == "Geldkaart")
			{
				geefHuidigeSpeler().kaartenInHand().add(huidigeKaart);
				geefHuidigeSpeler().trekStapel().remove(huidigeKaart);
				getal ++;
			}
			i++;
		}
		
	}
	public void bureaucraat() {
		geefHuidigeSpeler().trekStapel().add(new Kaart("zilver","geldkaart",3,2));
		verminderStapel("zilver");
		//andere speler legt een overwinningskaart uit zijn hand op dzijn trekstapel
		//while(geefHuidigeSpeler().equals(volgendeSpeler())){}
	}
	public void kelder() {
		//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
	}
	public void raadsheer(){
		lijstenSamenvoegenShuffle(geefHuidigeSpeler().aflegStapel(), geefHuidigeSpeler().trekStapel());
	}
	public void kapel() {
		//je kan max 4 kaarten van je hand naar de vuilbak brengen
	}
	public void raadszaal (){
	
		//volgendeSpeler().trekKaart(geefHuidigeSpeler().trekStapel(), 1);
	}
	public void feest(Kaart kaart){
		verwijderKaart(kaart);
		//koopActie kunnen uitvoeren
	}
	public void tuinen() {
		// elke 10 kaarten op het einde van het spel zijn 1 overwinningspunt waard.
		//int meesteOverwinningspunten = 0;
		//functie alle lijsten aanmaken
	}
	public void bibliotheek(){
		// Trek kaarten tot er 7 kaarten in hand zijn
		//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
	}
	
	public void militie() {
		
		//elke ander speler moet hand verminderen tot 3 kaarten
		
	}

	public void slotgracht(){
	
		// bij gebruik van een aanvalskaart kan deze kaart gebruikt worden om zich te verdedigen.
	}
	
	public void spion(){
		
		//elke speler (ook huidigespeler) toont zijn bovenste kaart van zijn aftrekstapel
		//speler kiest of hij deze teruglegt of naar zijn aflegstapel verplaatst
	}
	

	
	public void heks(){
		
		andereSpeler().trekStapel().add(new Kaart("vloek","overwinningskaart",0,-1));}


	
	public void vermeerderAankoopGeldEnActie(int aankoop, int geld, int actie)
	{
		geefHuidigeSpeler().vermeerderAankoop(aankoop);
		geefHuidigeSpeler().vermeerderGeld(geld);
		geefHuidigeSpeler().vermeerderActie(actie);
	}
	public void verwijderKaart(Kaart kaart){
		
		geefHuidigeSpeler().kaartenInHand().remove(kaart);
		geefHuidigeSpeler().vuilbakStapel().add(kaart);
	}

	
	






	

}
