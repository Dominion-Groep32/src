package engine;


public class Kaart {
	
	private String KaartType;
	private String kaartNaam;	
	private String info;
	private int cost;
	private int waarde;
	private int overwinningpunten;
	
	
	public Kaart(String naam,String Type, int cost ,int waarde )
	{
		this.kaartNaam = naam;
		this.KaartType = Type;
		this.cost = cost;
		if(Type == "overwinningsKaart"){this.overwinningpunten = waarde;}
		else {this.waarde = waarde;}
		
	}
	public Kaart(String naam,String Type, int cost )
	{
		this.kaartNaam = naam;
		this.KaartType = Type;
		this.cost = cost;
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


