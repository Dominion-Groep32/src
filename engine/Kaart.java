package engine;

public class Kaart {
	
	private String KaartType;
	private String kaartNaam;
	private String info;
	private int cost;
	private int waarde;
	private int overwinningpunten;
	
	public Kaart(String kaartnaam)
	{
		this.kaartNaam = kaartnaam;
		switch (kaartnaam) {
		case "estate":
			this.cost = 2;
			this.overwinningpunten = 1;
			this.kaartNaam = "estate";
			this.KaartType = "overwinningsKaart";
			break;
		case "dutchy":
			this.cost = 5;
			this.overwinningpunten = 3; 
			this.kaartNaam = "dutchy";
			this.KaartType = "overwinningsKaart";
			break;
		case "province":
			this.cost = 8;
			this.overwinningpunten = 6;
			this.kaartNaam = "province";
			this.KaartType = "overwinningsKaart";
			break;
		case "vloek":
			this.overwinningpunten = - 1;
			this.kaartNaam = "vloek";
			this.KaartType = "overwinningsKaart";
			break;
		case "avonturier":
			this.cost = 6;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "bureaucraat":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "kelder":
			this.cost = 2;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "raadsheer":
			this.cost = 3;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "kapel":
			this.cost = 2;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "raadszaal":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "feest":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "festival":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "tuinen":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "laboratorium":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "bibliotheek":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "markt":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "militie":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "mijn":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "slotgracht":
			this.cost = 2;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "geldschieter":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "verbouwing":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "smidse":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "spion":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "dief":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "troonzaal":
			this.cost = 4;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "dorp":
			this.cost = 3;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "heks":
			this.cost = 5;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "houthakker":
			this.cost = 3;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "werkplaats":
			this.cost = 3;
			this.kaartNaam = kaartnaam;
			this.info="hjkmhuj";
			this.KaartType = "actieKaart";
			break;
		case "koper":
			this.cost = 0;
			this.waarde =1;	
			this.kaartNaam= kaartnaam;	
			this.KaartType="geldKaart";
			break;
			
		case "zilver":
			this.cost = 3;
			this.waarde = 2;
			this.kaartNaam = kaartnaam;
			this.KaartType="geldKaart";
			
			break;
		case "goud":
			this.cost = 6;
			this.waarde = 3;
			this.kaartNaam = kaartnaam;
			this.KaartType="geldKaart";
			
			break;

		default:
			break;
		}
		
	}

	public int krijgAantalOverwinnigsPunten() 
	{
		return this.overwinningpunten;	
	}

	public String naam() {
		return this.kaartNaam;
	}


	public String kaartType() {
		return this.KaartType;
	}

	
	public int kost() {
		return this.cost;
	}

	public int waarde() {
		return this.waarde;
	}
	
	
	public String info(){
		return this.info;
	}
		
	}


