package taskservlets.model;

public class Manufacturer {
	private final int pib;
	private final int mBr;
	private final String naziv;
	private final String adresa;
	private final City grad;
	public Manufacturer(int pib, int mBr, String naziv, String adresa, City grad) {
		super();
		this.pib = pib;
		this.mBr = mBr;
		this.naziv = naziv;
		this.adresa = adresa;
		this.grad = grad;
	}
	public int getPib() {
		return pib;
	}
	public int getmBr() {
		return mBr;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public City getGrad() {
		return grad;
	}
	@Override
	public String toString() {
		return "Manufacturer [pib=" + pib + ", mBr=" + mBr + ", naziv=" + naziv + ", adresa=" + adresa + ", grad="
				+ grad + "]";
	}
	
	
}
