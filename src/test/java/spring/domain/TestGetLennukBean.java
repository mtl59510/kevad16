package spring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * Demonstrates a {@link ApplicationContext#getBean(Class)};
 * 
 * @author A
 *
 */
public class TestGetLennukBean {

	/**
	 * Not hard-coding the package name.
	 */
	private String XML = ClassUtils.classPackageAsResourcePath(TestGetLennukBean.class) + "/domain.xml";

	@Test
	public void testLennukBean() throws Exception { 
	
		// try-with
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(XML)) {
			
			String s = ctx.getBeanFactory().resolveEmbeddedValue("${planename}");
			
			// fetch & assert
			Lennuk lennuk = ctx.getBean(Lennuk.class);
			assertEquals(s, lennuk.getName());
			
		} // -ctx

	} // -testLennukBean
}
