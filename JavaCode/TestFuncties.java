package JavaCode;

import java.util.LinkedList;
import org.junit.*;



import static org.junit.Assert.*;

public class TestFuncties {
	GameEngine Engine = new GameEngine();
	
	@Test
	public void mainTest(){
		System.out.println("this works");
	}
	
	@Test
	public void startKaartenTest(){
		if (!Engine.startKaarten().equals(10)){
		}
		else {
			System.err.println("fail");
		}
	}
	
	

}
