package spring.events;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestEventsJavaconfig {
	
	@Configuration
	@ComponentScan("spring.events")
	static class Conf {
		
		public static Boolean flag = Boolean.FALSE;
		
		@Bean
		AnnotationListener getAnnotationListener() {
			
			return new AnnotationListener() {
				@Override
				public void listen(DemoEvent event) {
					
					Conf.flag = Boolean.TRUE;
					
					super.listen(event);
				}
			};
		} // -getAnnotationListener
		
	} // -Conf
	
	@Autowired
	EventPublisher p;
	
	@Test
	public void testEvents() throws Exception {
		
		p.send();
				
		assertTrue(Conf.flag);
		
	} // -testEvents
	
}
