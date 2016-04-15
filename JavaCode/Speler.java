package JavaCode;
import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import sun.awt.image.ImageWatched.Link;

public class Speler {
	GameEngine engine = new GameEngine();
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private String naam;

	
	public Speler(String naam){
		this.naam = naam;
		kaartenInHand = new LinkedList<Kaart>();
		trekStapel = engine.startKaarten();
		aflegStapel = new LinkedList<Kaart>();
		
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
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
