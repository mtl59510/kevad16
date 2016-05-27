package spring.propertyeditor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("propertyeditor.xml")
public class TestPropertyEditor {
	
	@Autowired
	DependsOnExoticType d;
	
	@Test
	public void testPropertyEditor() throws Exception {
		assertEquals(d.getType().getName(), "aNameforExoticType".toUpperCase());
	}
	
}
