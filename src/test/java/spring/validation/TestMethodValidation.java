package spring.validation;

import static org.junit.Assert.assertEquals;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestMethodValidation {
	
	@Configuration
	static class Conf {
		
		@Bean
		MethodValidationPostProcessor getMethodValidator() {
			return new MethodValidationPostProcessor();
		}
		
		@Bean
		MethodValidationInterceptor validationInterceptor() {
			return new MethodValidationInterceptor();
		}
		
		@Bean
		MethodValidated getMethodValidated() {
			return new MethodValidated();
		}
		
	} // -conf
	
	@Autowired
	MethodValidated methodValidated;
	
	@Test(expected = ConstraintViolationException.class)
	public void testViolation() throws Exception {
		methodValidated.getName();
	}
	
	@Test
	public void testSatisfiedConstraint() throws Exception {
		final String token = "not-empty";
		methodValidated.setName(token);
		assertEquals(token, methodValidated.getName());
	}
	
}
