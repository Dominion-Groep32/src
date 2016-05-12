package engine;
import java.util.*;



public class Speler {
	GameEngine engine = new GameEngine();
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
<<<<<<< HEAD
	private LinkedList<Kaart> vuilbakStapel = new LinkedList<Kaart>();
=======
>>>>>>> origin/master
	private String naam;

	
	public Speler(String naam){
		this.naam = naam;
		kaartenInHand = new LinkedList<Kaart>();
		trekStapel = startKaarten();
		aflegStapel = new LinkedList<Kaart>();
<<<<<<< HEAD
		vuilbakStapel = new LinkedList<Kaart>();
		aankoop = 1;
		actie = 1;
		geld = 0;
=======
>>>>>>> origin/master
		
	}
	
	public LinkedList<Kaart> startKaarten() {
		for (int i = 0; i < 7; i++) {
			trekStapel.add(new GeldKaart("koper"));
			//trekStapel.add(new ActieKaart("smidse"));
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
	
<<<<<<< HEAD
	public void verwijderKaart(Kaart kaart){
		//nog bekijken
		kaartenInHand.remove(kaart);
		vuilbakStapel.add(kaart);
	}
	
=======
>>>>>>> origin/master
	
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


	public String getNaam() {
		return naam;
	}
	

	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
