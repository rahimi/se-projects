package patterns;

public class BridgePattern {

	public static void main(String[] args) {
		BridgePerson me = new AndroidPerson();
		me.callMom();
		me = new ApplePerson();
		me.callMom();
		me.usePhone(Phone.android());
		me.callMom();
	}
}

@FunctionalInterface
interface Phone {
    void call(String message);
    
    static Phone apple() {
        return message -> System.out.println("Apple Calling: " + message);
    }
    static Phone android() {
        return message -> System.out.println("Android Calling: " + message);
    }
}

abstract class BridgePerson{
	Phone phone;
	
	void usePhone(Phone phone) {
		this.phone = phone;
	}
	abstract void callMom();
}

class ApplePerson extends BridgePerson {
	public ApplePerson() {
		phone = Phone.apple();
	}
	void callMom() {phone.call("MOM");}
}
class AndroidPerson extends BridgePerson {
	public AndroidPerson() {
		phone = Phone.android();
	}
	void callMom() {phone.call("MOM");}
}