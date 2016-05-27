package spring.ioc.customscope;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestCustomScopeWithJavaconfig {

	@Configuration
	@ComponentScan("spring.ioc.customscope")
	static class Conf {
		
		@Bean
		public static CustomScopeConfigurer customScope() {
			CustomScopeConfigurer result = new CustomScopeConfigurer();
			result.addScope(TwinScope.TWIN_SCOPE, new TwinScope());
			return result;
		}
		
	} // -conf
	
	@Autowired
	TwinClient tc;
	
	@Test
	public void testCustomScope() throws Exception {
		
		Twin t1 = tc.getTwin();
		Twin t2 = tc.getTwin();
		Twin t3 = tc.getTwin();
		
		assertNotEquals(t1.toString(), t2.toString());
		assertEquals(t2.toString(), t3.toString());
		
	} // -testCustomScope
	
}
