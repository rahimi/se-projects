package inheritance;

public abstract class Klingon implements Biped {
	public String firstName;
	public String lastName;
	public String honor;
	
	public Klingon(String firstName, String lastName, String honor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.honor = honor;
	}
}
