package py.com.jwt.config.database;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
	@Bean
	DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(
				"jdbc:mysql://localhost:3306/jwt_database?useSSL=false&useUnicode=true&serverTimezone=America/Asuncion");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("84125497");
		return dataSourceBuilder.build();
	}
}
