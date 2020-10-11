package inheritance;

public class Car extends Vehicle {
	public int numberOfDoors;
	public int numberOfPassengers;
	
	public Car(int numberOfWheels, String make, String model, 
			   int numberOfDoors, int numberOfPassengers) {
		super(numberOfWheels, make, model);
		this.numberOfDoors = numberOfDoors;
		this.numberOfPassengers = numberOfPassengers;
	}

	public void addPassenger() {}
	public void addPassenger(Passenger p) {}
	public void addPassenger(String name) {}
	
	@Override
	public Car getVehicle() {
		return this;
	}
}
