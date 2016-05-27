package spring.db.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.db.UserDao;
import spring.db.domain.User;

@Repository
public class HibernateUserDao implements UserDao {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public Number addUser(User u) {
		sessionFactory.getCurrentSession().save(u);
//		sessionFactory.getCurrentSession().flush();
		return null;
	}
	
	@Override
	public List<User> getUsers() {
		return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
	}
	
}
