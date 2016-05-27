package spring.events;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("eventsdemo.xml")
public class TestEvents {
	
	@Autowired
	EventPublisher p;
	
	@Test
	public void testEvents() throws Exception {
		// TODO this needs a nice test
		p.send();
	}
	
}
