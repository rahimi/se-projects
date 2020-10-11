package inheritance;

public class Passenger extends Person{
	Vehicle vehicle;
	
	public Passenger(String firstName, String lastName, String birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	public void enterVehicle(Vehicle v) {
		
		this.vehicle = v;
	}

	public void printInfo() {
		System.out.println(
				String.format("Name: %s, Firstname:%s, Birthday:%s", 
						      lastName,firstName,birthDate));
	}
}
