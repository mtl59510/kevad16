package spring.ioc.methodinjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MethodInjectionConfiguration.class)
public class TestWithJavaConfig extends CommonStuff {
		
	@Test
	public void testCommandManager() throws Exception {
		test();
	}
	
}
