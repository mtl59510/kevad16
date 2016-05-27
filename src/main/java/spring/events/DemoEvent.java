package spring.events;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 3579820990842011077L;
	
	private final String message;
	
	public DemoEvent(Object source, String message) {
		super(source);
		
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
