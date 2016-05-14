	package testen;

import java.util.*;
import org.junit.*;
import engine.*;
/*
public class TestFuncties {
	GameEngine engine = new GameEngine();
	Speler speler = new Speler("testspeler");
	private List<Kaart> eersteTestlijst = speler.trekStapel();

	private List<Kaart> derdeTestLijst = new LinkedList<Kaart>(Arrays.asList(new Kaart("avonturier"),
			new Kaart("bureaucraat"), new Kaart("kelder"), new Kaart("raadsheer"),new Kaart("heks"),new Kaart("koper"),new Kaart("koper"),
			new Kaart("koper"),new Kaart("estate"),new Kaart("estate"),new Kaart("estate")));	
	
	 * new LinkedList<Kaart>(Arrays.asList(new Kaart("avonturier"),
			new Kaart("bureaucraat"), new Kaart("kelder"), new Kaart("raadsheer"),new Kaart("heks"),new Kaart("koper"),new Kaart("koper"),
			new Kaart("koper"),new Kaart("estate"),new Kaart("estate"),new Kaart("estate")));
	
	
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	@Test
	public void startKaartenTest()
	{
		
		if (eersteTestlijst.size() != 10)
		{System.err.println("aantal startkaarten kloppen niet");}
		
	}
	
	@Test
	public void spelersAanmaken()
	{
		String spelers[] = new String[2];
		spelers[0]="naamEersteSpeler";
		spelers[1]="naamTweedeSpeler";
		engine.maakSpelersAan(spelers);
		
	}

	@Test
	public void lijstenSamenvoegenShuffle()
	{
	
		List<Kaart> tester = engine.lijstenSamenvoegenShuffle(eersteTestlijst, derdeTestLijst);		
		if (tester.size() != 20){System.out.println("Fout in lijsten samenvoegen shuffle");}
		
	}
	
	
	@Test
	public void lijstenSamenvoegenZonderSuffle()
	{
	}
	
	@Test
	public void ControleerActiekaarten()
	{
		
		if (engine.controleerActieKaarten(derdeTestLijst).size() != 5){System.err.println("Fout in controle actiekaarten");}
		
	}
	
	@Test
	public void geldInHand()
	{
		int geld = engine.geldInHand(eersteTestlijst);
		if (geld != 7){System.err.println("fail");}
	}
	
	@Test
	public void kaartenDieJeKuntKopen()
	{
		if (engine.kaartenDieJeKuntKopen(derdeTestLijst, 3).size() != 8){System.err.println("Fout aaantal kaarten die je kunt kopen");}
	}
	
	@Test
	public void maakLijstLeeg()
	{
		eersteTestlijst.clear();
		if (eersteTestlijst.size() != 0) {
			System.err.println("Lijst is niet leeggemaakt");
		}	
	}
}	
	 */
