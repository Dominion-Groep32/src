package engine;
import java.util.*;

public class Speler {
	
	//test

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
		trekStapel = startKaarten();
		kaartenInHand = startKaartenInHand();
		aflegStapel = new LinkedList<Kaart>();
		vuilbakStapel = new LinkedList<Kaart>();
		speelGebied = new LinkedList<Kaart>();
		aankoop = 1;
		actie = 1;
		geld = 0;
	
		}
	
	public List<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {

			trekStapel.add(new Kaart("koper","geldkaart",0,1,"Deze kaart is 1 munt waard"));
			
			
		}
		for (int j = 0; j < 3; j++) {
			trekStapel.add(new Kaart("landgoed","overwinningskaart",2,1,"Is op het einde van het spel 1 punt waard"));
			
		}
		Collections.shuffle(trekStapel);
		return trekStapel;
	}
	
	public List<Kaart> startKaartenInHand() {
		for (int i = 0; i < 5; i++) {kaartenInHand.add(trekStapel.get(i));}
		for (int i = 0; i < 5; i++) {trekStapel.remove(0);}
		return kaartenInHand;
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
		this.geld =this.geld + geld;
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