package spring.ioc.scopedproxy;

public class Singleton {

	private Prototype prototype;
	
	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}
	
	public Prototype getPrototype() {
		return prototype;
	}
	
}
