package patterns;

public class SingletonPattern {

	public static void main(String[] args) {
		Singleton singleInstance1 = Singleton.getInstance();
		Singleton singleInstance2 = Singleton.getInstance();
		
		System.out.println(singleInstance1==singleInstance2);
	}
}

class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		synchronized (instance) {
			if(instance == null) {
				instance = new Singleton();
			}
		}
		return instance;
	}
}