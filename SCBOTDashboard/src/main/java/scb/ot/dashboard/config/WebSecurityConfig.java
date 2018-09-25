package scb.ot.dashboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig {

	public final static String SESSION_KEY = "SESSION_KEY";

	@Autowired
	private AuthenticationInterceptor authenticationInterceptor;

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				InterceptorRegistration registration = registry.addInterceptor(authenticationInterceptor);
				registration.addPathPatterns("/**").excludePathPatterns("/error").excludePathPatterns("/login**");
			}
		};
	}

}