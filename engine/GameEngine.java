package engine;

import java.util.*;

import console.ConsoleSpel;


public class GameEngine {
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> andereKaarten = new LinkedList<Kaart>(
			Arrays.asList(new GeldKaart("koper"), new GeldKaart("zilver"), new GeldKaart("goud"),
					new OverwinningKaart("estate"), new OverwinningKaart("dutchy"), new OverwinningKaart("province")));
	
	private LinkedList<Kaart> actieKaarten = new LinkedList<Kaart>(Arrays.asList(new ActieKaart("avonturier"),
			new ActieKaart("bureaucraat"), new ActieKaart("kelder"), new ActieKaart("raadsheer"),
			new ActieKaart("kapel"), new ActieKaart("raadszaal"), new ActieKaart("feest"),
			new ActieKaart("festival"), new ActieKaart("tuinen"), new ActieKaart("laboratorium"), new ActieKaart("bibliotheek"),
			new ActieKaart("markt"), new ActieKaart("militie"), new ActieKaart("mijn"), new ActieKaart("slotgracht"),
			new ActieKaart("geldschieter"), new ActieKaart("verbouwing"), new ActieKaart("smidse"), new ActieKaart("spion"),
			new ActieKaart("dief"), new ActieKaart("troonzaal"), new ActieKaart("dorp"), new ActieKaart("heks"), new ActieKaart("houthakker")
			, new ActieKaart("werkplaats")));
	
	private LinkedList<Kaart> kaartenDieTekoopZijn = new LinkedList<Kaart>();
	Scanner scanner = new Scanner(System.in);
	
	
	

	/*

	public void beurt(LinkedList<Kaart> trekstapel, LinkedList<Kaart> 
en) {
		int koopMogelijkheden = 1;
		int acties = 1;
		
		LinkedList<Kaart> kaatenInHand = trekKaart(trekstapel, 5);
		toonLijst(kaatenInHand);
		layout();
		
		geefKeuze(kaatenInHand, koopKaarten,koopMogelijkheden);
		maakKaartInHandLeeg();
		
		layout();
	}
*/
	
	
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
		int coins = 0;
		for (int i = 0; i < lijst.size(); i++) {
			coins += lijst.get(i).waarde();
		}
		return coins;
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
			if (kaartenInHand.get(i).kaartType().equals("ActieKaart")) {
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

	public void maakKaartInHandLeeg(LinkedList<Kaart> lijst) {
		lijst.clear();
		
	}
	public boolean spelNogNietBeëindigd(){
		
		return true;
	}






	

}
