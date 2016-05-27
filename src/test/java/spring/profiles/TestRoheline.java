package spring.profiles;

import static org.junit.Assert.assertEquals;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(VarviKonf.ROHELINE)
public class TestRoheline extends TestDefaultVarv {
	
	@Override
	public void testVarv() throws Exception {
		assertEquals(VarviKonf.ROHELINE, varv.getVarviNimi());
	}
	
}
