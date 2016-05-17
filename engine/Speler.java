package engine;
import java.util.*;


//fk

public class Speler {
	// het werkt
	GameEngine engine = new GameEngine();
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trashStapel = new LinkedList<Kaart>();
	private String naam;
	private int aankoop ;
	private int actie;
	private int geld;

	
	public Speler(String naam){
		//testt
		//Test
		this.naam = naam;
		kaartenInHand = new LinkedList<Kaart>();
		trekStapel = startKaarten();
		aflegStapel = new LinkedList<Kaart>();
		aankoop = 1;
		actie = 1;
		geld = 0;
		
	}
	
	public LinkedList<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {
			trekStapel.add(new GeldKaart("koper"));
			//trekStapel.add(new ActieKaart("raadszaal"));
<<<<<<< HEAD
			//test
=======
			
>>>>>>> 62443a9f9fb6308088026b124831ba01d85f1988
		}
		for (int j = 0; j < 3; j++) {
			trekStapel.add(new OverwinningKaart("estate"));
		}
		Collections.shuffle(trekStapel);
		return trekStapel;
	}
	
	public LinkedList<Kaart> trekKaart(LinkedList<Kaart> lijst, int aantal) {
		if (lijst.size() < aantal) {
			lijst = engine.lijstenSamenvoegenShuffle(trekStapel, aflegStapel);
		}
		for (int i = 0; i < aantal; i++) {
			kaartenInHand.add(lijst.get(i));
			aflegStapel.add(lijst.get(i));
		}
		for (int i = 0; i < aantal; i++) {
			lijst.removeFirst();
		}
		return kaartenInHand;
	}
	
	public void verwijderKaart(Kaart kaart){
		//nog bekijken
		kaartenInHand.remove(kaart);
		trashStapel.add(kaart);
	}
	
	
	public LinkedList<Kaart> trekStapel()
	{
		return trekStapel;
	}
	
	public LinkedList<Kaart> aflegStapel()
	{
		return aflegStapel;
	}
	
	public LinkedList<Kaart> kaartenInHand() 
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
