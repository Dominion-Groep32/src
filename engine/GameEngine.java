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
	private LinkedList<Kaart> actieKaarten = new LinkedList<Kaart>(Arrays.asList(new ActieKaart("ambassador"),
			new ActieKaart("celler"), new ActieKaart("chancellor"), new ActieKaart("chapel"),
			new ActieKaart("councilroom"), new ActieKaart("feast"), new ActieKaart("festival"),
			new ActieKaart("laboratory"), new ActieKaart("libary"), new ActieKaart("market"), new ActieKaart("militia"),
			new ActieKaart("moat"), new ActieKaart("moneylender"), new ActieKaart("smithy"), new ActieKaart("spy"),
			new ActieKaart("thief"), new ActieKaart("village"), new ActieKaart("witch"), new ActieKaart("woodcutter"),
			new ActieKaart("workshop")));
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

	public LinkedList<Kaart> koopKaart(LinkedList<Kaart> lijst,LinkedList<Kaart> aflegStapel) {
		
		System.out.print("vul het nummer in van de kaart die je wilt kopen : ");
		int keuze = (scanner.nextInt() - 1);
		
		while (keuze < 0 || keuze > lijst.size()) {
			System.out.println("Sorry geef een geldig getal in ");
			keuze = (scanner.nextInt() - 1);
		}
		aflegStapel.add(lijst.get(keuze));
		
		return aflegStapel;
	
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






	

}
