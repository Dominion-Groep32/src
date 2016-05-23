package engine;

import java.util.List;


public class ExtraInfo {
	private Kaart actiekaart;
	private String bericht;
	private int maxAantalKaartenUitHand;
	private int spelersIndex;
	private List<Kaart> gekozenKaart;
	private String soortActie;
	
	
	//test


public ExtraInfo () {
	
};
	

public ExtraInfo(Kaart actiekaart,int aantalKaarten, String bericht, String soortActie ){
	this.actiekaart = actiekaart;
	this.maxAantalKaartenUitHand = aantalKaarten;
	this.bericht = bericht;
	this.soortActie = soortActie;

	
}


public ExtraInfo (Kaart actiekaart , int spelersIndex,  List<Kaart> gekozenKaarten) {
	this.actiekaart = actiekaart;
	this.spelersIndex = spelersIndex;
	this.gekozenKaart = gekozenKaarten;
}

public ExtraInfo (Kaart actiekaart,  List<Kaart> gekozenKaarten) {
	this.actiekaart = actiekaart;
	this.gekozenKaart = gekozenKaarten;
}

/*public ExtraInfo( Kaart actiekaart,Kaart gekozenKaart){
	this.actiekaart = actiekaart;
	this.gekozenKaart = gekozenKaart;}
*/
public Kaart geefActiekaart() {
	return this.actiekaart;
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
