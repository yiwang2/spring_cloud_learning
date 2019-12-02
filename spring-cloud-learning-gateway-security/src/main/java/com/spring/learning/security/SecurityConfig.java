package com.spring.learning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.spring.learning.security.handler.*;

@EnableWebFluxSecurity
public class SecurityConfig {

	private static final String[] excludedAuthPages = { "/auth/login", "/auth/logout", "/health", "/api/socket/**" };

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private AuthenticationFaillHandler authenticationFaillHandler;
	@Autowired
	private AuthorizationFailedHandler customHttpBasicServerAuthenticationEntryPoint;

	@Bean
	SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
		http.authorizeExchange().pathMatchers(excludedAuthPages).permitAll() // no need auth
				.pathMatchers(HttpMethod.OPTIONS).permitAll() // http options are fine
				.anyExchange().authenticated().and().httpBasic().and().formLogin().loginPage("/auth/login")
				.authenticationSuccessHandler(authenticationSuccessHandler) // login successful
				.authenticationFailureHandler(authenticationFaillHandler) // login failed
				.and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint) // exception
																													// handler
				.and().csrf().disable()// cross domain enabled
				.logout().disable();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
