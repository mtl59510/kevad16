package spring.profiles;

import static org.junit.Assert.assertEquals;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(VarviKonf.PUNANE)
public class TestPunane extends TestDefaultVarv {
	
	@Override
	public void testVarv() throws Exception {
		assertEquals(VarviKonf.PUNANE, varv.getVarviNimi());
	}
	
}
