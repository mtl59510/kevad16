package spring.db.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.annotation.Transactional;

import spring.db.UserDao;
import spring.db.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class TestJdbcUserDao {
	
	@Configuration
//	@ComponentScan
	static class Conf extends JdbcConfiguration {
				
		@Bean
		UserDao userDao() {
			return new JdbcUserDao();
		}
		
	} // -Conf
	
	@Autowired
	UserDao dao;
	
	private static User chuck;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		chuck = new User();
		
		chuck.setFirstName("chuck");
		chuck.setLastName("norris");
	}
	
	@Test
//	@Commit
	public void testUserDaoInsert() throws Exception {
		
//		assertNotNull(dao.jdbcTemplate);
				
		// insert
		dao.addUser(chuck);
		dao.addUser(chuck);
		
		List<User> users = dao.getUsers();
		
		assertEquals(2, users.size());
		
		// assert id-s won-t match
		assertNotEquals(users.get(0).getId(), users.get(1).getId());
		
//		JdbcTestUtils.countRowsInTable(dao.jdbcTemplate, "user")
	} // -testUserDaoInsert
	
	@Test(expected = RuntimeException.class)
	public void testTx() throws Exception {
		
		dao.addUser(chuck);
		
	}
	
	@AfterTransaction
	public void after() throws Exception {
		assertEquals(0, dao.getUsers().size());
	}
	
}
