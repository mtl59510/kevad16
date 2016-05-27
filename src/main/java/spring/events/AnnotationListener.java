package spring.events;

import org.springframework.context.event.EventListener;

//@Component // defining and overriding listen() explicitly during test
public class AnnotationListener {
		
	@EventListener(condition = "#event.message == 'jou-event'")
	public void listen(DemoEvent event) {
//		LOGGER.warn(event.getMessage());
	}
	
	// negating SpEL
	@EventListener(condition = "#event.message != 'jou-event'")
	public void listenIgnore(DemoEvent event) {
		throw new RuntimeException("this shouldn-t happen");
	}
	
}
