package JavaCode;
import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import sun.awt.image.ImageWatched.Link;

public class Speler {
	
	private LinkedList<Kaart> kaartenInHand = new LinkedList<Kaart>();
	private LinkedList<Kaart> aflegStapel = new LinkedList<Kaart>();
	private LinkedList<Kaart> trekStapel = new LinkedList<Kaart>();
	private String naam;

	
	public Speler(String naam){
		this.naam = naam;
		//startKaarten();
	}
	
	public LinkedList<Kaart> startKaarten(){
		for (int i = 0; i < 7; i++) {trekStapel.add(new GeldKaart("koper"));}
		for (int j = 0; j < 3; j++) {trekStapel.add(new LandKaart("estate"));}
		Collections.shuffle(trekStapel);
		return trekStapel;
		}
	
	public void toonLijst(LinkedList<Kaart> lijst){
		for (int i = 0; i < lijst.size(); i++) {
			System.out.print((i+1)+": ");
			System.out.println(lijst.get(i).naam());
			}
		}
	
	public LinkedList<Kaart> lijstenSamenvoegen(LinkedList<Kaart> primaireLijst, LinkedList<Kaart> bijTeVoegenLijst ){
		
		for (int i = 0; i < bijTeVoegenLijst.size(); i++) {
			primaireLijst.add(bijTeVoegenLijst.get(i));}
		Collections.shuffle(primaireLijst);
		return primaireLijst;
	}
	
	public LinkedList<Kaart> trekHand(LinkedList<Kaart> lijst , int aantal){
		
		if (trekStapel.size() < aantal) {
			lijstenSamenvoegen(trekStapel, aflegStapel);	
		}
		
		for (int i = 0; i < aantal; i++) {
			kaartenInHand.add(lijst.get(i));
			aflegStapel.add(lijst.get(i));
			
		}
		return kaartenInHand;
	}
	
	public void maakHandLeeg() {
		
		kaartenInHand = new LinkedList<Kaart>();
		
	}
	
	
	public LinkedList<Kaart> aflegStapel(){
		return this.aflegStapel;
	}
	
	public LinkedList<Kaart> kaartInHand(){
		return this.kaartenInHand;
	}
	
	
	
}
