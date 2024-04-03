package py.com.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;
import py.com.jwt.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

	private final AuthenticationProvider authenticationProvider;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> {
			try {
				csrf.disable().authorizeHttpRequests(
						(authz) -> authz
						.requestMatchers("/api/auth/login/**")
						.permitAll().anyRequest()
						.authenticated()
						)
						.authenticationProvider(authenticationProvider)
						.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		);

		return http.build();
	}

}
