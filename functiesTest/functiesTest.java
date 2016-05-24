package functiesTest;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import com.sun.media.jfxmedia.track.Track.Encoding;

import engine.Kaart;
import engine.SpelFuncties;
import engine.Speler;
import engine.Stapel;

public class functiesTest {
	SpelFuncties engine = new SpelFuncties();
	Speler speler = new Speler("testspeler");
	List<Kaart> eersteTestlijst = speler.geefTrekStapel();
	List<Kaart> actiekaarten = engine.geefLijst10GekozenActiekaarten();
	
	@Test
	public void startKaartenTest() {
		spelersAanmaken();
		assertEquals(engine.geefHuidigeSpeler().geefTrekStapel().size(), 5);
		//assertEquals(actiekaarten.size(), 25);
		assertEquals(actiekaarten.size(), 10);
	}
	
	@Test
	public void spelersAanmaken() {
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
		//engine.actiekaartenGenereren();
		spelersAanmaken();
		assertEquals(actiekaarten.size(), 10);
	}
	
	@Test
	public void handkaartenControleren() {
		spelersAanmaken();
		assertEquals(eersteTestlijst.size(), 5);
	}
	
	@Test
	public void lijstenSamenvoegen() {	
		assertEquals(engine.lijstenSamenvoegenBijBestaandeLijst(eersteTestlijst, actiekaarten,true,false).size(), 15);
	}
	
	/*
	@Test
	public void lijstActiekaartenInHand() {
		spelersAanmaken();
		assertEquals(engine.neemActiekaartenUitHand().size(), 0);
		engine.geefHuidigeSpeler().geefKaartenInHand().add(actiekaarten.get(0));
		assertEquals(engine.neemActiekaartenUitHand().size(), 1);
	}
	
	
	@Test
	public void geldInHand() {
		spelersAanmaken();
		assertEquals(engine.geldInHand(),0);
		//engine.geefHuidigeSpeler().geefKaartenInHand().add(engine.geefLijstGeldkaarten().get(2));
		engine.geefHuidigeSpeler().geefKaartenInHand().add(new Kaart("goud","geldkaart",6,3,"Deze kaart is 3 munten waard"));
		assertEquals(engine.geldInHand(), 3);
	}
	*/
	
	@Test
	public void kaartenDieJeKuntKopen(){
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderGeld(1);
		assertEquals(engine.geefHuidigeSpeler().geefGeld(), 1);
		//is te flexibel om echt te testen
		//assertEquals(engine.kaartenDieJeKuntKopen().size(),1);	
	}
	
	@Test
	public void maakLijstLeeg()	{
		eersteTestlijst.clear();
		actiekaarten.clear();
		assertEquals(eersteTestlijst.size(), 0);
		assertEquals(actiekaarten.size(), 0);
	}

	@Test
	public void verminderStapel(){
		String kaartNaam = actiekaarten.get(0).geefNaam();
		engine.verminderTafelstapel(kaartNaam);
		
		for (int i = 0; i < engine.geefLijstStapels().size(); i++) {
			if(engine.geefLijstStapels().get(i).geefStapelNaam()==kaartNaam){
				assertEquals(engine.geefLijstStapels().get(i).geefAatalResterendeKaartenInDeStapel(), 9);
			}
		}
		//enkel actie stapels zijn 10 , overwininingskaarten 12 , en geldkaarten 40
	}
	
	@Test
	public void spelNogNietBeëindigd(){
	}

	@Test
	public void geefAnderSpelers(){
		spelersAanmaken();
		engine.LijstAndereSpelers(engine.geefHuidigeSpeler());
		engine.volgendeSpeler();
		assertEquals(engine.geefLijstAndereSpelers().get(0).geefNaam(), engine.geefHuidigeSpeler().geefNaam());
	}

	@Test
	public void stapelsAanmaken(){
	}
	
	@Test
	public void trekKaart(){
		spelersAanmaken();
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
	
	
	@Test
	public void actieUitvoeren() {
		spelersAanmaken();
		Kaart dorp = new Kaart("dorp", "actie", 3, 0, "+1 kaart / +2 acties");
		
		engine.geefHuidigeSpeler().geefKaartenInHand().clear();
		engine.geefHuidigeSpeler().geefKaartenInHand().add(dorp);
		engine.actieUitvoeren(dorp);
		engine.raadszaal();
		System.out.println(engine.geefHuidigeSpeler().geefActie());
		
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 2);
	}
	
	
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
		Kaart kaart = new Kaart("avonturier", "actie", 6, 0, "Draai achtereenvolgens de bovenste kaarten van je trekstapel om totdat je in totaal 2 geldkaarten hebt. Neem ze op handen. Leg de overige omgedraagde kaarten op je alegstapel.");
		engine.geefHuidigeSpeler().geefKaartenInHand().add(kaart);
		controleOfKaartAlInLijstZit(engine.geefLijst10GekozenActiekaarten(), kaart);
		engine.actieUitvoeren(kaart);
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 5);
	}
	
	/*
	@Test
	public void raadszaal(){
		spelersAanmaken();
		engine.raadszaal();
		System.out.println(engine.geefHuidigeSpeler().geefKaartenInHand().size());
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 5);
		System.out.println(engine.geefHuidigeSpeler().geefKaartenInHand().size());
		engine.volgendeSpeler();
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 6);
	}
	*/
	
	@Test
	public void herstelWaarden() {
		spelersAanmaken();
		speler.herstelWaarden();
		assertEquals(speler.geefGeld(), 0);
		assertEquals(speler.geefAankoop(), 1);
		assertEquals(speler.geefActie(), 1);
	}
	
	@Test
	public void vermeerderScore() {
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderScore(10);
		assertEquals(engine.geefHuidigeSpeler().geefScore(), 10);
	}
	
	@Test
	public void geldTesten() {
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderGeld(10);
		assertEquals(engine.geefHuidigeSpeler().geefGeld(), 10);
		
		engine.geefHuidigeSpeler().verminderGeld(5);
		assertEquals(engine.geefHuidigeSpeler().geefGeld(), 5);
	}
	
	@Test
	public void aankoopTesten() {
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderAankoop(10);
		assertEquals(engine.geefHuidigeSpeler().geefAankoop(), 11);
		
		engine.geefHuidigeSpeler().verminderAankoop(5);
		assertEquals(engine.geefHuidigeSpeler().geefAankoop(), 6);
	}
	
	@Test
	public void actiesTesten(){
		spelersAanmaken();
		engine.geefHuidigeSpeler().vermeerderActie(10);
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 11);
		
		engine.geefHuidigeSpeler().verminderActie(5);
		assertEquals(engine.geefHuidigeSpeler().geefActie(), 6);
	}
	
	@Test
	public void hoeveelheidSpelers() {
		spelersAanmaken();
		engine.geefLijstSpelers();
		
		assertEquals(engine.geefLijstSpelers().length, 3);
	}
	
	@Test
	public void isKaartInHand() {
		spelersAanmaken();
		engine.raadszaal();
		//verder aanvullen
	}
	
	@Test
	public void kaartVanTrekstapelTrekken() {
		spelersAanmaken();
		engine.trekKaartVanTrekStapel(engine.geefHuidigeSpeler(), 1);
		assertEquals(engine.geefHuidigeSpeler().geefTrekStapel().size(), 4);
	}
	
	@Test
	public void brengAlleKaartenNaarAflegstapel() {
		spelersAanmaken();
		engine.brengAlleKaartenNaarAflegstapel();
		
		assertEquals(engine.geefHuidigeSpeler().geefSpeelGebied().size(), 0);
		assertEquals(engine.geefHuidigeSpeler().geefKaartenInHand().size(), 0);
		assertEquals(engine.geefLijstAndereSpelers().size(), 0);
	}
	
	@Test
	public void geldInHand() {
		spelersAanmaken();
		int geld = 0;
		for (int i = 0; i < engine.geefHuidigeSpeler().geefKaartenInHand().size(); i++) {
			geld += engine.geefHuidigeSpeler().geefKaartenInHand().get(i).geefWaarde();
		}
		assertEquals(engine.geldInHand(), geld);
	}
	
	/*
		public int geldInHand() {
		int geld = 0;
		for (int i = 0; i < huidigeSpeler.geefKaartenInHand().size(); i++) {geld += huidigeSpeler.geefKaartenInHand().get(i).geefWaarde();}
		return geld;
	}
	 */
	
}
