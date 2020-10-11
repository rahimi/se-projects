package test;

import inheritance.Car;
import inheritance.Vehicle;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Vehicle genericVehicle = new Vehicle(4, "Generic", "Vehicle");
		Vehicle bmw = new Car(4, "BMW", "M2", 2, 2);
		
		System.out.println(genericVehicle.make);
		System.out.println(bmw.make);
		
		genericVehicle.start();
		bmw.start();
		
		genericVehicle.getVehicle(); //calls getVehicle of Vehicle
		bmw.getVehicle();			 //calls getVehicle of Car
		
		genericVehicle = bmw;
		bmw = genericVehicle;
		
	}

}
