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
	//tweedelijst is 7 lang
	List<Kaart> tweedeTestLijst = new LinkedList<>(Arrays.asList(new Kaart("avonturier",6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."),
			new Kaart("bureaucraat",4,true,0,0,0,0,"Leg uit de algemene voorraad een zilverkaart op je trekstapel. Iedere andere speler legt een overwinningskaart uit zijn hand op zijn trekstapel (of laat zien dat hij deze niet heeft)"), new Kaart("kelder",2,true,0,1,0,0,"+1 actie / Leg een aantal kaarten naar keuze af. +1 kaart per afgelegde kaart."), new Kaart("raadsheer",3,true,0,0,0,2,"+2 munten / Je mag je trekstapel direct op je aflegstapel leggen"),new Kaart("kapel",2,true,0,0,0,0,"Vernietig 4 of minder kaarten uit je hand"),new Kaart("raadszaal",5,true,1,0,4,0,"+4 kaarten / +1 aanschaf / Iedere andere speler trekt 1 kaart"),new Kaart("feest",4,true,0,0,0,5,"Vernietig deze kaart. Pak een kaart met een waarde van 5 munten of minder.")));
	
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
		assertEquals(tweedeTestLijst.size(), 7);
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
	public void lijstenSamenvoegen()
	{	
		assertEquals(engine.lijstenSamenvoegen(eersteTestlijst, tweedeTestLijst,true).size(), 17);
	}
	
	
	@Test
	public void ControleerActiekaarten()
	{
		lijstenSamenvoegen();
		assertEquals(engine.neemActiekaartenUitHand(eersteTestlijst).size(), 7);
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
