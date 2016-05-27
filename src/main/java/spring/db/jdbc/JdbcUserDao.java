package spring.db.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.db.UserDao;
import spring.db.domain.User;

@Repository
@Transactional
public class JdbcUserDao implements UserDao {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(JdbcUserDao.class);
	
	UserMappingQuery userMappingQuery;
	SimpleJdbcInsert insertUser;
	
	int i = 0;
	
	// @Required // this would require explicit conf. (?)
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.userMappingQuery = new UserMappingQuery(dataSource);
		this.insertUser = new SimpleJdbcInsert(dataSource).withTableName("user")
				.usingGeneratedKeyColumns("id");
		
	} // -setDataSource
	
	/**
	 * @param u
	 *            {@link User}
	 * @return db generated id
	 */
	@Override
	public Number addUser(User u) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("firstName", u.getFirstName());
		params.put("lastName", u.getLastName());
				
		Number id = insertUser.executeAndReturnKey(params);
		LOGGER.info("Inserted {}", ++i);
		
		if (i > 2) {
			LOGGER.info("Forcing transaction error at {}", i);
			throw new RuntimeException();
		}
		
		u.setId(id.longValue());
		
		return id;
		
	} // -addUser
	
	/**
	 * @see RowMapper
	 * @return
	 */
	@Override
	public List<User> getUsers() {
		return userMappingQuery.execute();
	} // -getUsers
	
}
