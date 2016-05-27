package spring.wac;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class TestRequest {
	
	@Autowired
	SimpleUserService userService;
	
	@Autowired
	MockHttpServletRequest request;
	
	private static final String PASS = "password";
	
	@Before
	public void before() throws Exception {
		
		assertNotNull(userService);
		assertNotNull(request);
		
		request.setParameter("user", "enigma");
		request.setParameter("pswd", PASS);
		
	} // -before
	
	@Test
	public void testRequest() throws Exception {
								
//		System.out.println(userService.getLoginAction().getUsername());
		assertEquals(userService.performLogin(), PASS);
		
	} // -testRequest
	
}
