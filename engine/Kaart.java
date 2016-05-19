package engine;


public class Kaart {
	
	private String KaartType;
	private String kaartNaam;	
	private String info;
	private int cost;
	private int waarde;
	private int overwinningpunten;
	private int extraAankoop;
	private int extraActie;
	private int extraKaart;
	private int extraMunten;
	private boolean specialeKaart;
	
	
	public Kaart(String naam, int cost, boolean specialeKaart,int extraAankoop, int extraActie, int extraKaart, int extraMunten,  String info)
	{
		this.kaartNaam = naam;
		this.KaartType = "actiekaart";
		this.cost = cost;
		this.info = info;
		this.extraAankoop = extraAankoop;
		this.extraActie = extraActie;
		this.extraKaart = extraKaart;
		this.extraMunten = extraMunten;
		this.specialeKaart = specialeKaart;
		
	}
	
	public Kaart(String naam,String type, int cost, int waarde )
	{
		this.kaartNaam = naam;
		this.KaartType = type;
		this.cost = cost;
		if(type == "overwinningskaart"){this.overwinningpunten = waarde;}
		else {this.waarde = waarde;};
	}

	

	public int krijgAantalOverwinnigsPunten() 
	{
		return this.overwinningpunten;	
	}

	public String geefNaam() {
		return this.kaartNaam;
	}


	public String kaartType() {
		return this.KaartType;
	}

	
	public int geefKost() {
		return this.cost;
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
	}}


