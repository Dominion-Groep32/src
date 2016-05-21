package engine;

import java.util.List;

import sun.nio.cs.ext.TIS_620;



public class ExtraInfo {
	private Kaart actiekaart;
	private String bericht;
	private int aantalKaartenUitHandNemen;
	private int kaartKeuze;
	private int plaatsSpeler;
	private Kaart gekozenKaart;



public ExtraInfo(Kaart actiekaart,int kaartKeuze, int aantalKaarten){
	this.actiekaart = actiekaart;
	//this.bericht = bericht;
	this.kaartKeuze = kaartKeuze;
	this.aantalKaartenUitHandNemen = aantalKaarten;

	
}
public ExtraInfo (Kaart actiekaart, int kaartKeuze) {
	this.actiekaart = actiekaart;
	this.kaartKeuze = kaartKeuze;
}
public ExtraInfo (Kaart actiekaart,int plaatsSpeler, int kaartKeuze) {
	this.plaatsSpeler = plaatsSpeler;
	this.kaartKeuze = kaartKeuze;
}

public ExtraInfo( Kaart actiekaart,Kaart gekozenKaart){
	this.actiekaart = actiekaart;
	this.gekozenKaart = gekozenKaart;}

public Kaart geefActiekaart() {
	return this.actiekaart;
}

public String geefBericht(){
	return this.bericht;
}

public int geefAantalKaartenUitHandNemen() {
	return this.aantalKaartenUitHandNemen;
}

public int geefKaartKeuze() {
	return this.kaartKeuze;
}
public String geefactieKaartNaam() {
	return this.actiekaart.geefNaam();
}
public int geefPlaatsSpeler(){
	return this.plaatsSpeler;
}

public Kaart geefGekozenKaart() {
	return this.gekozenKaart;
}
}