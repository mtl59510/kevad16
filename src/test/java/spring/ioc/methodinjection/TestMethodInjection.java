package spring.ioc.methodinjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Demonstrates "method injection" - singletons having prototype dependencies.
 * 
 * @author A
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("method-injection.xml") // TODO where-s the doc?
public class TestMethodInjection extends CommonStuff {	
	
	@Test
	public void testPrototypeDep() throws Exception {
		test();
	}
	
}
