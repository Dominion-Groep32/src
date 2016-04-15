package JavaCode;

public class GeldKaart implements Kaart {
	private String KaartType="Geldkaart";
	private String kaartNaam;
	private int cost;
	private int waarde;

	public GeldKaart(String kaartnaam) {
		this.kaartNaam = kaartnaam;
		
		switch (kaartnaam) {
		case "koper":
			this.cost = 0;
			this.waarde =1;	
			this.kaartNaam= "koper";
					
			break;
			
		case "zilver":
			this.cost = 3;
			this.waarde = 2;
			this.kaartNaam = "zilver";
			
			break;
		case "goud":
			this.cost = 6;
			this.waarde = 3;
			this.kaartNaam = "goud";
			
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
	public int waarde(){
		return this.waarde;
	}
	
	

}
