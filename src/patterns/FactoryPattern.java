package patterns;

public class FactoryPattern {

	public static void main(String[] args) {
		AbstractFactory factory = FactoryProvider.getFactory(AbstractFactory.Type.ELECTRONICS);
		Product p = factory.create(ElectronicsProduct.Type.PHONE.toString());
		p.turnOn();
	}
}

class FactoryProvider{
	public static AbstractFactory getFactory(AbstractFactory.Type type) {
		if(type == AbstractFactory.Type.ELECTRONICS) {
			return new ElectronicsFactory();
		}else {
			System.err.println("Cannot get "+type+" factory");
			return null;
		}
	}
}

interface AbstractFactory<T,N extends Product>{
	enum Type{ELECTRONICS, TOYS, STUFF}
	T getFactory(AbstractFactory.Type factoryType);
	N create(String productType);
}

class ElectronicsFactory implements AbstractFactory<ElectronicsFactory, ElectronicsProduct>{
	public ElectronicsFactory getFactory(Type factoryType) {
		return this;
	}

	public ElectronicsProduct create(String productType) {
		if(productType == ElectronicsProduct.Type.TV.toString()) {
			return new OledTV();
		}else if(productType == ElectronicsProduct.Type.PHONE.toString()){
			return new Android();
		}else if(productType == ElectronicsProduct.Type.LAPTOP.toString()) {
			return new MacBook();
		}else {
			System.err.println("Cannot create "+productType+" product");
			return null;
		}
	}
}

interface Product{
	void turnOn();
}

interface ElectronicsProduct extends Product{
	enum Type {TV, PHONE, LAPTOP}
}

class OledTV implements ElectronicsProduct {
	public void turnOn() {
		System.out.println("OLED TV");
	}
}
class Android implements ElectronicsProduct {
	public void turnOn() {
		System.out.println("Android Phone");
	}
}
class MacBook implements ElectronicsProduct {
	public void turnOn() {
		System.out.println("MacBook Laptop");
	}
}
