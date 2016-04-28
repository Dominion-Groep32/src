package testen;

import java.util.LinkedList;
import org.junit.*;

import engine.GameEngine;
import engine.Kaart;
import engine.Speler;





public class TestFuncties {
	GameEngine Engine = new GameEngine();
	Speler speler = new Speler("testspeler");
	LinkedList<Kaart> testlijst = speler.startKaarten();
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	@Test
	public void startKaartenTest()
	{
		if (!speler.startKaarten().equals(10))
		{
		}
		else
		{System.err.println("fail");}
	}
	
	@Test
	public void maakLijstLeeg()
	{
		testlijst.clear();
		if (testlijst.size() == 0) {
			
		}
		else {
			System.err.println("fail");
		}
		
	}
	
	@Test
	public void samenVoegen()
	{
		
	}
	
	
	

}
