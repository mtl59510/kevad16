package spring.domain.i18n;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("i18n.xml")
public class TestI18n {
	
	@Autowired
	MessageSource messageSource;
	
	private static final String KEY = "helloworld";
	
	@Test
	public void testI18n() throws Exception {
		
		// default
		String d = messageSource.getMessage(KEY, null, null);
		assertEquals("Hello World!", d);
		
		// Estonia
		String e = messageSource.getMessage(KEY, null, Locale.forLanguageTag("ET"));
		assertEquals("Joumaailm!", e);
				
	} // -testI18n

}
