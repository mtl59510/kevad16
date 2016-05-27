package spring.resources;

import java.io.ByteArrayInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestResources {

	@Configuration
	static class Conf {
	}

	@Value("i18n.properties")	// equiv. to XML "value" attr.
	private Resource resource;

	@Test
	public void testResources() throws Exception {

		String expected = "helloworld=Hello World!";

		IOUtils.contentEquals(resource.getInputStream(), new ByteArrayInputStream(expected.getBytes()));

	} // -testResources

}
