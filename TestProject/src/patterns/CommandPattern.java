package patterns;

import java.util.HashMap;

public class CommandPattern {

	public static void main(String[] args) {
		String validAddress = "Valid address";
		String inValidAddress = "Not a valid address";
		
		Receiver person = new Receiver(validAddress);
		DenyableParcel deny = new DenyableParcel(person);
		DeliverableParcel deliver = new DeliverableParcel(person);
		ParcelService service = new ParcelService();
		
		service.sendParcel(inValidAddress, deny);
		service.sendParcel(validAddress, deliver);
		
		service.dispatch(validAddress);
		service.dispatch(inValidAddress);
	}

}

interface Parcel{
	void deliver();
}

class Receiver {
	
	public Receiver(String validAddress) {
		
	}
	void receiveParcel() {
		System.out.println("Parcel delivered");	
	}
	void denyParcel() {
		System.out.println("Parcel denied");
	}
}

class ParcelService {
	HashMap<String, Parcel> parcels = new HashMap<>();
	void sendParcel(String address, Parcel p) {
		parcels.put(address, p);
	}
	void dispatch(String address) {
		parcels.get(address).deliver();
	}
}

class DenyableParcel implements Parcel{
	
	Receiver receiver;
	public DenyableParcel(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void deliver() {
		receiver.denyParcel();	
	}
}

class DeliverableParcel implements Parcel {
	Receiver receiver;
	public DeliverableParcel(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void deliver() {
		receiver.receiveParcel();	
	}
}