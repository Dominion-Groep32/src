package engine;

import java.util.LinkedList;

public class ActieKaart implements Kaart {
	private String KaartType="ActieKaart";
	private String kaartNaam;
	private int cost;
	private int waarde;
	
	
	
	public ActieKaart(String naam) {
		this.kaartNaam = naam;
		
		switch (naam) {
		case "councilRoom":
			LinkedList<Kaart> tmp = engine.lijstenSamenvoegen(engine.kaartInHand(), engine.trekKaart(engine.trekstapel(), 4));
			engine.toonLijst(tmp);
			
			break;

		default:
			break;
		}
		
	}
	

	@Override
	public String naam() {
		return this.kaartNaam;
	}

	@Override
	public String kaartType() {
		return this.KaartType;
	}

	@Override
	public int kost() {
		return this.cost;
	}


	@Override
	public int waarde() {
	
		return this.waarde;
	}
	
}
