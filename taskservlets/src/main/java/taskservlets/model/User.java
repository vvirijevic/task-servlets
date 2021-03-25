package taskservlets.model;

public class User {
	private final String ime;
	private final String prezime;
	private final String email;
	private final String password;
	public User(String ime, String prezime, String email, String password) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
	}
	
	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
