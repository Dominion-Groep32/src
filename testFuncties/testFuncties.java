package testFuncties;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import engine.Kaart;
import engine.SpelFuncties;
import engine.Speler;

public class testFuncties {
	SpelFuncties engine = new SpelFuncties();
	Speler speler = new Speler("testspeler");
	List<Kaart> eersteTestlijst = speler.trekStapel();
	List<Kaart> tweedeTestLijst = speler.trekStapel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	@Test
	public void startKaartenTest()
	{
		assertEquals(eersteTestlijst.size(), 10);
	}
	
	@Test
	public void spelersAanmaken()
	{
		String spelers[] = new String[3];
		spelers[0]="naamEersteSpeler";
		spelers[1]="naamTweedeSpeler";
		spelers[2]="naamDerdeSpeler";
		
		
		engine.maakSpelersAan(spelers);
		assertEquals(spelers.length, 3);
	}
	
	@Test
	public void volgendeSpeler() {
		spelersAanmaken();
		engine.volgendeSpeler();
		assertEquals(engine.geefHuidigeSpeler().geefNaam(), "naamTweedeSpeler");
		engine.volgendeSpeler();
		assertEquals(engine.geefHuidigeSpeler().geefNaam(), "naamDerdeSpeler");
		engine.volgendeSpeler();
		assertEquals(engine.geefHuidigeSpeler().geefNaam(), "naamEersteSpeler");
		
	}
	
	@Test
	public void geefHuidigeSpeler(){
		spelersAanmaken();
		assertEquals(engine.geefHuidigeSpeler().geefNaam(), "naamEersteSpeler");
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
	public void ControleerActiekaarten()
	{
		//if (engine.controleerActieKaarten(derdeTestLijst).size() != 5){System.err.println("Fout in controle actiekaarten");
		}

	public void lijstenSamenvoegenZonderSuffle(){
		
	
	}
	
	@Test
	public void actiekaartenGenereren(){

		
	}
	
	@Test
	public void geldInHand()
	{
		int geld = engine.geldInHand(eersteTestlijst);
		if (geld != 7){System.err.println("Fout aantal geld in hand");}}

	
	
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
