package scb.ot.dashboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "scb.ot.dashboard")
public class DashboardConfig {

	//TODO not currently in used, reserved for further updates
	
//	@Autowired
//	private Environment env;

//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//
//		dataSource.setUsername(env.getRequiredProperty("DATASOURCE_USERNAME"));
//		dataSource.setPassword(env.getRequiredProperty("DATASOURCE_PASSWORD"));
//		dataSource.setUrl(env.getRequiredProperty("DATASOURCE_URL"));
//		dataSource.setDriverClassName(env.getRequiredProperty("DATASOURCE_DRIVER"));
//
//		return dataSource;
//	}
}
