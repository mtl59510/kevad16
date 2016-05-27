package spring.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestValidation {
	
	@Configuration
	static class Conf {
		
		/**
		 * Configure a Validaton provider - note that this requires e.g.
		 * Hibernate Validator at Classpath!
		 * 
		 * @return implements {@link Validator}
		 */
		@Bean
		LocalValidatorFactoryBean getValidator() {
			LocalValidatorFactoryBean res = new LocalValidatorFactoryBean();
			return res;
		}
		
		@Bean
		PersonValidator getPersonValidaotor() {
			return new PersonValidator();
		}
		
	} // -conf
	
	@Autowired
	Validator validator;
	
	@Autowired
	PersonValidator pv;
	
	@Before
	public void before() throws Exception {
		
		assertNotNull(validator);
		assertNotNull(pv);
		
	}
	
	@Test
	public void testWithViolations() throws Exception {
		
		Person p = new Person();
		validator.validate(p);
		
		// validation errors
		assertFalse(validator.validate(p).isEmpty());
		
	} // -testValidation
	
	@Test
	public void testValidation() throws Exception {
		
		Person p = new Person();
		p.setName("heli kopter");
		p.setAge(55);
		
		// empty
		assertTrue(validator.validate(p).isEmpty());
		
	} // -testValidation
	
	@Test
	public void testCustomValidator() throws Exception {
		
		Person p = new Person();
		p.setAge(200);
		
		DataBinder db = new DataBinder(p);
		db.addValidators(pv);
		
		db.validate(p);
		
		assertEquals("too.darn.old",
				db.getBindingResult().getFieldError("age").getCode());
		
	} // -testCustomValidator
	
}
