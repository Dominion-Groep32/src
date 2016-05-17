package engine;
import java.util.*;

public class Speler {
	GameEngine engine = new GameEngine();
	private List<Kaart> kaartenInHand = new LinkedList<>();
	private List<Kaart> aflegStapel = new LinkedList<>();
	private List<Kaart> trekStapel = new LinkedList<>();
	private List<Kaart> trashStapel = new LinkedList<>();
	private String naam;
	private int aankoop ;
	private int actie;
	private int geld;

	//als je nu werkt suckt griet
	public Speler(String naam){
		this.naam = naam;
		kaartenInHand = new LinkedList<Kaart>();
		trekStapel = startKaarten();
		aflegStapel = new LinkedList<Kaart>();
		aankoop = 1;
		actie = 1;
		geld = 0;
	
		
	}
	
	public List<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {
			trekStapel.add(new Kaart("koper","GeldKaart",0,1));
			//trekStapel.add(new ActieKaart("raadszaal"));
		}
		for (int j = 0; j < 3; j++) {
			trekStapel.add(new Kaart("estate","overwinningsKaart",2,1));
		}
		Collections.shuffle(trekStapel);
		return trekStapel;
	}
	
	public List<Kaart> trekKaart(List<Kaart> lijst, int aantal) {
		if (lijst.size() < aantal) {
			lijst = engine.lijstenSamenvoegenShuffle(trekStapel, aflegStapel);
		}
		for (int i = 0; i < aantal; i++) {
			kaartenInHand.add(lijst.get(i));
			aflegStapel.add(lijst.get(i));
		}
		for (int i = 0; i < aantal; i++) {
			lijst.remove(i);
		}
		return kaartenInHand;
	}
	
	public void verwijderKaart(Kaart kaart){
		//nog bekijken
		kaartenInHand.remove(kaart);
		trashStapel.add(kaart);
	}
	
	
	public List<Kaart> trekStapel()
	{
		return trekStapel;
	}
	
	public List<Kaart> aflegStapel()
	{
		return aflegStapel;
	}
	
	public 	List<Kaart> kaartenInHand() 
	{
		return kaartenInHand;
	}


	public String geefNaam() {
		return naam;
	}
	public int geefActie() {
		return actie;
	}
	
	public int geefGeld() {
		return geld;
	}
	
	public int geefAankoop() {
		return aankoop;
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
