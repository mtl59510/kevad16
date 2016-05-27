package kevad;

public class Parissingleton {
	
	static Parissingleton parissingleton;
	
	private Parissingleton() {
		// TODO Auto-generated constructor stub
	}
	
	static public Parissingleton getParissingleton() {
		
		if (Parissingleton.parissingleton == null) {
			Parissingleton.parissingleton = new Parissingleton();
		}
		
		return parissingleton;
	}
	
}
