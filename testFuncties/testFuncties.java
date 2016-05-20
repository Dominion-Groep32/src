package testFuncties;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;


import engine.Kaart;
import engine.SpelFuncties;
import engine.Speler;
import engine.Stapel;

//test
	
	
	
public class testFuncties {
	SpelFuncties engine = new SpelFuncties();
	Speler speler = new Speler("testspeler");
	List<Kaart> eersteTestlijst = speler.geefTrekStapel();
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
		engine.volgendeSpeler();
		assertEquals(engine.geefHuidigeSpeler().geefNaam(), "naamTweedeSpeler");
	}
	
	@Test
	public void actiekaartenGenereren(){
		// gebeurd in SpelFuncties 
		}
	@Test
	public void lijstenSamenvoegen()
	{	
		assertEquals(engine.lijstenSamenvoegen(eersteTestlijst, actiekaarten,true).size(), 35);
	}
	
	
	@Test
	public void lijstActiekaartenInHand()
	{
		lijstenSamenvoegen();
		assertEquals(engine.neemActiekaartenUitHand(eersteTestlijst).size(), 25);
		eersteTestlijst.add(new Kaart("avonturier",6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel."));
		assertEquals(engine.neemActiekaartenUitHand(eersteTestlijst).size(), 26);
		}	
	
	
	@Test
	public void geldInHand()
	{
		assertEquals(engine.geldInHand(eersteTestlijst), 7);
		eersteTestlijst.add(new Kaart("koper","Geldkaart",0,1));
		assertEquals(engine.geldInHand(eersteTestlijst), 8);
	}
	
	@Test
	public void kaartenDieJeKuntKopen(){
		assertEquals(engine.kaartenDieJeKuntKopen(actiekaarten, 3).size(),7);
		
	}
	
	@Test
	public void maakLijstLeeg()
	{
		eersteTestlijst.clear();
		actiekaarten.clear();
		assertEquals(eersteTestlijst.size(), 0);
		assertEquals(actiekaarten.size(), 0);
	}

	@Test
	public void verminderStapel(){
		
	}
	
	@Test
	public void spelNogNietBeëindigd(){
		
	}

	@Test
	public void geefAnderSpelers(){
		
	}

	@Test
	public void stapelsAanmaken(){
		
	}
	
	@Test
	public void trekKaart(){
		spelersAanmaken();
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 0);
		engine.trekKaart(eersteTestlijst, 5);
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 5);
	}
	
	@Test
	public void actieUitvoeren(){
		spelersAanmaken();
		engine.geefHuidigeSpeler().geefKaartenInHand().add(new Kaart("dorp",3,false,0,2,1,0,"+1 kaart / +2 acties"));
		engine.geefHuidigeSpeler().geefKaartenInHand().add(new Kaart("festival",5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten"));
		engine.actieUitvoeren(new Kaart("dorp",3,false,0,2,1,0,"+1 kaart / +2 acties"));
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 3);
		
		engine.actieUitvoeren(new Kaart("festival",5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten"));
		assertEquals(engine.geefHuidigeSpeler().geefAankoop(), 2);
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 5);
		assertEquals(engine.geefHuidigeSpeler().geefGeld(), 2);
	
	}
	
	@Test
	public void specialeActiesUitvoeren(){
		
	}
	
	@Test
	public void vermeerderAankoopGeldEnActie(){
		
	}
	
	@Test
	public void verwijderKaart(){
		
	}

}
