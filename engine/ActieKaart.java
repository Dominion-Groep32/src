package engine;

import javax.sound.midi.MidiDevice.Info;

public class ActieKaart implements Kaart {
	private String KaartType="ActieKaart";
	private String kaartNaam;
	private String info;
	private int cost;
	private int waarde;

	
	
	
	public ActieKaart(String naam) {
		this.kaartNaam = naam;
		switch (naam) {
		case "avonturier":
			this.cost = 6;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "bureaucraat":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "kelder":
			this.cost = 2;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "raadsheer":
			this.cost = 3;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "kapel":
			this.cost = 2;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "raadszaal":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "feest":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "festival":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "tuinen":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "laboratorium":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "bibliotheek":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "markt":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "militie":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "mijn":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "slotgracht":
			this.cost = 2;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "geldschieter":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "verbouwing":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "smidse":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "spion":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "dief":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "troonzaal":
			this.cost = 4;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "dorp":
			this.cost = 3;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "heks":
			this.cost = 5;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "houthakker":
			this.cost = 3;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
			break;
		case "werkplaats":
			this.cost = 3;
			this.kaartNaam = naam;
			this.info="hjkmhuj";
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
	public String info(){
		return this.info;
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
