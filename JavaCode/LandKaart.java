package JavaCode;

public class LandKaart implements Kaart {
	private String KaartType="overwinningsKaarten";
	private String kaartNaam;
	private int cost;
	private int waarde;
	
	public LandKaart(String kaartnaam) {
		
		this.kaartNaam = kaartnaam;
		switch (kaartnaam) {
		case "estate":
			this.cost = 1;
			this.waarde = 1;
			this.kaartNaam = "estate";
			break;
		case "dutchy":
			this.cost = 3;
			this.waarde = 3; //GEEN IDEE!
			this.kaartNaam = "dutchy";
			break;
		case "province":
			this.cost = 8;
			this.waarde = 6; //GEEN IDEE!
			this.kaartNaam = "province";
			break;

		default:
			break;
		}
		
	}

	@Override
	public String naam() {
		// TODO Auto-generated method stub
		return this.kaartNaam;
	}

	@Override
	public String kaartType() {
		// TODO Auto-generated method stub
		return this.KaartType;
	}

	@Override
	public int kost() {
		// TODO Auto-generated method stub
		return this.cost;
	}

}
