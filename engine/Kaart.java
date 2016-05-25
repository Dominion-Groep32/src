package engine;

public class Kaart {
	
	private String KaartType;
	private String kaartNaam;	
	private String info;
	private int kost;
	private int waarde;
	private int overwinningpunten;
	private int extraAankoop;
	private int extraActie;
	private int extraKaart;
	private int extraMunten;
	private boolean specialeKaart;
	private boolean infoMeegeven;

	
	
	public Kaart(String naam, int kost, boolean specialeKaart,int extraAankoop, int extraActie, int extraKaart, int extraMunten,  String info, boolean infoMeegeven)
	{
		this.kaartNaam = naam;
		this.KaartType = "actiekaart";
		this.kost = kost;
		this.info = info;
		this.extraAankoop = extraAankoop;
		this.extraActie = extraActie;
		this.extraKaart = extraKaart;
		this.extraMunten = extraMunten;
		this.specialeKaart = specialeKaart;
		this.infoMeegeven = infoMeegeven;
	}
	
	public Kaart(String naam,String type, int kost, int waarde, String info )
	{
		this.kaartNaam = naam;
		this.KaartType = type;
		this.kost = kost;
		if(type == "overwinningskaart"){this.overwinningpunten = waarde;}
		else {this.waarde = waarde;};
		this.info = info;
	}


	public int krijgAantalOverwinnigsPunten() 
	{
		return this.overwinningpunten;	
	}

	public String geefNaam() {
		return this.kaartNaam;
	}

	public String geefKaartType() {
		return this.KaartType;
	}
	public int geefKost() {
		return this.kost;
	}

	public int geefWaarde() {
		return this.waarde;
	}
		
	public String geefInfo(){
		return this.info;
	}
	public int geefExtraAankoop() {
		return this.extraAankoop;
	}
	public int geefExtraActie() {
		return this.extraActie;
	}
	public int geefExtraKaart() {
		return this.extraKaart;
	}
	public int geefExtraMunten() {
		return this.extraMunten;
	}
	public boolean specialeKaart() {
		return this.specialeKaart;	
	}
	public boolean geefInfoMeegeven(){
		return this.infoMeegeven;
	}

	
}


