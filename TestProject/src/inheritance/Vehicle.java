package inheritance;

public class Vehicle {
	public int numberOfWheels;
	public String make;
	public String model;
	
	public Vehicle(int numberOfWheels, String make, String model) {
		super();
		this.numberOfWheels = numberOfWheels;
		this.make = make;
		this.model = model;
	}
	//public boolean start() {...}
	//public boolean stop() {...}
	//public boolean move(Position p) {...}
	
	public Vehicle getVehicle() {
		return this;
	}
}


