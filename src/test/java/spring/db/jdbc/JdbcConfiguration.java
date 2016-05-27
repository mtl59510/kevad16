package spring.db.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.db.DataSourceConfiguration;

@Configuration
@EnableTransactionManagement
public class JdbcConfiguration extends DataSourceConfiguration {
	
	@Bean
	PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
