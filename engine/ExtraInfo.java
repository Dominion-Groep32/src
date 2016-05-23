package engine;

import java.util.List;


public class ExtraInfo {
	private String actiekaartNaam;
	private String bericht;
	private int maxAantalKaartenUitHand;
	private int spelersIndex;
	private List<Kaart> gekozenKaart;
	private String soortActie;
	
public ExtraInfo () {
	
};
	

public ExtraInfo(String kaartNaam,int aantalKaarten, String bericht, String soortActie ){
	this.actiekaartNaam = kaartNaam;
	this.maxAantalKaartenUitHand = aantalKaarten;
	this.bericht = bericht;
	this.soortActie = soortActie;
}


public ExtraInfo (String kaartNaam, int spelersIndex,  List<Kaart> gekozenKaarten) {
	this.actiekaartNaam = kaartNaam;
	this.spelersIndex = spelersIndex;
	this.gekozenKaart = gekozenKaarten;
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


public int geefAantalKaartenUitHandNemen() {
	return this.maxAantalKaartenUitHand;
}


public List<Kaart> geefGekozenKaart() {
	return this.gekozenKaart;
}
public int geefSpelersIndex() {
	return this.spelersIndex;
}

public String geefSoortActie() {
	return this.soortActie;
}
}
