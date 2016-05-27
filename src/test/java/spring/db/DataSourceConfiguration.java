package spring.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DataSourceConfiguration {
	
	/**
	 * org.apache.commons.dbcp.BasicDataSource
	 * 
	 * @see EmbeddedDatabaseBuilder#addDefaultScripts()
	 * @return {@link DataSource}
	 */
	@Bean
	public DataSource dataSource() {
		
		// prep. embedded db - defaults to HSQL w/o setType()
		DataSource result = new EmbeddedDatabaseBuilder().addScript("spring/db/schema.sql")
				.generateUniqueName(true).build();
		
		return result;
	}
	
}
