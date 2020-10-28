package patterns;

import java.util.ArrayList;

public class InterpreterPattern {

	public static void main(String[] args) {
		HomeOffice thomasHO = new HomeOffice("Thomas");
		HomeOffice johannaHO = new HomeOffice("Johanna");
		HomeOffice herbertHO = new HomeOffice("Herbert");
		HomeOffice lisaHO = new HomeOffice("Lisa");
		HeadOffice hamburg = new HeadOffice("Hamburg Office");
		HeadOffice cologne = new HeadOffice("Köln Office");
		HeadOffice nrw = new HeadOffice("NRW Headquater");
		HeadOffice corporate = new HeadOffice("Corporate Headquater Dubai");
		corporate.subOffices.add(nrw);
		corporate.subOffices.add(hamburg);
		hamburg.subOffices.add(thomasHO);
		nrw.subOffices.add(cologne);
		cologne.subOffices.add(johannaHO);
		cologne.subOffices.add(herbertHO);
		cologne.subOffices.add(lisaHO);
		
		corporate.work(Context.remote);
	}
}

enum Context{remote, onsite}

interface Office{
	void work(Context c);
}

class HomeOffice implements Office{
	String name;
	public HomeOffice(String name) {
		this.name = name;
	}
	
	@Override
	public void work(Context c) {
		if (c == Context.remote) {
			System.out.println(name + " working from remote!");
		}
	}
}

class HeadOffice implements Office{
	String name;
	ArrayList<Office> subOffices = new ArrayList<>();
	
	public HeadOffice(String name) {
		this.name = name;
	}
	
	@Override
	public void work(Context c) {
		if(c == Context.onsite) {
			System.out.println(name + " working onsite!");
		}
		subOffices.forEach((o)->o.work(c));
	}
	
	
}