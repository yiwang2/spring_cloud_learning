package com.spring.learning.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.learning.security.util.MD5Encoder;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.User;

import reactor.core.publisher.Mono;

@Component
public class SecurityUserDetailsService implements ReactiveUserDetailsService {

	@Value("${spring.security.user.name}")
	private String userName;

	@Value("${spring.security.user.password}")
	private String password;

	public Mono<UserDetails> findByUsername(String username) {
		// we use an existing user name and password
		// we could query db for user auth information
		if (StringUtils.equals(userName, username)) {
			UserDetails user = User.withUsername(userName).password(MD5Encoder.encode(password, username))
					.roles("admin").authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("admin")).build();
			return Mono.just(user);
		} else {
			return Mono.error(new UsernameNotFoundException("User Not Found"));

		} 

	}

}
