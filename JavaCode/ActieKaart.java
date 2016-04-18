package JavaCode;

public class ActieKaart implements Kaart {
	private String KaartType="ActieKaart";
	private String kaartNaam;
	private int cost;
	private int waarde;
	
	public ActieKaart(String naam) {
		this.kaartNaam = naam;
		
		switch (naam) {
		case "village":
			//voer functies uit 
			break;

		default:
			break;
		}
		
	}
	

	@Override
	public String naam() {
		return this.kaartNaam;
	}

	@Override
	public String kaartType() {
		return this.KaartType;
	}

	@Override
	public int kost() {
		return 0;
	}


	@Override
	public int waarde() {
	
		return this.waarde;
	}
	
}
