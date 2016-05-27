package spring.db.hibernate;

import static org.junit.Assert.*;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import spring.db.DataSourceConfiguration;
import spring.db.UserDao;
import spring.db.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class TestHibernateUserDao {
	
	@Configuration
	@EnableTransactionManagement
	static class Conf extends DataSourceConfiguration {
		
		@Bean
		UserDao userDao() {
			return new HibernateUserDao();
		}
		
		@Bean
		SessionFactory sessionFactory() {
			
//			Properties props = new Properties();
//			props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
			
			LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(dataSource());
			
			sfb.scanPackages("spring.db.domain");
//			sfb.addProperties(props);
			
			return sfb.buildSessionFactory();
		} // -sessionFactory	
		
		@Bean
		PlatformTransactionManager txManager() {
			return new HibernateTransactionManager(sessionFactory());
		}
		
	} // -conf
	
	@Autowired
	HibernateUserDao userDao;
		
	private User buildUser() {
		User u = new User();
		u.setFirstName("chuck");
		u.setLastName("norris");
		return u;
	}
	
	@Test
	public void test() throws Exception {
		
		assertNotNull(userDao.sessionFactory);
		
		
		userDao.addUser(buildUser());
		userDao.addUser(buildUser());
		
		assertEquals(2, userDao.getUsers().size());
	}
	
}
