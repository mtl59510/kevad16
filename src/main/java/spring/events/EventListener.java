package spring.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<DemoEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventListener.class);
	
	@Override
	public void onApplicationEvent(DemoEvent event) {
		LOGGER.warn(event.getMessage());
	}

}
