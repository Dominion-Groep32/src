package JavaCode;

import static org.junit.Assert.*;

import org.junit.*;

public class KaartenTest {
	
	Kaarten kaart = new Kaarten();
	int Getal1 = 1;
	int Getal2 = 1;
	int beurten = 1;
	
	
	

	@Test
	public void canari() {
		System.out.println("it works");
		
	}
	
	@Test
	public void TestOptellen(){
		assertEquals(Getal1,Getal2,0.01);
	}
	

}
