package engine;



public class OverwinningKaart implements Kaart {
	private String KaartType="overwinningsKaart";
	private String kaartNaam;
	private int cost;
	private int waarde;
	private int overwinningpunten;
	
	public OverwinningKaart(String kaartnaam) {
		
		this.kaartNaam = kaartnaam;
		switch (kaartnaam) {
		case "estate":
			this.cost = 2;
			this.overwinningpunten = 1;
			this.kaartNaam = "estate";
			break;
		case "dutchy":
			this.cost = 5;
			this.overwinningpunten = 3; 
			this.kaartNaam = "dutchy";
			break;
		case "province":
			this.cost = 8;
			this.overwinningpunten = 6;
			this.kaartNaam = "province";
			break;
		case "vloek":
			this.overwinningpunten = - 1;
			this.kaartNaam = "vloek";

		default:
			break;
		}
		
	}
	
	public int krijgAantalOverwinnigsPunten() 
	{
		return this.overwinningpunten;	
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
