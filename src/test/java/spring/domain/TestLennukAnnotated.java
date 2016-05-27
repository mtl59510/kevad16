package spring.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestPropertySource(properties = "planename=" + TestLennukAnnotated.TOKEN)
public class TestLennukAnnotated {
	
	static final String TOKEN = "TU";
	
	@Configuration
	@PropertySource("/spring/domain/lennuk.properties")
	static class Conf {
		
		@Value("${planename}")
		String planeName;
		
		@Bean
		static PropertySourcesPlaceholderConfigurer getConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
		
		@Bean
		Lennuk getLennuk() {
			Lennuk res = new Lennuk();
			res.setName(planeName);
			return res;
		}
		
	} // -conf
	
	@Autowired
	Lennuk lennuk;
	
	@Test
	public void testLennuk() throws Exception {
		assertEquals(TOKEN, lennuk.getName());
	}
	
}
