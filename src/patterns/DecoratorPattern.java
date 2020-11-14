package patterns;

public class DecoratorPattern {

	public static void main(String[] args) {
		FeaturePhone fp = new FeaturePhone();
		fp.call();
		FourGCapability fourG = new FourGCapability(fp);
		fourG.call();
		BrowserCapability smartPhone = new BrowserCapability(fourG);
		smartPhone.browse();
		smartPhone.call();
	}

}

interface PlainPhone {
	void call();
}

class FeaturePhone implements PlainPhone {
	public void call() {
		System.out.println("Initiating Call");
	}
}

abstract class PhoneDecorator implements PlainPhone {
	private final PlainPhone phone;
	
	public PhoneDecorator(PlainPhone phone) {
		this.phone = phone;
	}
	
	@Override
	public void call() {
		phone.call();	
	}
}

class FourGCapability extends PhoneDecorator{
	public FourGCapability(PlainPhone phone) {
		super(phone);
	}
	
	@Override
	public void call() {
		super.call();
		callWith4G();
	}
	
	private void callWith4G() {
		System.out.println("Using 4G");
	}
}

class BrowserCapability extends PhoneDecorator{

	public BrowserCapability(PlainPhone phone) {
		super(phone);
	}
	
	void browse() {
		System.out.println("Initiating browsing");
	}
	
}
