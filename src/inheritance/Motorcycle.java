package inheritance;

public class Motorcycle extends Vehicle {
	public int forkSuspension;
	
	public Motorcycle(int numberOfWheels, String make, String model, 
					  int forkSuspension) {
		super(numberOfWheels, make, model);
		this.forkSuspension = forkSuspension;
	}

	public void mount(Passenger p) {}
}
