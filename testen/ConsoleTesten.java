package testen;

import org.junit.Test;

import console.ConsoleSpel;
import engine.GameEngine;
import engine.Speler;

public class ConsoleTesten {
	GameEngine engine = new GameEngine();
	Speler speler = new Speler("testspeler");
	ConsoleSpel console = new ConsoleSpel();
	
	@Test
	public void mainTest(){System.out.println("this works");}
	
	//@Test
	//public void test(){
	
	//}
}
