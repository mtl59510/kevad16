package spring.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import spring.db.domain.User;

public class UserMappingQuery extends MappingSqlQuery<User> {
	
	private static final String SQL = "SELECT id,firstName,lastName FROM user";
	
	public UserMappingQuery(DataSource dataSource) {
		super(dataSource, SQL);
//		super.declareParameter(new SqlParameter("id", Types.INTEGER));
		compile();
	}
	
	@Override
	protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User u = new User();
		
		u.setId(rs.getLong("id"));
		u.setFirstName(rs.getString("firstName"));
		u.setLastName(rs.getString("lastName"));
		
		return u;
	} // -mapRow
	
}
