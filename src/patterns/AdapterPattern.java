package patterns;

public class AdapterPattern {

	public static void main(String[] args) {
		USBCharger usbCharger = new USBCharger();
		IPhone iphone = new IPhone();
		AndroidUSB android = new AndroidUSB();
		LightningToUSBAdapter adapter = new LightningToUSBAdapter(iphone);
		usbCharger.charge(android);
		usbCharger.charge(iphone);
		usbCharger.charge(adapter);
		
	}
}

class USBCharger{
	void charge(Rechargable<Type> phone) {
		if (phone instanceof USB) {
			USB usbPhone =((USB) phone); 
			usbPhone.connect();
			phone.recharge(usbPhone);
		}else {
			System.out.println("Cannot connect lighintng phone to usb");
		}
	}
}

interface Rechargable<T extends Type>{
	public void recharge(T type);
}

interface Type{
	void connect();
}

interface USB extends Type{
	void connectUSB();
}

interface Lightining extends Type{
	void connectLightning();
}

class AndroidUSB implements Rechargable<Type>, USB{
	public void connect() {
		connectUSB();
	}

	public void recharge(Type type) {
		if (type instanceof USB) {
			connect();
			System.out.println(this.getClass().getSimpleName() + " charging");
		}
	}

	public void connectUSB() {}
}

class IPhone implements Rechargable<Type>, Lightining{
	public void recharge(Type type) {
		if (type instanceof Lightining) {
			connect();
			System.out.println(this.getClass().getSimpleName() + " charging");
		}
	}
	public void connect() {connectLightning();}
	public void connectLightning() {}	
}

class LightningToUSBAdapter implements Rechargable<Type>, USB, Lightining{

	Rechargable<Type> phone;
	
	public LightningToUSBAdapter(Rechargable<Type> phone) {
		this.phone = phone;
	}
	public void connect() {
		System.out.println(this.getClass().getSimpleName() + " adapted "+phone.getClass().getSimpleName());
	}
	
	public void recharge(Type type) {
		if (phone instanceof USB) {
			((USB)phone).connectUSB();
			phone.recharge((USB)phone);
		}else if(phone instanceof Lightining) {
			((Lightining)phone).connectLightning();
			phone.recharge((Lightining)phone);
		}
	}

	public void connectLightning() {
		connect();
	}

	public void connectUSB() {
		connect();
	}
	
}


