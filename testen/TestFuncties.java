package testen;

import java.util.LinkedList;
import org.junit.*;

import engine.GameEngine;
import engine.Kaart;





public class TestFuncties {
	GameEngine Engine = new GameEngine();
	LinkedList<Kaart> testlijst = Engine.startKaarten();
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	@Test
	public void startKaartenTest()
	{
		if (!Engine.startKaarten().equals(10))
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
