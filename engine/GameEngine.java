package engine;

import java.util.*;


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



	public void beurt(LinkedList<Kaart> trekstapel, LinkedList<Kaart> koopKaarten) {
		int koopMogelijkheden = 1;
		int acties = 1;
		
		LinkedList<Kaart> kaatenInHand = trekKaart(trekstapel, 5);
		toonLijst(kaatenInHand);
		layout();
		
		geefKeuze(kaatenInHand, koopKaarten,koopMogelijkheden);
		maakKaartInHandLeeg();
		
		layout();
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
		}
		for (int i = 0; i < aantal; i++) {
			lijst.removeFirst();
		}
		return kaartenInHand;
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
			coins += kaartenInHand.get(i).waarde();
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

	public void koopKaart(LinkedList<Kaart> lijst) {
		
		System.out.print("vul het nummer in van de kaart die je wilt kopen : ");
		int keuze = (scanner.nextInt() - 1);
		
		while (keuze < 0 || keuze > lijst.size()) {
			System.out.println("Sorry geef een geldig getal in ");
			keuze = (scanner.nextInt() - 1);
		}
		bevestigKeuze(keuze,lijst);

	}
	
	public void bevestigKeuze(int gekozen,LinkedList<Kaart> lijst){
		System.out.println("Bent u zeker dat u de kaart " + lijst.get(gekozen).naam() + " wilt kopen?");
		System.out.print("typ 1 om door te gaan, 2 om te herkiezen : ");

		int keuze = scanner.nextInt();
		while (keuze < 1 || keuze > 2) {
			System.out.print("geef een geldige keuze in : ");
			keuze = scanner.nextInt();
		}

		switch (keuze) {
		case 1:
			aflegStapel.add(lijst.get(gekozen));
			layout();
			toonLijst(aflegStapel());
			break;
		case 2:
			koopKaart(lijst);
			break;

		default:
			break;
		}
	}

	public void keuzeSpeler(int keuze, LinkedList<Kaart> kaartenInHand, LinkedList<Kaart> koopKaarten,int koopMogelijkHeden) {

		switch (keuze) {
		case 1:
			LinkedList<Kaart> actieKaartenUitDrawHand = controleerActieKaarten(kaartenInHand);
			toonLijst(actieKaartenUitDrawHand);
			break;
		case 2:
			int coins = geldInHand(kaartenInHand);
			layout();
			System.out.println("Je hebt " + coins + " coins om te spenderen");
			layout();
			System.out.println("je kunt de volgende kaarten kopen");
			layout();
			LinkedList<Kaart> lijstWaarvanJeKanKopen = kaartenDieJeKuntKopen(koopKaarten, coins);
			toonLijst(lijstWaarvanJeKanKopen);
			layout();
			for (int i = 0; i < koopMogelijkHeden; i++) {
				
				koopKaart(lijstWaarvanJeKanKopen);
			}
			
			break;
		case 3:
			System.out.println("De beurt is beëindigd");
			break;

		default:
			break;
		}
	}

	public void geefKeuze(LinkedList<Kaart> kaartenInHand, LinkedList<Kaart> koopKaarten,int koopMogelijkHeden) {
		System.out.println("1: gebruik actie Kaarten");
		System.out.println("2: gebruik geld kaarten");
		System.out.println("3: beëindig je beurt");
		System.out.print("geef een keuze in : ");

		int keuze = scanner.nextInt();

		while (keuze < 0 || keuze > 3) {
			System.out.println("geef een correcte waarde in ");
			System.out.print("geef een keuze in : ");
			keuze = scanner.nextInt();
		
		}
		layout();

		keuzeSpeler(keuze, kaartenInHand , koopKaarten , koopMogelijkHeden);

	}
	
	public LinkedList<Kaart> controleerActieKaarten(LinkedList<Kaart> drawHand){
		LinkedList<Kaart> tmp = new LinkedList<Kaart>();
		for (int i = 0; i < drawHand.size(); i++) {
			if (drawHand.get(i).kaartType().equals("ActieKaart")) {
				tmp.add(drawHand.get(i));
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

	public LinkedList<Kaart> maakKaartInHandLeeg() {
		kaartenInHand.clear();
		return kaartenInHand;
	}

	public void toonLijst(LinkedList<Kaart> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			System.out.println((i + 1) + ": " + lijst.get(i).naam());
		}
	}
	public void dominionTitel() {
		System.out.println("----------------------------------WELKOM BIJ DOMINION------------------------------------");
	}
	
	public void layout(){
		System.out.println("-------------------");
	}

}
