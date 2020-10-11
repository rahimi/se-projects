package inheritance;

public abstract class Person {
	public String firstName;
	public String lastName;
	public String birthDate;
	
	public Person(String firstName, String lastName, String birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public abstract void printInfo();
}
