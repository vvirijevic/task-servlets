package taskservlets.model;

public class Product {
	private final int sifra;
	private final String naziv;
	private final double cena;
	private final double poreskaStopa;
	private final String valuta;
	private final String mernaJedinica;
	private final Manufacturer proizvodjac;
	public Product(int sifra, String naziv, double cena, double poreskaStopa, String valuta, String mernaJedinica,
			Manufacturer proizvodjac) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
		this.poreskaStopa = poreskaStopa;
		this.valuta = valuta;
		this.mernaJedinica = mernaJedinica;
		this.proizvodjac = proizvodjac;
	}
	public int getSifra() {
		return sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public double getCena() {
		return cena;
	}
	public double getPoreskaStopa() {
		return poreskaStopa;
	}
	public String getValuta() {
		return valuta;
	}
	public String getMernaJedinica() {
		return mernaJedinica;
	}
	public Manufacturer getProizvodjac() {
		return proizvodjac;
	}
	@Override
	public String toString() {
		return "Product [sifra=" + sifra + ", naziv=" + naziv + ", cena=" + cena + ", poreskaStopa=" + poreskaStopa
				+ ", valuta=" + valuta + ", mernaJedinica=" + mernaJedinica + ", proizvodjac=" + proizvodjac + "]";
	}
	
	
}
