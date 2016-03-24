package JavaCode;

import static org.junit.Assert.*;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool;
import org.junit.Test;

import com.sun.prism.paint.Gradient;

public class GameActionsTester {
	
	GameActions action = new GameActions();
	CardDetails card = new CardDetails();

	@Test
	public void test() {
		
		if (action.startDeckCards().size()!= 10)
			System.out.println("startDeck Fails");
		
		
	}

	@Test
	public void TweedeTest(){
		
		
	}
}
