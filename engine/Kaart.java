package engine;

import console.ConsoleSpel;

public interface Kaart {
	GameEngine engine = new GameEngine();
	ConsoleSpel console = new ConsoleSpel();
	public String naam();
	public String kaartType();
	public int kost();
	public int waarde();
	
	

	
	

	

	
	
}
