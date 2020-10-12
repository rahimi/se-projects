package patterns;

public class BuilderPattern {

	public static void main(String[] args) {
		PersonBuilder pb = new PersonBuilder();
		Person homerSimpson = pb.createPerson()
							 .withFirstName("Homer")
							 .withLasrName("Simpson")
							 .withAddress("742 Evergreen Terace")
							 .withSpouse(new PersonBuilder()
									 		.createPerson()
									 		.withFirstName("Marge")
									 		.withLasrName("Simpson")
									 		.withAddress("742 Evergreen Terace")
									 		.getPerson())
							 .getPerson();
	}
}

class PersonBuilder {
	Person toBeBuild;
	
	PersonBuilder createPerson() {
		toBeBuild = new Person();
		return this;
	}
	PersonBuilder withFirstName(String name) {
		toBeBuild.name = new Name(name);
		return this;
	}
	PersonBuilder withLasrName(String name) {
		toBeBuild.lastName = new Name(name);
		return this;
	}
	PersonBuilder withAddress(String address) {
		toBeBuild.adress = new Address(address);
		return this;
	}
	PersonBuilder withSpouse(Person p) {
		toBeBuild.spouse = p;
		return this;
	}
	Person getPerson() {
		return toBeBuild;
	}
}

class Person {
	Name name;
	Name lastName;
	Address adress;
	Person spouse;
}

class Name {
	String name;
	public Name(String name) {
		this.name = name;
	}
}

class Address {
	String address;
	public Address(String address) {
		this.address = address;
	}
}
