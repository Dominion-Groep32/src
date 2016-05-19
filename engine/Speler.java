package engine;
import java.util.*;

public class Speler {

	private List<Kaart> kaartenInHand = new LinkedList<>();
	private List<Kaart> aflegStapel = new LinkedList<>();
	private List<Kaart> trekStapel = new LinkedList<>();
	private List<Kaart> vuilbakStapel = new LinkedList<>();
	private List<Kaart> speelGebied = new LinkedList<>();
	private String naam;
	private int aankoop ;
	private int actie;
	private int geld;


	public Speler(String naam){
		this.naam = naam;
		kaartenInHand = new LinkedList<Kaart>();
		trekStapel = startKaarten();
		aflegStapel = new LinkedList<Kaart>();
		vuilbakStapel = new LinkedList<Kaart>();
		speelGebied = new LinkedList<Kaart>();
		aankoop = 1;
		actie = 1;
		geld = 0;
	
		}
	
	public List<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {

			trekStapel.add(new Kaart("koper","Geldkaart",0,1));
			//trekStapel.add(new Kaart("dorp","actiekaart",3,"+1 kaart / +2 acties"));
		}
		for (int j = 0; j < 3; j++) {
			trekStapel.add(new Kaart("landgoed","overwinningskaart",2,1));
		}
		Collections.shuffle(trekStapel);
		return trekStapel;
	}
	
	
	
	
	
	
	public List<Kaart> geefTrekStapel()
	{
		return this.trekStapel;
	}
	
	public List<Kaart> geefAflegStapel()
	{
		return this.aflegStapel;
	}
	
	public 	List<Kaart> geefKaartenInHand() 
	{
		return this.kaartenInHand;
	}
	public List<Kaart> geefVuilbakStapel() {
		return this.vuilbakStapel;
	}
	
	public List<Kaart> geefSpeelGebied() {
		return this.speelGebied;
	}

	public String geefNaam() {
		return this.naam;
	}
	public int geefActie() {
		return this.actie;
	}
	
	public int geefGeld() {
		return this.geld;
	}
	
	public int geefAankoop() {
		return this.aankoop;
	}
	
	public void vermeerderActie(int actie) {
		this.actie = this.actie +actie;
	}
	public void verminderActie(int actie) {
		this.actie = this.actie - actie;
	}

	public void vermeerderGeld(int geld) {
		this.geld =this.geld+ geld;
	}
	public void verminderGeld(int geld) {
		this.geld =this.geld- geld;
	}
	public void vermeerderAankoop(int aankoop) {
		this.aankoop =this.aankoop+aankoop;
	}
	public void verminderAankoop(int aankoop) {
		this.aankoop =this.aankoop- aankoop;
	}

	public void herstelWaarden(){
		this.geld = 0;
		this.aankoop = 1;
		this.actie = 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
