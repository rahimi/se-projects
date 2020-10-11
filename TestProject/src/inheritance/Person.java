package inheritance;

public abstract class Person implements Biped{
	public String firstName;
	public String lastName;
	public String birthDate;
	
	public Person(String firstName, String lastName, String birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
}
