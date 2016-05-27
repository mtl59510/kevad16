package spring.ioc.scopedproxy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AOP-proxy XML demo.
 * 
 * @author A
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("scopedproxy.xml")
public class TestScopedProxy {
	
	@Autowired
	Singleton singleton;
	
	@Test
	public void testScopedProxy() throws Exception {
		
		// did autowire work?
		assertNotNull(singleton);
		
		// fetch
		Prototype p1 = singleton.getPrototype();
		Prototype p2 = singleton.getPrototype();
				
		// expecting to see the same proxy!
		assertSame(p1, p2);
		
		// but Object#toString will be different!
		assertNotEquals(p1.toString(), p2.toString());
		
	} // testScopedProxy
	
}
