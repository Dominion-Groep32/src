package testFuncties;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
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
	List<Kaart> actiekaarten = engine.geefLijstAlleActiekaarten();
	
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
		assertEquals(actiekaarten.size(), 25);
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
	
	@Test
	public void actiekaartenGenereren(){
		assertEquals(engine.actiekaartenGenereren().size(), 10);
		}
	@Test
	public void lijstenSamenvoegen()
	{	
		actiekaartenGenereren();
		assertEquals(engine.lijstenSamenvoegen(eersteTestlijst, actiekaarten,true).size(), 17);
	}
	
	
	@Test
	public void ControleerActiekaarten()
	{
		lijstenSamenvoegen();
		System.out.println(engine.neemActiekaartenUitHand(eersteTestlijst).size());
		assertEquals(engine.neemActiekaartenUitHand(eersteTestlijst).size(), 10);
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
