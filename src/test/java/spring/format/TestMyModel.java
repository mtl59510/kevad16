package spring.format;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Ignore
// TODO is there a way to test this w/ junit?
public class TestMyModel {

	@Configuration
	static class Conf {
		
		@Bean
		MyModel getMyModel() {
			MyModel result = new MyModel();
			result.date = new Date();
			return result;
		}
		
	}
	
	@Autowired
	MyModel myModel;
	
	@Test
	public void testMyModel() throws Exception {
		assertNotNull(myModel);
		
		System.out.println(myModel.date);
	}
	
}
