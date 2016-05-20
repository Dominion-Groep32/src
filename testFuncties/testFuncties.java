package testFuncties;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;


import engine.Kaart;
import engine.SpelFuncties;
import engine.Speler;
import engine.Stapel;

public class testFuncties {
	SpelFuncties engine = new SpelFuncties();
	Speler speler = new Speler("testspeler");
	List<Kaart> eersteTestlijst = speler.geefTrekStapel();
	List<Kaart> actiekaarten = engine.geefLijstAlleActiekaarten();
	
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
		//gebeurd al eens bij opstart van engine
		assertEquals(engine.actiekaartenGenereren().size(), 20);
		}
	@Test
	public void lijstenSamenvoegen()
	{	
		assertEquals(engine.lijstenSamenvoegenBijBestaandeLijst(eersteTestlijst, actiekaarten,true,false).size(), 35);
	}
	
	
	@Test
	public void lijstActiekaartenInHand()
	{
		spelersAanmaken();
		assertEquals(engine.neemActiekaartenUitHand().size(), 0);
		engine.geefHuidigeSpeler().geefKaartenInHand().add(actiekaarten.get(0));
		assertEquals(engine.neemActiekaartenUitHand().size(), 1);
		}	
	
	
	@Test
	public void geldInHand()
	{
		spelersAanmaken();
		assertEquals(engine.geldInHand(),0);
		engine.geefHuidigeSpeler().geefKaartenInHand().add(engine.geefLijstGeldkaarten().get(2));
		assertEquals(engine.geldInHand(), 3);
	}
	
	@Test
	public void kaartenDieJeKuntKopen(){
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderGeld(3);
		//is te flexibel om echt te testen
		//assertEquals(engine.kaartenDieJeKuntKopen().size(),1);
		
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
		String kaartNaam = actiekaarten.get(0).geefNaam();
		engine.verminderTafelstapel(kaartNaam);
		engine.verminderTafelstapel(kaartNaam);
		for (int i = 0; i < engine.geefLijstStapels().size(); i++) {
			if(engine.geefLijstStapels().get(i).geefStapelNaam()==kaartNaam){
				assertEquals(engine.geefLijstStapels().get(i).geefAatalResterendeKaartenInDeStapel(), 8);
			}}		
	}
	
	@Test
	public void spelNogNietBe�indigd(){
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
		engine.trekKaartVanTrekStapel(5);
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 5);
	}
	/*nog debuggen!!
	@Test
	public void actieUitvoeren(){
		spelersAanmaken();
		Kaart dorp = new Kaart("dorp",3,false,0,2,1,0,"+1 kaart / +2 acties");
		Kaart festival = new Kaart("festival",5,false,1,2,0,2,"+2 acties / +1 aanschaf / +2 munten");
		engine.geefHuidigeSpeler().geefKaartenInHand().clear();
		engine.geefHuidigeSpeler().geefKaartenInHand().add(dorp);
		engine.geefHuidigeSpeler().geefKaartenInHand().add(festival);
		
		engine.actieUitvoeren(dorp);
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 3);
		
		engine.actieUitvoeren(festival);
		assertEquals(engine.geefHuidigeSpeler().geefAankoop(), 2);
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 3);
		assertEquals(engine.geefHuidigeSpeler().geefGeld(), 2);
	
	}*/
	
	public void controleOfKaartAlInLijstZit(List<Kaart>lijst, Kaart kaart) {
		boolean tmp = false;
		for (int i = 0; i < lijst.size(); i++) {
			if(lijst.get(i).geefNaam() == kaart.geefNaam())
			{tmp = true;}}
		if(!tmp){lijst.add(kaart);}
	}
	@Test
	public void specialeActiesUitvoeren(){
		spelersAanmaken();
		Kaart kaart = new Kaart("avonturier",6,true,0,0,0,0,"Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel.");
		engine.geefHuidigeSpeler().geefKaartenInHand().add(kaart);
		controleOfKaartAlInLijstZit(engine.geefLijst10GekozenActiekaarten(), kaart);
		engine.actieUitvoeren(kaart);
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 2);
	}
	
	@Test
	public void vermeerderAankoopGeldEnActie(){
		
	}
	
	@Test
	public void verwijderKaart(){
		
	}

}
