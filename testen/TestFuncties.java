package testen;

import java.util.LinkedList;
import org.junit.*;

import engine.GameEngine;
import engine.Kaart;
import engine.Speler;

public class TestFuncties {
	GameEngine Engine = new GameEngine();
	Speler speler = new Speler("testspeler");
	LinkedList<Kaart> eersteTestlijst = speler.startKaarten();
	LinkedList<Kaart> tweedeTestLijst = speler.startKaarten();
	
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	@Test
	public void startKaartenTest()
	{
		if (eersteTestlijst.equals(0))
		{System.err.println("aantal startkaarten kloppen niet");}
	}
	
	@Test
	public void spelersAanmaken()
	{
		String spelers[] = new String[2];
		spelers[0]="naamEersteSpeler";
		spelers[1]="naamTweedeSpeler";
		Engine.maakSpelersAan(spelers);
	}
	
	@Test
	public void veranderSpeler() {
		
	}
	
	@Test
	public void geefHuidigeSpeler(){
		
	}
	/*
	@Test
	public void lijstenSamenvoegenSuffle()
	{
		int lengte = Engine.lijstenSamenvoegenShuffle(eersteTestlijst, tweedeTestLijst).size();
		if(lengte == 20){System.err.println("Juist");}
		else{System.out.println("verkeerd");}
	}
	*/
	
	@Test
	public void lijstenSamenvoegenZonderSuffle(){
		
	
	}
	
	@Test
	public void actiekaartenGenereren(){
		
	}
	
	@Test
	public void geldInHand(){
		
	}
	
	@Test
	public void kaartenDieJeKuntKopen(){
		
	}
	
	@Test
	public void maakLijstLeeg()
	{
		eersteTestlijst.clear();
		if (eersteTestlijst.size() != 0) {
			System.err.println("fail");
		}
		
	}
}	
	
