package engine;



public class ActieKaart implements Kaart {
	private String KaartType="ActieKaart";
	private String kaartNaam;
	private int cost;
	private int waarde;

	
	
	
	public ActieKaart(String naam) {
		this.kaartNaam = naam;
		
		switch (naam) {
		case "avonturier":
			this.cost = 6;
			this.kaartNaam = naam;
			break;
		case "bureaucraat":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "kelder":
			this.cost = 2;
			this.kaartNaam = naam;
			break;
		case "raadsheer":
			this.cost = 3;
			this.kaartNaam = naam;
			break;
		case "kapel":
			this.cost = 2;
			this.kaartNaam = naam;
			break;
		case "raadszaal":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "feest":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "festival":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "tuinen":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "laboratorium":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "bibliotheek":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "markt":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "militie":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "mijn":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "slotgracht":
			this.cost = 2;
			this.kaartNaam = naam;
			break;
		case "geldschieter":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "verbouwing":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "smidse":
			this.cost = 4;
			this.kaartNaam = naam;
			
		
			break;
		case "spion":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "dief":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "troonzaal":
			this.cost = 4;
			this.kaartNaam = naam;
			break;
		case "dorp":
			this.cost = 3;
			this.kaartNaam = naam;
			break;
		case "heks":
			this.cost = 5;
			this.kaartNaam = naam;
			break;
		case "houthakker":
			this.cost = 3;
			this.kaartNaam = naam;
			break;
		case "werkplaats":
			this.cost = 3;
			this.kaartNaam = naam;
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
