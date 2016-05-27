package spring.profiles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = VarviKonf.class)
public class TestDefaultVarv {
	
	@Autowired
	protected Varv varv;
	
	@Test
	public void testVarv() throws Exception {
		assertEquals(VarviKonf.PUNANE, varv.getVarviNimi());
	}
	
}
