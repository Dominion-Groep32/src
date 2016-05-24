package engine;

import java.util.List;


public class ExtraInfo {
	private String actiekaartNaam;
	private String bericht;
	private String kaartSpecificaties;
	private int maxAantalKaarten;
	private Boolean aanval;
	private Boolean specialeUitwerking;
	private List<Speler> spelers;
	

public ExtraInfo(String kaartNaam,int aantalKaarten, String bericht, String kaartSpecificaties,Boolean aanval,List<Speler> spelersMeegeven,boolean specialeUitwerking){
	this.actiekaartNaam = kaartNaam;
	this.maxAantalKaarten = aantalKaarten;
	this.bericht = bericht;
	this.kaartSpecificaties = kaartSpecificaties;
	this.aanval = aanval;
	this.spelers = spelersMeegeven;
	this.specialeUitwerking = specialeUitwerking;
}

public ExtraInfo(String kaartNaam, List<Speler> spelers, String kaartSpecificaties, Boolean aanval){
	this.actiekaartNaam = kaartNaam;
	this.spelers = spelers;
	this.kaartSpecificaties = kaartSpecificaties;
	this.aanval = aanval;
	this.specialeUitwerking = true;
}



public ExtraInfo (String kaartNaam, List<Speler> spelers) {
	this.actiekaartNaam = kaartNaam;
	this.spelers = spelers;
}

public String kaartNaam() {
	return this.actiekaartNaam;
}

public String geefBericht(){
	return this.bericht;
}

public int geefMaxAantalKaarten() {
	return this.maxAantalKaarten;
}

public List<Speler> geefSpelers() {
	return this.spelers;
}

public String geefKaartSpecificaties() {
	return this.kaartSpecificaties;
}
public boolean geefAanval() {
	return this.aanval;
}
public Boolean geefSpecialeUitwerking() {
	return this.specialeUitwerking;
}
}
