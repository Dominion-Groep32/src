package engine;

import java.util.List;


public class ExtraInfo {
	private String actiekaartNaam;
	private String bericht;
	private int maxAantalKaarten;
	private List<Integer> spelersIndex;
	private List<Kaart> gekozenKaart;
	private String soortActie;
	private List<Integer> keuzeSpeler;
	private List<Boolean> gebruikSlotgracht;
	

public ExtraInfo(String kaartNaam,int aantalKaarten, String bericht, String soortActie ){
	this.actiekaartNaam = kaartNaam;
	this.maxAantalKaarten = aantalKaarten;
	this.bericht = bericht;
	this.soortActie = soortActie;
}


public ExtraInfo (String kaartNaam, List<Integer> spelersIndex,  List<Kaart> gekozenKaarten,List<Integer>keuzeSpeler,List<Boolean> gebruikSlotgracht) {
	this.actiekaartNaam = kaartNaam;
	this.spelersIndex = spelersIndex;
	this.gekozenKaart = gekozenKaarten;
	this.gebruikSlotgracht = gebruikSlotgracht;
	this.keuzeSpeler = keuzeSpeler;
}


public ExtraInfo (String kaartNaam,  List<Kaart> gekozenKaarten) {
	this.actiekaartNaam = kaartNaam;
	this.gekozenKaart = gekozenKaarten;
}

/*public ExtraInfo( Kaart actiekaart,Kaart gekozenKaart){
	this.actiekaart = actiekaart;
	this.gekozenKaart = gekozenKaart;}
*/
public String kaartNaam() {
	return this.actiekaartNaam;
}

public String geefBericht(){
	return this.bericht;
}


public int geefMaxAantalKaarten() {
	return this.maxAantalKaarten;
}


public List<Kaart> geefGekozenKaart() {
	return this.gekozenKaart;
}
public List<Integer> geefSpelersIndex() {
	return this.spelersIndex;
}

public String geefSoortActie() {
	return this.soortActie;
}
public List<Integer> geefKeuzeSpeler() {
	return this.keuzeSpeler;
}
public List<Boolean> geefGebruikSlotgracht() {
	return this.gebruikSlotgracht;
}
}
