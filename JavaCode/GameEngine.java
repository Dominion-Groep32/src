package JavaCode;

import java.util.*;


public class GameEngine {
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private LinkedList<String> actiekaarten = new LinkedList<String>();
	private LinkedList<Kaart> testlijst = new LinkedList<Kaart>();
	Scanner scanner = new Scanner(System.in);

	private String actieKaarten[] = { "ambassador", "celler", "chancellor", "chapel", "councilroom", "feast",
			"festival", "laboratory", "libary", "market", "militia", "moat", "moneylender", "smithy", "spy", "thief",
			"village", "witch", "woodcutter", "workshop" };

	public void dominionTitel() {
		System.out.println("----------------------------------WELKOM BIJ DOMINION------------------------------------");
	}

	public LinkedList<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {
			trekStapel.add(new GeldKaart("koper"));
		}
		for (int j = 0; j < 3; j++) {
			trekStapel.add(new OverwinningKaart("estate"));
		}
		Collections.shuffle(trekStapel);
		return trekStapel;
	}

	public LinkedList<Kaart> lijstenSamenvoegen(LinkedList<Kaart> primaireLijst, LinkedList<Kaart> bijTeVoegenLijst) {

		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));
		}
		bijTeVoegenLijst.clear();
		Collections.shuffle(primaireLijst);
		return primaireLijst;
	}

	public LinkedList<Kaart> trekKaart(LinkedList<Kaart> lijst, int aantal) {

		
		if (lijst.size() < aantal) {
			lijst = lijstenSamenvoegen(trekStapel, aflegStapel);
		}
		for (int i = 0; i < aantal; i++) {
			kaartenInHand.add(lijst.get(i));
			aflegStapel.add(lijst.get(i));
			// TREKSTAPEL NOG KLEINER MAKEN
			

		}
		for (int i = 0; i < aantal; i++) {
			lijst.removeFirst();
		}
		return kaartenInHand;
	}

	public void toonLijst(LinkedList<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			
			
			System.out.print((i + 1) + ": ");
			System.out.println(lijst.get(i).naam());
		}
	}

	// aanpassen
	public void toonActieLijst(LinkedList<String> lijst) {
		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + ": ");
			System.out.println(lijst.get(i));
		}
	}

	public LinkedList<String> actieKaartenGenereren() {

		Collections.shuffle((Arrays.asList(actieKaarten)));
		for (int i = 0; i < actieKaarten.length; i++) {
			actiekaarten.add(actieKaarten[i]);
		}

		return actiekaarten;

	}

	public LinkedList<Kaart> aflegStapel() {
		return this.aflegStapel;
	}

	public LinkedList<Kaart> kaartInHand() {
		return this.kaartenInHand;
	}

	public LinkedList<Kaart> maakKaartInHandLeeg() {
		kaartenInHand.clear();
		return kaartenInHand;
	}

	public void maakHandLeeg(LinkedList<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			lijst.clear();
		}
	}

	public int geldInHand(LinkedList<Kaart> lijst) {
		int coins = 0;
		for (int i = 0; i < lijst.size(); i++) {
			coins += kaartenInHand.get(i).waarde();
		}
		return coins;
	}

	public void keuzeSpeler(int keuze) {

		switch (keuze) {
		case 1:
			System.out.println("hier moet je actiekaarten kunnen uitvoeren");
			break;
		case 2:
			System.out.println("----");
			System.out.println("Je hebt " + geldInHand(kaartenInHand) + " coins om te spenderen");
			// speel je geldkaarten
		case 3:

			break;

		default:
			break;
		}
	}

	public void geefKeuze() {
		System.out.println("1: gebruik actie Kaarten");
		System.out.println("2: gebruik geld kaarten");
		System.out.println("3: beëindig je beurt");
		System.out.print("geef een keuze in : ");
		Scanner scanner = new Scanner(System.in);
		int keuze = scanner.nextInt();

		while (keuze < 0 || keuze > 3) {
			System.out.println("geef een correcte waarde in ");
			System.out.print("geef een keuze in : ");
			keuze = scanner.nextInt();
		}

		keuzeSpeler(keuze);

	}

	// ----------------------------------------PLAYFIELD
	// ----------------------//
	// ------------------------------HIER TEST IK
	// DINGEN------------------------//

	public void toonDeInfo(LinkedList<Kaart> lijst) {
		int coinsUitHand = 0;
		for (int i = 0; i < kaartenInHand.size(); i++) {
			System.out.println("-----");

			System.out.println("de naam van de kaart is " + kaartenInHand.get(i).naam());
			System.out.println("het type van de kaart is : " + kaartenInHand.get(i).kaartType());
			System.out.println("de kaart kost: " + kaartenInHand.get(i).kost() + " coins");
			System.out.println("je krijgt " + kaartenInHand.get(i).waarde() + " coin van deze kaart");
			coinsUitHand += kaartenInHand.get(i).waarde();
		}
		System.out.println("-------");
		System.out.println("je hebt " + coinsUitHand + " coins om te spenderen");
	}

	public LinkedList<Kaart> testfunctie(LinkedList<Kaart> lijst, int coins)
		{
		for (int i = 0; i < lijst.size(); i++) {
			if (lijst.get(i).kost() < coins) {
				if (!testlijst.contains(lijst.get(i))) {
					testlijst.add(lijst.get(i));
				}
			}
		}

		return testlijst;

	}
	
	

}
