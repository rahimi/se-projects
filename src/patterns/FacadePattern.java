package patterns;

public class FacadePattern {

	public static void main(String[] args) {
		FacadePhone phone = new FacadePhone();
		phone.turnOn();
	}

}

class FacadePhone{
	Powersupply powersupply = new Powersupply();
	Display display = new Display();
	Modem modem = new Modem();
	CPU cpu = new CPU();
	GPU gpu = new GPU();
	
	void turnOn() {
		powersupply.turnOn();
		cpu.turnOn();
		gpu.turnOn();
		display.turnOn();
		modem.turnOn();
		System.out.println("=> Phone turnedOn");
	}
}

class Display{void turnOn() {System.out.println("Display turned on");}}
class Modem{void turnOn() {System.out.println("Modem turned on");}}
class CPU{void turnOn() {System.out.println("CPU turned on");}}
class GPU{void turnOn() {System.out.println("GPU turned on");}}
class Powersupply{void turnOn() {System.out.println("Powersupply turned on");}}