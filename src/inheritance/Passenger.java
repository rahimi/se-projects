package inheritance;

public class Passenger extends Person{
	Vehicle vehicle;
	private boolean walking;
	
	public Passenger(String firstName, String lastName, String birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	public void enterVehicle(Vehicle v) {
		if (v instanceof Car) {
			Car c = (Car)v;
			c.addPassenger();
		}
		this.vehicle = v;
	}

	public void printInfo() {
		System.out.println(
				String.format("Name: %s, Firstname:%s, Birthday:%s", 
						      lastName,firstName,birthDate));
	}

	@Override
	public void walk() {
		System.out.println(firstName+" is walking!");
		walking = true;
	}
}
