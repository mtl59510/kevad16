package spring.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher p;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.p = applicationEventPublisher;
	}

	public void send() {
		p.publishEvent(new DemoEvent(this, "jou-event"));
	}
	
}
