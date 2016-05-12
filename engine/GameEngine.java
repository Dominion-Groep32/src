package engine;

import java.util.*;




public class GameEngine {
	
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> vuilbakStapel = new LinkedList<Kaart>();
	private String[] namenVanDeActieKaarten = {"avonturier","bureaucraat","kelder","raadsheer","kapel","raadszaal","feest","festival","tuinen","laboratorium"
			,"bibliotheek","markt","militie","mijn","slotgracht","geldschieter","verbouwing","smidse","spion","dief","troonzaal","dorp","heks","werkplaats","houthakker",}; 
	private String[] namenVanDeAndereKaarten = {"koper","zilver","goud","estate","dutchy","province"};
	
	private LinkedList<Kaart> andereKaarten = new LinkedList<Kaart>();
	
	private LinkedList<Kaart> actieKaarten = new LinkedList<Kaart>();
	
	private Speler[] spelersNamen = new Speler[2];
	private LinkedList<Kaart> kaartenDieTekoopZijn = new LinkedList<Kaart>();
	Scanner scanner = new Scanner(System.in);
	private Speler huidigeSpeler;
	
		public GameEngine() {
			for (int i = 0; i < namenVanDeActieKaarten.length; i++) {actieKaarten.add(new ActieKaart(namenVanDeActieKaarten[i]));}
			for (int i = 0; i < 3; i++) {andereKaarten.add(new GeldKaart(namenVanDeAndereKaarten[i]));}
			for (int i = 3; i < 6; i++) {andereKaarten.add(new OverwinningKaart(namenVanDeAndereKaarten[i]));}
			
		}
	
	
	
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
	
	public Speler andereSpeler(){
		Speler tmp;
		if (huidigeSpeler == spelersNamen[1])
		{tmp = spelersNamen[0];}
		
		else {tmp = spelersNamen[1];}
		
		return tmp;
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
		
		
		huidigeSpeler.kaartenInHand().remove(kaart);
		switch (kaart.naam()) {
		case "avonturier":
			avonturier();
			
			break;
		case "bureaucraat":
			
			geefHuidigeSpeler().trekStapel().addFirst(new GeldKaart("zilver"));
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

		geefHuidigeSpeler().verminderActie(1);
		
		
	}
	public void avonturier (){
		int getal = 0 ;
		int i = 0;
		while (getal <=2 ) {
			
			Kaart huidigeKaart = geefHuidigeSpeler().trekStapel().get(i);
			if(huidigeKaart instanceof GeldKaart){
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
		andereSpeler().trekKaart(trekStapel, 1);
		
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
		
		andereSpeler().trekStapel().add(new OverwinningKaart("vloek"));
	}

	public void houthakker(){
		geefHuidigeSpeler().vermeerderAankoop(1);
		geefHuidigeSpeler().vermeerderGeld(2);
	}

	
	






	

}
