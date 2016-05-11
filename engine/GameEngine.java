package engine;

import java.util.*;




public class GameEngine {
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> vuilbakStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> andereKaarten = new LinkedList<Kaart>(
			Arrays.asList(new GeldKaart("koper"), new GeldKaart("zilver"), new GeldKaart("goud"),
					new OverwinningKaart("estate"), new OverwinningKaart("dutchy"), new OverwinningKaart("province")));
	//in lijst steken
	private LinkedList<Kaart> actieKaarten = new LinkedList<Kaart>(Arrays.asList(new ActieKaart("avonturier"),
			new ActieKaart("bureaucraat"), new ActieKaart("kelder"), new ActieKaart("raadsheer"),
			new ActieKaart("kapel"), new ActieKaart("raadszaal"), new ActieKaart("feest"),
			new ActieKaart("festival"), new ActieKaart("tuinen"), new ActieKaart("laboratorium"), new ActieKaart("bibliotheek"),
			new ActieKaart("markt"), new ActieKaart("militie"), new ActieKaart("mijn"), new ActieKaart("slotgracht"),
			new ActieKaart("geldschieter"), new ActieKaart("verbouwing"), new ActieKaart("smidse"), new ActieKaart("spion"),
			new ActieKaart("dief"), new ActieKaart("troonzaal"), new ActieKaart("dorp"), new ActieKaart("heks"), new ActieKaart("houthakker")
			, new ActieKaart("werkplaats")));
	private Speler[] spelersNamen = new Speler[2];
	private LinkedList<Kaart> kaartenDieTekoopZijn = new LinkedList<Kaart>();
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;
	
	
	
	public  void maakSpelersAan(String SpelersNamen[]){
		
		
		for (int i = 0; i < SpelersNamen.length; i++) {
			spelersNamen[i] = new Speler(SpelersNamen[i]);
		}
	}
	
	public void veranderSpeler(){

	
		
		if (huidigeSpeler == spelersNamen[1])
		{huidigeSpeler = spelersNamen[0];}
		
		else {huidigeSpeler = spelersNamen[1];}
		
	
	}
	
	public Speler geefHuidigeSpeler(){
		
		return this.huidigeSpeler;
	}
	
	
	
	public LinkedList<Kaart> lijstenSamenvoegenShuffle(LinkedList<Kaart> primaireLijst, LinkedList<Kaart> bijTeVoegenLijst) {

		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));
		}
		bijTeVoegenLijst.clear();
		Collections.shuffle(primaireLijst);
		return primaireLijst;

	}

	public LinkedList<Kaart> lijstenSamenvoegenZonderShuffle(LinkedList<Kaart> primaireLijst, LinkedList<Kaart> bijTeVoegenLijst) {

		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));
		}
		bijTeVoegenLijst.clear();
		return primaireLijst;

	}	

	public LinkedList<Kaart> actieKaartenGenereren() {

		Collections.shuffle(actieKaarten);
		for (int i = 0; i < 10; i++) {
			kaartenDieTekoopZijn.add(actieKaarten.get(i));
		}
		return kaartenDieTekoopZijn;
	}

	public int geldInHand(LinkedList<Kaart> lijst) {
		int geld = 0;
		for (int i = 0; i < lijst.size(); i++) {
			geld += lijst.get(i).waarde();
		}
		return geld;
	}
	


	public LinkedList<Kaart> kaartenDieJeKuntKopen(LinkedList<Kaart> lijst, int coins) {
		LinkedList<Kaart> tmp = new LinkedList<Kaart>();
		for (int i = 0; i < lijst.size(); i++) {
			if (lijst.get(i).kost() <= coins) {
				tmp.add(lijst.get(i));
			}
		}
		return tmp;
	}

		
	public LinkedList<Kaart> controleerActieKaarten(LinkedList<Kaart> kaartenInHand){
		LinkedList<Kaart> tmp = new LinkedList<Kaart>();
		for (int i = 0; i < kaartenInHand.size(); i++) {
			if (kaartenInHand.get(i) instanceof ActieKaart) {
				tmp.add(kaartenInHand.get(i));
			}
		}
		return tmp;
	}
	
	public LinkedList<Kaart> trekstapel(){
		return this.trekStapel;
	}

	public LinkedList<Kaart> getAndereKaarten() {
		return this.andereKaarten;
	}

	public LinkedList<Kaart> aflegStapel() {
		return this.aflegStapel;
	}

	public LinkedList<Kaart> kaartInHand() {
		return this.kaartenInHand;
	}
	
	public LinkedList<Kaart> vuilbakStapel(){
		return this.vuilbakStapel;
	}

	public void maakKaartInHandLeeg(LinkedList<Kaart> lijst) {
		lijst.clear();
		
	}
	public boolean spelNogNietBeëindigd(){
		//stapels nog voor maken
		return true;
	}
	
	public void actieUitvoeren(Kaart kaart) {
		//huidigeSpeler.zetActie(huidigeSpeler.geefActie());
		
		huidigeSpeler.kaartenInHand().remove(kaart);
		switch (kaart.naam()) {
		case "avonturier":
			//lees kaart
			break;
		case "bureaucraat":
			//zilver krijgen en op je top van je deck leggen
			break;
		case "kelder":
			//leg een aantal kaarten weg, per elke weggelegde kaart krijg je een bij van je afneemstapel
			
			geefHuidigeSpeler().vermeerderActie(1);
			break;
		case "raadsheer":
			geefHuidigeSpeler().vermeerderGeld(2);
			//trekstapel naar aflegstapel
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 4);
			break;
		case "kapel":
			//je kan max 4 kaarten van je hand naar de vuilbak brengen
			break;
		case "raadszaal":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 4);
			geefHuidigeSpeler().vermeerderAankoop(1);
			//ander spelers krijgen elk een extra kaart in hun hand
			break;
		case "feest":
			//actiekaart verdwijnt in vuilbak
			geefHuidigeSpeler().vermeerderGeld(5);
			break;
		case "festival":
			geefHuidigeSpeler().vermeerderActie(2);
			geefHuidigeSpeler().vermeerderAankoop(1);
			geefHuidigeSpeler().vermeerderGeld(2);
			break;
		case "tuinen":
			// elke 10 kaarten op het einde van het spel zijn 1 overwinningspunt waard.
			break;
		case "laboratorium":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
			geefHuidigeSpeler().vermeerderActie(1);
			break;
		case "bibliotheek":
			// Trek kaarten tot er 7 kaarten in hand zijn
			
			//Wanneer er actiekaarten getrokken worden, kan je kiezen of je deze wilt of niet
			break;
		case "markt":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
			geefHuidigeSpeler().vermeerderActie(1);
			geefHuidigeSpeler().vermeerderAankoop(1);
			geefHuidigeSpeler().vermeerderGeld(1);
			break;
		case "militie":
			geefHuidigeSpeler().vermeerderGeld(2);
			//elke ander speler moet hand verminderen tot 3 kaarten
			break;
		case "mijn":
			// Geldkaart van je hand naar vuilbak brengen
			// andere geldkaart kopen die met waarde +3 van weggebrachte kaart
			break;
		case "slotgracht":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
			// bij gebruik van een aanvalskaart kan deze kaart gebruikt worden om zich te verdedigen.
			break;
		case "geldschieter":
			// Indien je een kooper van je hand naar de vuilbak brengt
			geefHuidigeSpeler().vermeerderGeld(3);
			break;
		case "verbouwing":
			//breng een kaart van je hand naar de vuilbank
			//kost van deze kaart +2 om andere kaart te kunnen kopen
			break;
		case "smidse":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 3);
			break;
		case "spion":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
			geefHuidigeSpeler().vermeerderActie(1);
			//elke speler (ook huidigespeler) toont zijn bovenste kaart van zijn aftrekstapel
			//speler kiest of hij deze teruglegt of naar zijn aflegstapel verplaatst
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
			
			geefHuidigeSpeler().vermeerderActie(2);
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 1);
			break;
		case "heks":
			huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 2);
			// andere spelers krijgen 1 vloekkaart
			break;
		case "houthakker":
			geefHuidigeSpeler().vermeerderAankoop(1);
			geefHuidigeSpeler().vermeerderGeld(2);
			break;
		case "werkplaats":
			//koop een kaart die max 4 kost
			break;
		default:
			break;
		}

		geefHuidigeSpeler().verminderActie(1);
		
		
	}


	






	

}
