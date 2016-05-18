package engine;

public class Stapel {
	private String stapelNaam;
	private int aantalKaartenInDeStapel;
	public Stapel(String stapelNaam)
	{
		this.stapelNaam = stapelNaam;
		this.aantalKaartenInDeStapel = 10;
	}
	
	public String geefStapelNaam()
	{
		return this.stapelNaam;
	}
	public int geefAatalResterendeKaartenInDeStapel()
	{
		return this.aantalKaartenInDeStapel;
	}
	public void verminderAantalKaarten()
	{
		this.aantalKaartenInDeStapel = -1;
	}
	

}
