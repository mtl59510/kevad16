package spring.domain.propertysource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestPropertySource {
	
	@Configuration
	@PropertySource("spring/domain/propertysource/propertysource.properties")
	static class Conf {
		
		@Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }
		
	} // -Conf
	
	@Autowired
	private Environment env;
	
	@Value("${xxx}")
	private String val; // ENABLE PropertySourcesPlaceholderConfigurer!
	
	@Test
	public void testEnv() throws Exception {
		assertEquals("yyy", env.getProperty("xxx"));
		assertEquals("yyy", val);
	}
	
}
