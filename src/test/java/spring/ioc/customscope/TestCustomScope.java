package spring.ioc.customscope;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration	// NOTE this would resolve to classname-context.xml!
public class TestCustomScope {
	
	@Autowired
	TwinClient tc;
	
	@Test
	public void testCustomScope() throws Exception {
		Twin t1 = tc.getTwin();
		Twin t2 = tc.getTwin();
		Twin t3 = tc.getTwin();
		
		assertNotEquals(t1.toString(), t2.toString());
		assertEquals(t2.toString(), t3.toString());
	}
	
}
