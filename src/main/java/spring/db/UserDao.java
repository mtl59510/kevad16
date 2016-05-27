package spring.db;

import java.util.List;

import spring.db.domain.User;

public interface UserDao {
	
	Number addUser(User u);
	List<User> getUsers();
	
}
