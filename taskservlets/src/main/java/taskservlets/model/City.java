package taskservlets.model;

public class City {
	private final int PTT;
	private final String naziv;
	public City(int PTT, String naziv) {
		super();
		this.PTT = PTT;
		this.naziv = naziv;
	}
	public int getPTT() {
		return PTT;
	}
	public String getNaziv() {
		return naziv;
	}
	@Override
	public String toString() {
		return "City [PTT=" + PTT + ", naziv=" + naziv + "]";
	}
	
}
